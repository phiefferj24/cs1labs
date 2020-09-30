import java.io.*;
import java.util.*;

public class Lab3Tester {

    public static void test() throws IOException {
        String[] requiredFiles = { "Lab3.java", "Robot.java", "bars1.txt", "bars2.txt", "bars3.txt", "piles1.txt",
                "piles2.txt", "piles3.txt", "dots3.txt", "maze3.txt", "sort3.txt" };

        String[] congrats = { "Top notch codery!", "You are the wind beneath my wings ~Robot",
                "When the coding gets tough, you got coding tougher!!!", "Did I ever tell you you're my hero ~Robot",
                "I am so proud of you ~Robot",
                "Thank you for stacking all of those boxes, I've been asking Robot to clean their room for months ~Robot's Dad",
                "You did it, now go celebrate!!!", "I EXTEND MY CONGRATULATORY REMARKS TO YOU",
                "YOU HAVE HARNESSED THE POWER OF THE FORCE, YOUNG JEDI", "You truly are a coding legend!!!" };

        for (String fileName : requiredFiles)
            if (!new File(fileName).exists())
                throw new RuntimeException("file \"" + fileName + "\" not found in folder");
        if (new File("Draw.java").exists())
            throw new RuntimeException("Error #2158");
        if (new File("Grid.java").exists())
            throw new RuntimeException("Error #9806");

        Scanner userInput = new Scanner(System.in);
        Robot.setDelay(1);

        System.out.print(
                "\n To be elligible to submit your lab, \n you must have no runtime errors \n and your code must work on ANY legitimate test map. \n Hit the return key to test CompleteBars1... ");
        userInput.nextLine();
        System.out.print("Testing bars1 ... ");
        Robot.load("bars1.txt");
        Lab3.completeBars();
        System.out.println("If it looks correct, hit return");
        userInput.nextLine();

        System.out.print("Testing bars2 ... ");
        Robot.load("bars2.txt");
        Lab3.completeBars();
        System.out.println("If it looks correct, hit return");
        userInput.nextLine();

        System.out.print("Testing bars3 ... ");
        Robot.load("bars3.txt");
        Lab3.completeBars();
        System.out.println("If it looks correct, hit return");
        userInput.nextLine();

        Robot.setDelay(1);

        System.out.print("Testing piles1 ... ");
        Robot.load("piles1.txt");
        Lab3.combinePiles();
        System.out.println("If it looks correct, hit return");
        userInput.nextLine();

        System.out.print("Testing piles2 ... ");
        Robot.load("piles2.txt");
        Lab3.combinePiles();
        System.out.println("If it looks correct, hit return");
        userInput.nextLine();

        System.out.print("Testing piles3 ... ");
        Robot.load("piles3.txt");
        Lab3.combinePiles();
        System.out.println("If it looks correct, hit return");
        userInput.nextLine();

        System.out.println("\n");

        int spot = (int) (Math.random() * congrats.length);
        System.out.println(congrats[spot]);

        System.out.println(
                "\n Zip and submit. \n If you did extra credit hit return. \n Your code must terminate for credit. \n ");

        userInput.nextLine();

        Robot.setDelay(1);

        System.out.print("Testing dots3 ... ");
        Robot.load("dots3.txt");
        Lab3.connectDots();
        System.out.println("\n If you did sort or maze, \n test them on sort3.txt and maze3.txt respectively, \n which are found in the tester folder. \n If everything looks good, let your \n teacher know what extra credit you've \n done in the comments on classroom.");

    }
}