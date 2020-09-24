import java.io.*;
import java.util.Scanner;
public class Maze
{
	Input input = new Input();
	public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Startup.startup("maze2.txt");
    }
    public static void solve()
    {

        moveThenTurn(4, 1);
        moveThenTurn(2, 3);
        moveThenTurn(2, 3);
        moveThenTurn(2, 1);
        moveThenTurn(2, 1);
        moveThenTurn(6, 1);
        moveThenTurn(2, 3);
        moveThenTurn(2, 1);
        moveThenTurn(4, 1);
        moveThenTurn(2, 3);
        moveThenTurn(2, 3);
        moveThenTurn(4, 3);
        moveThenTurn(2, 1);
        moveThenTurn(2, 1);
        moveThenTurn(2, 3);
        moveThenTurn(6, 3);
        moveThenTurn(2, 3);
        moveThenTurn(2, 1);
        moveThenTurn(4, 3);
        moveThenTurn(2, 1);
        moveThenTurn(2, 1);
        moveThenTurn(4, 0);
        //add other instructions here
    }
    
    
    
    

    //define other methods here
    public static void turnRight() {
    	for (int i = 0; i < 3; i++) {
    		Robot.turnLeft();
    	}
    }
    public static void moveAFew(int num){
        for (int i = 0; i < num; i++) {
        	darken();
            Robot.move();
        }
    }
    public static void turnAFew(int num) {
        for (int i = 0; i < num; i++) {
            Robot.turnLeft();
        }
    }
    public static void moveThenTurn(int moves, int turns) {
        moveAFew(moves);
        turnAFew(turns);
    }
    public static void darken() {
    	if (!Robot.onDark()) {
    		Robot.makeDark();
    	}
    }
    
    		
}
