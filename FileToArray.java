import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
public class FileToArray {
    public static String mapFileName = "test.txt";
    public static void main(String[] args) {
        arrayToFile(fileToArray());
    }
    public static char[][] fileToArray() {
        ArrayList<String> lines = new ArrayList<String>();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(mapFileName));
            String line = in.readLine();
            while (line != null)
            {
                lines.add(line);
                line = in.readLine();
            }
            in.close();
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        char[][] grid = new char[lines.size()][lines.get(0).length()];

        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                grid[row][col] = (char)lines.get(row).charAt(col);
            }
        }
        return grid;
    }
    public static void arrayToFile(char[][] grid) {
        try {
            File file = new File(mapFileName);
            if (file.createNewFile()) {
              System.out.println("File created: " + mapFileName);
            } else {
              System.out.println("Replacing: " + mapFileName);
            }
            FileWriter file2 = new FileWriter(mapFileName); 
            for (int row = 0; row < grid.length; row++)
            {
                String stringBuffer = "";
                stringBuffer += "{";
                for (int col = 0; col < grid[0].length; col++)
                {
                    if(row == 0 && col == 0) stringBuffer += ("{");
                    char c = grid[row][col];
                    System.out.println(c);
                    if(col != grid[0].length - 1) stringBuffer += ("'" + Character.toString(c) + "'" + ", ");
                    else stringBuffer += ("'" + Character.toString(c) + "'");
                    if(row == grid.length - 1 && col == grid[0].length - 1) stringBuffer += ("}");
                }
                stringBuffer += "},";
                System.out.println(stringBuffer);
                file2.write(stringBuffer + "\n");
            }
            file2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
/*
if(row == 0 && col == 0) stringBuffer.concat("{");
                if(row == 0) stringBuffer.concat("{");

                if(row == grid.length) stringBuffer.concat("}");
                if(row == grid.length && col == grid[0].length) stringBuffer.concat("}");
                */