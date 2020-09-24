import java.io.*;
import java.util.*;
public class Creator {
	public static Scanner in = new Scanner(System.in);
	
	public static String startup() {
		System.out.println("MAP CREATOR\n\nEnter file name now:");
		String filename = in.nextLine();
		try {
		      File file = new File(filename);
		      if (file.createNewFile()) {
		        System.out.println("File created: " + filename);
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		return filename;
	}
	public static void mazeRenderer() {
		
	}
	public static int makeMaze(String filename) {
		
		System.out.println("Enter width of maze now.");
		int width = in.nextInt();
		System.out.println("Enter height of maze now.");
		int height = in.nextInt();
		int[][] maze = new int[width][height];
		int robotMade = 0;
		System.out.println("\nRULES\n\n"
				+ "Enter 1 for wall.\n"
				+ "Enter 2 for light square.\n"
				+ "Enter 3 for dark square.\n"
				+ "Enter 4 for robot facing north.\n"
				+ "Enter 5 for robot facing east.\n"
				+ "Enter 6 for robot facing south.\n"
				+ "Enter 7 for robot facing west.\n"
				+ "0 to cancel maze creation.\n\n"
				+ "ONLY ONE ROBOT\n\n");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.println("Enter Row "+(j+1)+" Column " +(i+1)+ " now.");
				int entry = in.nextInt();
				if(entry == 1 || entry == 2 || entry == 3) {
					maze[j][i] = entry;
				}
				else if(entry == 4 || entry == 5 || entry == 6 || entry == 7) {
					if(robotMade == 0) {
						maze[j][i] = entry;
					}
					else {
						System.out.println("You cannot have 2 robots! Cancelling creator...");
						return 1;
					}
				}
				else if (entry == 0) {
					System.out.println("\nCANCELED\n");
					return 1;
				}
				else {
					System.out.println("Invalid input. Cancelling creator...");
				}
			}
		}
		writeToFile(maze, filename);
		return 0;
	}
	public static void writeToFile(int[][] maze, String filename) {
		try {
		      FileWriter file = new FileWriter(filename);      
		      for (int i = 0; i < maze.length; i++) {
		    	  StringBuffer buffer = new StringBuffer();
					for (int j = 0; j < maze[0].length; j++) {
						if (maze[j][i] == 1) {
							buffer.append("X");
						}
						else if (maze[j][i] == 2) {
							buffer.append(".");
						}
						else if (maze[j][i] == 3) {
							buffer.append(":");
						}
						else if (maze[j][i] == 4) {
							buffer.append("N");
						}
						else if (maze[j][i] == 5) {
							buffer.append("E");
						}
						else if (maze[j][i] == 6) {
							buffer.append("S");
						}
						else if (maze[j][i] == 7) {
							buffer.append("W");
						}
					}
					String line = buffer.toString();
					file.write(line + "\n");
				}
				file.close();
		} 
		catch (IOException e) {
		      e.printStackTrace();
		}
		
	
	}
}
