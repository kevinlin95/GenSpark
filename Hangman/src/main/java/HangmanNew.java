import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

class HangmanNew {

    DisplayImage image;
    private static int drawCounter;
    private String playerOneName;
    private static final List<String> words = new ArrayList<>();
    private static final List<Character> playerGuesses = new ArrayList<>();

    public HangmanNew(){}
    public HangmanNew(DisplayImage image){
        this.image = image;
    }
    public static void playerLog(String name, int score, String word) {
        try { // outputting score depending on missed attempts.
            int temp = switch (score) {
                case 0 -> 100;
                case 1 -> 90;
                case 2 -> 80;
                case 3 -> 70;
                case 4 -> 60;
                case 5 -> 50;
                default -> 0;
            };
            FileWriter file = new FileWriter(("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/HangmanScores.txt"), true);
            file.write("Name: " + name + "  Score: " + temp + "  Word: " + word);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String playerOne(HangmanNew playerOneGame, Scanner keyboard) throws FileNotFoundException {
        String word;
        System.out.println("What is your name?");
        playerOneGame.setPlayerOneName(keyboard.nextLine());
        Scanner file = new Scanner(new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/HangmanRandomWords.txt"));
        while (file.hasNext()) {
            //taking the txt that has random words and adding them to list.
            words.add(file.nextLine());
        }
        //making sure a random word is picked from the list.
        Random rand = new Random();
        word = words.get(rand.nextInt(words.size()));
        return word;
    }

    public static boolean playAgainYesNo(Scanner keyboard) {
        System.out.println("Would you like to play again? Y or N");
        String playAgain = keyboard.nextLine();
        return Objects.equals(playAgain, "Y") || Objects.equals(playAgain, "y");
    }


    public static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
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
    public static boolean printWordState(String word, List<Character> playerGuesses) {
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
    public void printHangedMan(Graphics2D g) {
        int baseX = 100;    // center of figure
        int baseY = 400;    // floor (bottom of feet)
        int height = 250;    // height of stick figure
        int top = baseY - height;  // top of head
        switch (drawCounter) {
            case 1 -> g.drawOval (baseX -10, top, 20, 20);
            case 2 -> {
                g.drawOval (baseX -10, top, 20, 20);
                g.drawLine (baseX, top+20, baseX, baseY-30);
            }
            case 3 -> {
                g.drawOval (baseX -10, top, 20, 20);
                g.drawLine (baseX, top+20, baseX, baseY-30);
                g.drawLine (baseX, baseY-30, baseX-15, baseY);
            }
            case 4 -> {
                g.drawOval (baseX -10, top, 20, 20);
                g.drawLine (baseX, top+20, baseX, baseY-30);
                g.drawLine (baseX, baseY-30, baseX-15, baseY);
                g.drawLine (baseX, baseY-30, baseX+15, baseY);
            }
            case 5 -> {
                g.drawOval (baseX -10, top, 20, 20);
                g.drawLine (baseX, top+20, baseX, baseY-30);
                g.drawLine (baseX, baseY-30, baseX-15, baseY);
                g.drawLine (baseX, baseY-30, baseX+15, baseY);
                g.drawLine (baseX, baseY-70, baseX-25, baseY-70);
            }
            case 6 -> {
                g.drawOval (baseX -10, top, 20, 20);  // head
                g.drawLine (baseX, top+20, baseX, baseY-30);  // trunk
                g.drawLine (baseX, baseY-30, baseX-15, baseY);  // legs
                g.drawLine (baseX, baseY-30, baseX+15, baseY);
                g.drawLine (baseX, baseY-70, baseX-25, baseY-70);  // arms
                g.drawLine (baseX, baseY-70, baseX+20, baseY-85);
            }
        }
    }
    // The main loop to run the game
    public void gameMode (){
        HangmanNew playerOneGame = new HangmanNew();
        Scanner keyboard = new Scanner(System.in);
        try {
            do {
                System.out.println("HANGMAN GAME");
                String word = playerOne(playerOneGame, keyboard);

                int incorrectCount = 0; // tracking the hanged-man
                while (true) { // main loop to run the game,
                    if (incorrectCount >= 6) {
                        System.out.println("You Lose!");
                        System.out.println("The word was " + word);
                        break;
                    }
                    //commented out below atm because displayed two lines
                    //printWordState(word, playerGuesses); // prints
                    if (!getPlayerGuess(keyboard, word, playerGuesses)) {
                        drawCounter++;
                        incorrectCount++;
                    } // returns true if playerInput is a match to charAt word
                    if (printWordState(word, playerGuesses)) {
                        System.out.println("You win!");
                        System.out.println("You've missed " + incorrectCount +
                                " times! Amazing job!");
                        System.out.println("View your score at at HangmanScores.txt");
                        playerLog(playerOneGame.getPlayerOneName(), incorrectCount, word);
                        break;
                    } // returns true if playerGuesses length = word, meaning finished
                }
            } while (playAgainYesNo(keyboard));
            System.exit(0);
        }catch(final InputMismatchException | FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    /* old stik figure
    public static void printHangedMan(int incorrectCount) {
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

     */
}

