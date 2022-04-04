import java.util.Scanner;
import java.util.*;
// need to add increment to playerguess/missed letters after input
// add junit testing
// remove unnecessary methods/fields
//
class Hangman
{
    private String [] computerword;
    private String [] playerguesses;
    private String [] missedletters;
    private int playerattemptsucess = 0;
    private int playerattemptfailed = 0;

    public Hangman (String startingword){
        computerword = startingword.split("");
        mainMenu();
    }

    public void addLetter(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a letter");
            String temp = sc.next();
            for (String playerguess : playerguesses) {
                if (!(temp instanceof String)) {
                    throw new IllegalArgumentException("Must be a letter");
                }
                if (temp.equals(playerguess)) {
                    System.out.println("You have already guessed that letter." +
                            "Choose again");
                }
                playerguesses[playerattemptsucess] = temp;
                missedletters[playerattemptfailed] = temp;
                for (String s : computerword) {
                    if (Objects.equals(playerguesses[playerattemptsucess], s)) {
                        playerattemptsucess++;
                        returnFigureCount(playerattemptfailed);
                    }
                    playerattemptfailed++;
                    returnFigureCount(playerattemptfailed);
                }
                returnMissedLetters();
                returnPlayerGuesses();
            }
        }catch(NoSuchElementException e){
            System.out.println(e);
        }
    }

    public void mainMenu()
    {
        System.out.println("H A N G M A N");
        do {
                addLetter();
        }while(playerattemptfailed < 4);
        if (playerattemptfailed == 4){
            System.out.println("Game Over!");
        }
    }

    public void returnMissedLetters(){

    }

    public void returnPlayerGuesses(){

    }

    public void returnFigureCount(int playerlifeleft){
        switch (playerlifeleft) {
            case 1 -> {
                System.out.println("+---+");
                System.out.println("O   |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("   ===");
                System.out.println("Attempts remaining: 2");
            }
            case 2 -> {
                System.out.println(" +---+ ");
                System.out.println(" O   | ");
                System.out.println("/|\\ | ");
                System.out.println("     |");
                System.out.println("    ===");
                System.out.println("Attempts remaining: 1");
            }
            case 3 -> {
                System.out.println(" +---+ ");
                System.out.println(" O   | ");
                System.out.println("/|\\ | ");
                System.out.println("| |  | ");
                System.out.println("    ===");
                System.out.println("Attempts remaining: 0");
            }
            default -> {
                System.out.println("+---+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("   ===");
                System.out.println("Attempts remaining: 3");
            }
        }
    }
}


