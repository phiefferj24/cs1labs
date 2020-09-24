import java.io.*;
import java.util.*;

public class Lab2Test
{
    public static void test() throws IOException
    {
        String[] requiredFiles = {"Lab2.java", "Robot.java",
            "candles1.txt", "candles2.txt", "candles3.txt",
            "room1.txt", "room2.txt", "room3.txt",
            "swap1.txt", "swap2.txt", "swap3.txt"};
            
        for (String fileName : requiredFiles)
            if (!new File(Lab2.path + fileName).exists())
                throw new RuntimeException("file \"" + Lab2.path + fileName + "\" not found in folder");
        
        System.out.println("Hit enter after each test");      
        Scanner userInput = new Scanner(System.in);
        Robot.setDelay(5);
        System.out.print("Testing candles1 ... ");
        Robot.load(Lab2.path + "candles1.txt");
        Lab2.lightCandles();
        System.out.println("Done");
        userInput.nextLine();
        System.out.print("Testing candles2 ... ");
        Robot.load(Lab2.path + "candles2.txt");
        Lab2.lightCandles();
        System.out.println("Done");
        userInput.nextLine();
        System.out.print("Testing candles3 ... ");
        Robot.load(Lab2.path + "candles3.txt");
        Lab2.lightCandles();
        System.out.println("Done");
        userInput.nextLine();
        
        System.out.print("Testing swap1 ... ");
        Robot.load(Lab2.path + "swap1.txt");
        Lab2.swapAll();
        System.out.println("Done");
        userInput.nextLine();
        System.out.print("Testing swap2 ... ");
        Robot.load(Lab2.path + "swap2.txt");
        Lab2.swapAll();
        System.out.println("Done");
        userInput.nextLine();
        System.out.print("Testing swap3 ... ");
        Robot.load(Lab2.path + "swap3.txt");
        Lab2.swapAll();
        System.out.println("Done");
        userInput.nextLine();
        
        System.out.print("Testing room1 ... ");
        Robot.load(Lab2.path + "room1.txt");
        Lab2.completeRoom();
        System.out.println("Done");
        userInput.nextLine();
        System.out.print("Testing room2 ... ");
        Robot.load(Lab2.path + "room2.txt");
        Lab2.completeRoom();
        System.out.println("Done");
        userInput.nextLine();
        System.out.print("Testing room3 ... ");
        Robot.load(Lab2.path + "room3.txt");
        Lab2.completeRoom();
        System.out.println("Done");
        
        System.out.println();
        System.out.println("Zip your Lab2 folder and submit to Classroom");
        System.out.println("In a private comment, list any additional credits completed");
        userInput.close();
        
    }
}
