import java.util.*;
import java.io.*;
import java.time.*;
public class ComplexClock {
	public static void showTime(String time) {
		Robot.load("clock.txt");
		Robot.setDelay(20);
		int firstNumber = getFirstNumber(time);
		int secondNumber = getSecondNumber(time);
		int thirdNumber = getThirdNumber(time);
		int fourthNumber = getFourthNumber(time);
		writeFirstNumber(firstNumber);
		writeSecondNumber(secondNumber);
		writeColon();
		writeThirdNumber(thirdNumber);
		writeFourthNumber(fourthNumber);
	}
	public static void timeFromConsole() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the time in the following format: 12:00");
		String time = in.nextLine();
		System.out.println(">" + time + "<");
		int hour = Integer.parseInt(time.substring(0, time.indexOf(":")));
		if (hour < 22 && hour > 12) {time = "0" + Integer.toString(hour - 12) + time.substring(time.indexOf(":"));}
		else if (hour < 10 && hour > 0) {time = "0" + time;}
		else if (hour == 0 || hour == 00) {time = "12" + time.substring(time.indexOf(":"));}
		else if (hour > 21 && hour < 24){time = Integer.toString(hour - 12) + time.substring(time.indexOf(":"));}
		else if (hour < 0 || hour > 23){System.out.println("Input invalid.");}
		in.close();
		showTime(time);
	}
	public static void realTime() {
		String bigTime = LocalTime.now().toString();
		String time = bigTime.substring(0, 5);
		int hour = Integer.parseInt(time.substring(0, 2));
		if (hour > 12) {
			if (hour < 22) {time = "0" + Integer.toString(hour - 12) + time.substring(time.indexOf(":"));}
			else {time = Integer.toString(hour - 12) + time.substring(2);}
		}
		else if (hour == 0 || hour == 00) {time = "12" + time.substring(time.indexOf(":"));}
		showTime(time);
	}
	public static void consoleMenu() {
		System.out.println("--==Enter number to choose which function to run.==--\n"
				+ "1 - cleanSquare(); to clean the square\n" + 
				"2 - darkenComb(); to make the comb maze all dark\n" + 
				"3 - makeCheckered(); to turn the 8x8 board into a checkered pattern\n" + 
				"4 - Clock.showTime(); to display a preset time\n" + 
				"5 - ComplexClock.timeFromConsole(); to show the time input from the console\n" + 
				"6 - ComplexClock.realTime(); to show the real time (from your computer clock)\n"
				+ "0 to cancel.\n"
				+ "--==NOTE: ComplexClock.showTime(); needs arguments, so it must be run seperately.==--");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
			case 1:
				Lab1.cleanSquare();
				break;
			case 2:
				Lab1.darkenComb();
				break;
			case 3:
				Lab1.makeCheckered();
				break;
			case 4:
				Clock.showTime();
				break;
			case 5: 
				ComplexClock.timeFromConsole();
				break;
			case 6:
				ComplexClock.realTime();
				break;
			case 0:
				System.out.println("Canceled.");
				break;
			default:
				System.out.println("Invalid input!");
				break;
		}
		in.close();
	}
	public static int getFirstNumber(String time) {
		char number = time.charAt(0);
		int firstNumber = Character.getNumericValue(number);
		return firstNumber;
	}
	public static int getSecondNumber(String time) {
		char number = time.charAt(1);
		int secondNumber = Character.getNumericValue(number);
		return secondNumber;
	}
	public static int getThirdNumber(String time) {
		char number = time.charAt(3);
		int thirdNumber = Character.getNumericValue(number);
		return thirdNumber;
	}
	public static int getFourthNumber(String time) {
		char number = time.charAt(4);
		int fourthNumber = Character.getNumericValue(number);
		return fourthNumber;
	}
	public static void writeFirstNumber(int num) {
		if (num == 1) {
			writeOne();
			nextNumber();
		}
		else if (num == 2) {
			writeTwo();
			nextNumber();
		}
		else if (num == 3) {
			writeThree();
			nextNumber();
		}
		else if (num == 4) {
			writeFour();
			nextNumber();
		}
		else if (num == 5) {
			writeFive();
			nextNumber();
		}
		else if (num == 6) {
			writeSix();
			nextNumber();
		}
		else if (num == 7) {
			writeSeven();
			nextNumber();
		}
		else if (num == 8) {
			writeEight();
			nextNumber();
		}
		else if (num == 9) {
			writeNine();
			nextNumber();
		}
		else if (num == 0) {
			writeZero();
			nextNumber();
		}
		else {
			System.out.println("Invalid input! (somehow)");
		}
	}
	public static void writeSecondNumber(int num) {
		if (num == 1) {
			writeOne();
			nextNumber();
		}
		else if (num == 2) {
			writeTwo();
			nextNumber();
		}
		else if (num == 3) {
			writeThree();
			nextNumber();
		}
		else if (num == 4) {
			writeFour();
			nextNumber();
		}
		else if (num == 5) {
			writeFive();
			nextNumber();
		}
		else if (num == 6) {
			writeSix();
			nextNumber();
		}
		else if (num == 7) {
			writeSeven();
			nextNumber();
		}
		else if (num == 8) {
			writeEight();
			nextNumber();
		}
		else if (num == 9) {
			writeNine();
			nextNumber();
		}
		else if (num == 0) {
			writeZero();
			nextNumber();
		}
		else {
			System.out.println("Invalid input! (somehow)");
		}
	}
	public static void writeThirdNumber(int num) {
		if (num == 1) {
			writeOne();
			nextNumber();
		}
		else if (num == 2) {
			writeTwo();
			nextNumber();
		}
		else if (num == 3) {
			writeThree();
			nextNumber();
		}
		else if (num == 4) {
			writeFour();
			nextNumber();
		}
		else if (num == 5) {
			writeFive();
			nextNumber();
		}
		else if (num == 6) {
			writeSix();
			nextNumber();
		}
		else if (num == 7) {
			writeSeven();
			nextNumber();
		}
		else if (num == 8) {
			writeEight();
			nextNumber();
		}
		else if (num == 9) {
			writeNine();
			nextNumber();
		}
		else if (num == 0) {
			writeZero();
			nextNumber();
		}
		else {
			System.out.println("Invalid input! (somehow)");
		}
	}
	public static void writeFourthNumber(int num) {
		if (num == 1) {
			writeOne();
		}
		else if (num == 2) {
			writeTwo();
		}
		else if (num == 3) {
			writeThree();
		}
		else if (num == 4) {
			writeFour();
		}
		else if (num == 5) {
			writeFive();
		}
		else if (num == 6) {
			writeSix();
		}
		else if (num == 7) {
			writeSeven();
		}
		else if (num == 8) {
			writeEight();
		}
		else if (num == 9) {
			writeNine();
		}
		else if (num == 0) {
			writeZero();
		}
		else {
			System.out.println("Invalid input! (somehow)");
		}
	}
	public static void writeOne() {
		Lab1.turnRight();
		moveTwo();
		Robot.turnLeft();
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenFour();
		turnAround();
		moveFour();
		Lab1.turnRight();
		moveTwo();
		Lab1.turnRight();
	}
	public static void writeTwo() {
		Lab1.turnRight();
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenTwo();
		turnAround();
		moveTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		moveFour();
		turnAround();
		
	}
	public static void writeThree() {
		Lab1.turnRight();
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		turnAround();
		moveTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		moveFour();
		turnAround();
	}
	public static void writeFour() {
		Lab1.turnRight();
		moveTwo();
		Robot.turnLeft();
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenFour();
		turnAround();
		moveTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		turnAround();
		moveFour();
		turnAround();
	}
	public static void writeFive() {
		Lab1.turnRight();
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		turnAround();
		moveTwo();
		Robot.turnLeft();
		moveFour();
		turnAround();
	}
	public static void writeSix() {
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenTwo();
		turnAround();
		moveTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		turnAround();
		moveTwo();
		Robot.turnLeft();
		moveFour();
		turnAround();
	}
	public static void writeSeven() {
		Lab1.turnRight();
		moveTwo();
		Robot.turnLeft();
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenFour();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		moveFour();
		turnAround();
	}
	public static void writeEight() {
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenTwo();
		turnAround();
		moveTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		moveTwo();
		Lab1.turnRight();
		moveTwo();
		Lab1.turnRight();
	}
	public static void writeNine() {
		Lab1.turnRight();
		if (!Robot.onDark()) {Robot.makeDark();}
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		Lab1.turnRight();
		darkenTwo();
		moveTwo();
		Lab1.turnRight();
		moveTwo();
		Lab1.turnRight();
	}
	public static void writeZero() {
		Lab1.turnRight();
		darkenTwo();
		Robot.turnLeft();
		darkenFour();
		Robot.turnLeft();
		darkenTwo();
		Robot.turnLeft();
		darkenFour();
		turnAround();
	}
	public static void writeColon() {
		Robot.move();
		if (!Robot.onDark()) {Robot.makeDark();}
		moveTwo();
		if (!Robot.onDark()) {Robot.makeDark();}
		turnAround();
		moveTwo();
		Robot.move();
		Robot.turnLeft();
		moveTwo();
		Robot.turnLeft();
	}
	public static void nextNumber() {
		Lab1.turnRight();
		moveFour();
		Robot.turnLeft();
	}
	public static void moveFour() {
		Robot.move();
		Robot.move();
		Robot.move();
		Robot.move();
	}
	public static void moveTwo() {
		Robot.move();
		Robot.move();
	}
	public static void darkenFour() {
		Robot.move();
		if (!Robot.onDark()) {Robot.makeDark();}
		Robot.move();
		if (!Robot.onDark()) {Robot.makeDark();}
		Robot.move();
		if (!Robot.onDark()) {Robot.makeDark();}
		Robot.move();
		if (!Robot.onDark()) {Robot.makeDark();}
	}
	public static void darkenTwo() {
		Robot.move();
		if (!Robot.onDark()) {Robot.makeDark();}
		Robot.move();
		if (!Robot.onDark()) {Robot.makeDark();}
	}
	public static void turnAround() {
		Robot.turnLeft();
		Robot.turnLeft();
	}
}
