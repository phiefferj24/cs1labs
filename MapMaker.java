import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MapMaker {
    public static Scanner in = new Scanner(System.in);
    public static int width, height;
	public static String startup() {
        //System.out.println("Enter file num.");
        //int num = in.nextInt();
        int num = 3;
        String filename = "sort" + num + ".txt";
		try {
		      File file = new File(filename);
		      if (file.createNewFile()) {
		        System.out.println("File created: " + filename);
		      } else {
		        System.out.println("Replacing: " + filename);
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
            }
		return filename;
    }
    public static String makeFile() {
        String filename = startup();
        width = ThreadLocalRandom.current().nextInt(12, 21);
        height = ThreadLocalRandom.current().nextInt(8, 16);
        char[][] grid = new char[width][height];
        for(int i = 0; i < width; i++) {
            int col = (int) Math.floor(Math.random() * height);
            int start = height - col + 1;
            for(int j = 0; j < height; j++) {
                if(start <= j) grid[i][j] = ':';
                else grid[i][j] = '.';
            }
        }
        writeToFile(grid, filename);
        return filename;
    }
    public static void writeToFile(char[][] maze, String filename) {
		try {
		      FileWriter file = new FileWriter(filename);      
		      for (int i = 0; i < maze[0].length; i++) {
		    	  StringBuffer buffer = new StringBuffer();
					for (int j = 0; j < maze.length; j++) {
                        if(i == 0 && j == 0) buffer.append('E');
						else buffer.append(maze[j][i]);
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
