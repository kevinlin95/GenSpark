
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

class HangmanNew {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("HANGMAN GAME");
            System.out.println("1 or 2 players?");
            String players = keyboard.nextLine();
            String word = playerOneOrTwo(players, keyboard);
            List<Character> playerGuesses = new ArrayList<>();

            int incorrectCount = 0; // tracking the hanged-man
            while (true) {
                printHangedMan(incorrectCount);
                if (incorrectCount >= 6) {
                    System.out.println("You Lose!");
                    System.out.println("The word was" + word);
                    break;
                }
                printWordState(word, playerGuesses);
                if (!getPlayerGuess(keyboard, word, playerGuesses)) {
                    incorrectCount++;
                }
                if (printWordState(word, playerGuesses)) {
                    System.out.println("You win!");
                    break;
                }
            }
        }while(playAgainYesNo(keyboard));
        System.exit(0);
    }
    private static String playerOneOrTwo(String input, Scanner keyboard) throws FileNotFoundException {
        String word;
        if(Objects.equals(input, "1")){
            Scanner file = new Scanner(new File("/Users/kevinsmacbookair/Downloads/output-onlinerandomtools.txt"));
            List<String> words = new ArrayList<>();
            while (file.hasNext()) {
                //taking the txt that has random words and adding them to list.
                words.add(file.nextLine());
            }
            //making sure a random word is picked from the list.
            Random rand = new Random();
            word = words.get(rand.nextInt(words.size()));
        }
        else{
            System.out.println("Player 1, please enter a word");
            word = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Game start!");
        }
        return word;
    }

    private static boolean playAgainYesNo(Scanner keyboard) {
        System.out.println("Would you like to play again? Y or N");
        String playAgain = keyboard.nextLine();
        return Objects.equals(playAgain, "Y") || Objects.equals(playAgain, "y");
    }

    private static void printHangedMan(int incorrectCount) {
        System.out.println("+-----+");
        System.out.println(" |     ");
        if(incorrectCount >= 1){
            System.out.println(" O");
        }
        if(incorrectCount >= 2){
            System.out.print("\\ ");
            if(incorrectCount >= 3){
                System.out.print("/ ");
                System.out.println();
            }
        }
        if(incorrectCount >= 4){
            System.out.println(" |");
        }
        if(incorrectCount >= 5) {
            System.out.print("/ ");
            if (incorrectCount >= 6) {
                System.out.print("\\ ");
            }
        }
    }

    private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter.");
        String letterGuess = keyboard.nextLine();
        try { // getting player input -> improper input, and more than 1 char input
            if(letterGuess.length() == 1) {
                playerGuesses.add(letterGuess.charAt(0));
            }else
                throw new InputMismatchException();
        }catch(InputMismatchException e){
            System.out.println("Needs to be a letter! a - z");
            return true; // improper input doesn't increase fail counter
        }
        return word.contains(letterGuess);
    }
    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for(int i = 0; i < word.length(); i++){
            if(playerGuesses.contains(word.charAt(i))){
               System.out.print(word.charAt(i));
                correctCount++;
            }
            else{
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }
}

