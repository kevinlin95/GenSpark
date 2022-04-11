import java.util.Scanner;
import java.util.*;
// add junit testing
// remove unnecessary methods/fields
//
class Hangman
{
    private String [] playerinput;
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
                playerguesses[playerattemptfailed] = temp;
                missedletters[playerattemptfailed] = temp;
                for (int i = 0; i < computerword.length; i++) {
                    if (Objects.equals(Integer.parseInt(playerguesses[playerattemptsucess],1), i)) {
                        playerinput[i] = playerguess;
                        playerattemptsucess++;
                        returnFigureCount(playerattemptfailed);
                        System.out.println(Arrays.toString(playerinput));
                    }
                    playerattemptfailed++;
                    returnFigureCount(playerattemptfailed);
                    System.out.println(Arrays.toString(playerinput));
                }
                returnMissedLetters();
            }
        }catch(NoSuchElementException | IllegalStateException e){
            returnFigureCount(playerattemptfailed);
        }
    }

    public void mainMenu()
    {
        try {
            System.out.println("H A N G M A N");
            String[] str = new String[playerinput.length];
            System.arraycopy(playerinput, 0, str, 0, playerinput.length);
        do {
            addLetter();
        }while(playerattemptfailed < 4);
        if (playerattemptfailed == 4){
            System.out.println("Game Over!");
            playAgain();
        }
        if(Arrays.equals(str, computerword)) {
            System.out.println("You win!");
            playAgain();
        }
    }catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public void returnMissedLetters(){
        System.out.print("Missed letters: ");
        for (String missedletter : missedletters) {
            System.out.print(missedletter.toCharArray());
        }
    }

    public void playAgain()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to play again? (y or n)");
            char answer = sc.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                if (playerattemptfailed != 0) {
                    playerattemptfailed = 0;
                }
                if(playerattemptsucess != 0)
                {
                    playerattemptsucess = 0;
                }
                if(missedletters != null){
                    missedletters = null;
                }
                if(playerguesses != null){
                    playerguesses = null;
                }
                mainMenu();
            } else
                System.exit(0);
        }catch(InputMismatchException e)
        {
            playAgain();
        }
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

    public String[] getComputerword() {
        return computerword;
    }

    public void setComputerword(String[] computerword) {
        this.computerword = computerword;
    }

    public String[] getPlayerguesses() {
        return playerguesses;
    }

    public void setPlayerguesses(String[] playerguesses) {
        this.playerguesses = playerguesses;
    }

    public String[] getMissedletters() {
        return missedletters;
    }

    public void setMissedletters(String[] missedletters) {
        this.missedletters = missedletters;
    }

    public int getPlayerattemptsucess() {
        return playerattemptsucess;
    }

    public void setPlayerattemptsucess(int playerattemptsucess) {
        this.playerattemptsucess = playerattemptsucess;
    }

    public int getPlayerattemptfailed() {
        return playerattemptfailed;
    }

    public void setPlayerattemptfailed(int playerattemptfailed) {
        this.playerattemptfailed = playerattemptfailed;
    }

    public String[] getPlayerinput() {
        return playerinput;
    }

    public void setPlayerinput(String[] playerinput) {
        this.playerinput = playerinput;
    }
}


