/*
--==GUIDE==--
cleanSquare(); to clean the square
darkenComb(); to make the comb maze all dark
makeCheckered(); to turn the 8x8 board into a checkered pattern
Clock.showTime(); to display a preset time
ComplexClock.showTime("--put time here--") to show a time passed as an argument
ComplexClock.timeFromConsole(); to show the time input from the console
ComplexClock.realTime(); to show the real time (from your computer clock)
ComplexClock.consoleMenu(); to select these functions from a menu
 */

public class Lab1
{
	public static void main(String[] args) {
		ComplexClock.consoleMenu();
		
	}
    public static void cleanSquare()
    {
        Robot.load("square.txt");
        Robot.setDelay(100);
        cleanARow();
        cleanARow(); 
        cleanARow();
        cleanARow();

        //INSERT CODE HERE
    }
    
    public static void darkenComb()
    {
        Robot.load("comb.txt");
        Robot.setDelay(1000);
        Robot.makeDark();
        darkenARow();
        moveThenDarken();
        moveThenDarken();
        darkenARow();
        moveThenDarken();
        moveThenDarken();
        darkenARow();
        moveThenDarken();
        moveThenDarken();
        darkenARow();
        moveThenDarken();
        moveThenDarken();
        darkenARow();
        //INSERT CODE HERE
    }

    public static void makeCheckered()
    {
        Robot.load("blank.txt");
        Robot.setDelay(100);
        checkerOneRow();
        nextRowOnRight();
        checkerOneRow();
        nextRowOnLeft();
        checkerOneRow();
        nextRowOnRight();
        checkerOneRow();
        nextRowOnLeft();
        checkerOneRow();
        nextRowOnRight();
        checkerOneRow();
        nextRowOnLeft();
        checkerOneRow();
        nextRowOnRight();
        checkerOneRow();
        //INSERT CODE HERE
    }
    public static void turnRight() {
    	Robot.turnLeft();
    	Robot.turnLeft();
    	Robot.turnLeft();
    }
    public static void moveThenClean() {
    	Robot.move();
    	Robot.makeLight();
    }
    public static void cleanARow() {
    	moveThenClean();
    	moveThenClean();
    	moveThenClean();
    	moveThenClean();
    	moveThenClean();
    	Robot.move();
    	Robot.turnLeft();
    }
    public static void moveThenDarken() {
    	Robot.move();
    	Robot.makeDark();
    }
    public static void darkenARow() {
    	turnRight();
    	moveThenDarken();
    	moveThenDarken();
    	moveThenDarken();
    	moveThenDarken();
    	moveThenDarken();
    	moveThenDarken();
    	Robot.turnLeft();
    	Robot.turnLeft();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	turnRight();
    }
    public static void checkerOneRow() {
    	Robot.makeDark();
    	Robot.move();
    	Robot.move();
    	Robot.makeDark();
    	Robot.move();
    	Robot.move();
    	Robot.makeDark();
    	Robot.move();
    	Robot.move();
    	Robot.makeDark();
    	Robot.move();
    }
    public static void nextRowOnRight() {
    	turnRight();
    	Robot.move();
    	turnRight();
    }
    public static void nextRowOnLeft() {
    	Robot.turnLeft();
    	Robot.move();
    	Robot.turnLeft();
    }
}
