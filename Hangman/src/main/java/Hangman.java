import java.util.Scanner;
import java.util.*;
// fix playerinput

class Hangman
{
    List <String> playerinput = new ArrayList<>();
    List <String> playerguesses = new ArrayList<>();
    List <String> missedletters = new ArrayList<>();
    private int playerattemptfailed = 0;

    private String computerword;

    public Hangman (String startingword){
        //creating a string array with constructor = computerword
        computerword = startingword;
        System.out.println("H A N G M A N!");
    }

    public void addLetter(){
        //main method checks counter everytime a player adds a new letter
        if (playerattemptfailed == 4){
            System.out.println("Game Over!");
            playAgain();
        }
        if(Objects.equals(playerinput.toString(), computerword)){
            System.out.println("You win!");
            playAgain();
        }
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a letter");
            String temp = sc.next();
            if (temp == null) {
                throw new IllegalArgumentException("Must be a letter");
            }
            int index = computerword.indexOf(temp);
            for(int i = 0; i < computerword.length(); i++) {
                if (Objects.equals(temp.charAt(0), computerword.charAt(i))) {
                    System.out.println("Matching Letter!");
                    playerguesses.add(temp);
                    playerinput.add(index, temp);
                    System.out.println(playerinput);
                    returnFigureCount(playerattemptfailed);
                    returnAllGuesses();
                    returnMissedLetters();
                }
                if (!Objects.equals(temp.charAt(0), computerword.charAt(i))){
                    System.out.println("Does not match!");
                    playerattemptfailed++;
                    playerguesses.add(temp);
                    missedletters.add(temp);
                    System.out.println(playerinput);
                    returnFigureCount(playerattemptfailed);
                    returnAllGuesses();
                    returnMissedLetters();
                }
                else if (temp.equals(playerinput.get(index))) {
                    System.out.println("You have already tried that letter!");
                }
            }
            System.out.println(playerinput);
            returnFigureCount(playerattemptfailed);
            returnAllGuesses();
            returnMissedLetters();
        }catch(NoSuchElementException | IllegalStateException |IndexOutOfBoundsException e){
            returnFigureCount(playerattemptfailed);
        }
    }

    public void returnAllGuesses(){
        System.out.print("Current guesses: ");
        for (String playerguess : playerguesses) {
            System.out.print(playerguess.toCharArray());
        }
        System.out.println();
    }

    public void returnMissedLetters(){
        System.out.print("Missed letters: ");
        for (String missedletter : missedletters) {
            System.out.print(missedletter.toCharArray());
        }
        System.out.println();
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
                if(playerinput != null){
                    playerinput = null;
                }
                if(missedletters != null){
                    missedletters = null;
                }
                if(playerguesses != null){
                    playerguesses = null;
                }
                addLetter();
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

    public String getComputerword() {
        return computerword;
    }

    public void setComputerword(String computerword) {
        this.computerword = computerword;
    }

    public List<String> getPlayerguesses() {
        return playerguesses;
    }

    public void setPlayerguesses(List<String> playerguesses) {
        this.playerguesses = playerguesses;
    }

    public List<String> getMissedletters() {
        return missedletters;
    }

    public void setMissedletters(List<String> missedletters) {
        this.missedletters = missedletters;
    }

    public int getPlayerattemptfailed() {
        return playerattemptfailed;
    }

    public void setPlayerattemptfailed(int playerattemptfailed) {
        this.playerattemptfailed = playerattemptfailed;
    }



    public List<String> getPlayerinput() {
        return playerinput;
    }

    public void setPlayerinput(List<String> playerinput) {
        this.playerinput = playerinput;
    }
}
/*
for(int i = 0; i < computerword.size(); i++) {
                int index = computerword.indexOf(temp);
                if (temp == null) {
                    throw new IllegalArgumentException("Must be a letter");
                }
                if (temp.equals(computerword.get(i))) {
                        if (playerinput.isEmpty()) {
                            System.out.println("Matching Letter!");
                            playerinput.add(index, temp);
                        } else if (temp.equals(playerinput.get(index))) {
                            System.out.println("You have already tried that letter!");
                            addLetter();
                        }
                }
                if (!temp.equals(computerword.get(index))){
                    System.out.println("Does not match!");
                    missedletters.add(temp);
                    playerattemptfailed++;
                }
                playerguesses.add(temp);
                System.out.println(playerinput);
                returnFigureCount(playerattemptfailed);
                returnAllGuesses();
                returnMissedLetters();
                addLetter();
                }
 */

