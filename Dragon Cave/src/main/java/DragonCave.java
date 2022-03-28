import java.util.InputMismatchException;
import java.util.Scanner;
public class DragonCave
{
    public static int playerchoice;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println(); // using println to ensure lines
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println(); // leaving some empty to skip lines
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println();
        System.out.println("is greedy and hungry and will eat you on sight");
        System.out.println();
        System.out.println("Which cave will you go into? (1 or 2)");
        try {
            playerchoice = sc.nextInt();
        }catch(InputMismatchException e)
        {
            System.out.println("Input must be 1 or 2");
        }
        if (playerchoice == 1) {
            System.out.println("You approach the cave...");
            System.out.println();
            System.out.println("It is dark and spooky...");
            System.out.println();
            System.out.println("A large dragon jumps out in front of you! He opens his jaws");
            System.out.println("and...");
            System.out.println();
            System.out.println("Gobbles you down in one bite!");
            System.out.println();
            System.out.println();
        }
        else if (playerchoice == 2)
        {
            System.out.println("You approach the cave...");
            System.out.println();
            System.out.println("It is foggy and damp");
            System.out.println();
            System.out.println("A large pair of eyes gaze upon you. He roars viciously ");
            System.out.println("and...");
            System.out.println();
            System.out.println("retreats to his lair. He gestures at the treasures.");
            System.out.println("You take the treasure. The End. ");
        }
    }
}
