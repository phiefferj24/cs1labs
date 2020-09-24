import java.util.Scanner;
import java.io.*;
public class Startup {
	public static Scanner in = new Scanner(System.in);
	public static void startup(String filename) {
		System.out.println("Choose program:\n"
				+ "1 for programmed solve\n"
				+ "2 for number navigation\n"
				+ "3 for numpad arrow navigation\n"
				+ "4 for level creator\n"
				+ "0 to exit.\n\n"
				+ "ENTER NOW\n");
		int selection = in.nextInt();
		if (selection == 1 || selection == 2 || selection == 3) {
			System.out.println("File: " + filename);
			Robot.load(filename);
			if (selection == 1) {
				System.out.println("Entering programmed solve...\n");
				Maze.solve();
			}
			else if (selection == 2) {
				System.out.println("Entering number navigation...\n");
				Input.solveWithNumInput();
			}
			else if (selection == 3) {
				System.out.println("Entering numpad arrow navigation...");
				Input.solveWithCharInput();
			}
			return;
			
		}
		else if (selection == 4) {
			System.out.println("Entering Level Creator...\n");
			String fileName = Creator.startup();
			Creator.makeMaze(fileName);
			return;
		}
		else if (selection == 0) {
			System.out.println("Ok.");
			return;
		}
	}
}
