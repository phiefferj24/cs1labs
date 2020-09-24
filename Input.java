import java.util.Scanner;

public class Input {
	public static Scanner in = new Scanner(System.in);
	public static int exit = 1;
	
	public static int checkForMovement() {
    	int number;
    	number = in.nextInt();
    	return number;
    }
    public static void moveInput() {
    	System.out.println("Enter number of squares to move, 0 to exit.");
    	int moves = checkForMovement();
    	for (int i = 0; i < moves; i++) {
    		Maze.darken();
    		Robot.move();
    	}
    	if (moves == 0) {
    		exit = 0;
    	}
    	
    }
    public static void turnInput() {
    	System.out.println("Enter turn: 1 for left, 3 for right, 0 to exit.");
    	int turns = checkForMovement();
    	for (int i = 0; i < turns; i++) {
    		Robot.turnLeft();
    	}
    	if (turns == 0) {
    		setExitStatus(turns);
    	}
    }
    public static void setExitStatus(int num) {
    	exit = num;
    }
    public static int getExitStatus() {
    	return exit;
    }
    public static void moveWASD() {
    	int letter = 1;
    	System.out.println("Use Numpad 8/4/6/2 to move/turn. Use 0 to exit.");
    	letter = (int) in.nextInt();
    	if (letter == 8) {
    		Maze.darken();
    		Robot.move();
    		System.out.println("Pressed 8");
    	}
    	else if (letter == 2) {
    		Maze.darken();
    		Robot.turnLeft();
    		Robot.turnLeft();
    		Robot.move();
    		Robot.turnLeft();
    		Robot.turnLeft();
    		System.out.println("Pressed 2");
    	}
    	else if (letter == 4) {
    		Robot.turnLeft();
    		System.out.println("Pressed 4");
    	}
    	else if (letter == 6) {
    		Robot.turnLeft();
    		Robot.turnLeft();
    		Robot.turnLeft();
    		System.out.println("Pressed 6");
    	}
    	else if (letter == 0) {
    		setExitStatus(0);
    	}
    	else {
    		System.out.println("No input recieved/Invalid input");
    	}
    }
    public static void solveWithNumInput() {
    	boolean exitStatus = false;
    	int turnNumber = 0;
    	while (!exitStatus || turnNumber > 50) {
    		Input.moveInput();
    		if (Input.getExitStatus() == 0) {exitStatus = true;}
    		Input.turnInput();
    		if (Input.getExitStatus() == 0) {exitStatus = true;}
    		turnNumber++;
    	}
    }
    public static void solveWithCharInput() {
        boolean exitStatus = false;
        int turnNumber = 0;
        while (!exitStatus || turnNumber > 50) {
        	Input.moveWASD();
        	if (Input.getExitStatus() == 0) {exitStatus = true;}
        }
        System.out.println("epic.");
    }
}

