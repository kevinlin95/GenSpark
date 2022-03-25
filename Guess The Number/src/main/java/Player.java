import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Player
{
    private String playername;
    private int attempts;
    private int secretnumber;
    private int playernumber;

    public Player()
    {
        playernumber = 0;
        playername = "";
        attempts = 0;
        secretnumber = (int)(Math.random() * 20 + 1);
    }
    public String getName()
    {
        return playername;
    }
    public int getAttempts()
    {
        return attempts;
    }
    public int getSecretNumber()
    {
        return secretnumber;
    }
    public int getPlayerNumber()
    {
        return playernumber;
    }

    public void mainMenu()
    {
        try {
            System.out.println("Hello, what is your name?");
            Scanner sc = new Scanner(System.in);
            playername = sc.next();
        }catch(IllegalStateException e)
        {
            System.out.println("not a valid name");
        }catch(NoSuchElementException e)
        {
            System.out.println("not a valid name");
        }
        System.out.println("Well, " + playername + ", I am thinking of a number between 1 and 20.");
        System.out.println("Take a guess. You have 6 attempts!");
        do{
            anotherAttempt();
        }while(attempts < 7);
    }
    public void anotherAttempt()
    {
        attempts++;
        System.out.println("This is attempt " + attempts);
        if(attempts > 6)
        {
            System.out.println("Maximum attempts reached");
            System.out.println("Game over");
            playAgain();
        }
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a number");
            playernumber = sc.nextInt();
            if (playernumber == secretnumber) {
                System.out.println("Good Job " + playername + "! You guessed my number in " + attempts + " guesses!");
                playAgain();
            } else if (playernumber > secretnumber) {
                System.out.println("Your guess is too high!");
                System.out.println("Take a guess");
            } else {
                System.out.println("Your guess is too low!");
                System.out.println("Take a guess");
            }
        }catch(InputMismatchException e)
        {
            attempts--;
        }
    }
    public void playAgain()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to play again? (y or n)");
            char answer = sc.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                if (attempts != 0) {
                    attempts = 0;
                }
                mainMenu();
            } else
                System.exit(0);
        }catch(InputMismatchException e)
        {
            playAgain();
        }
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setSecretnumber(int secretnumber) {
        this.secretnumber = secretnumber;
    }

    public void setPlayernumber(int playernumber) {
        this.playernumber = playernumber;
    }
}
