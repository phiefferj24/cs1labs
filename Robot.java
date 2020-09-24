import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Robot
{
    private static int robotRow;
    private static int robotCol;
    private static int robotDir;
    private static int delay = 100;
    private static JFrame frame = null;
    private static int numSteps = 0;
    private static int[][] grid;  //grid[row][col] is CELL_WALL, CELL_LIGHT, or CELL_DARK
    private static RobotComponent canvas;

    private static final int CELL_WALL = 0;
    private static final int CELL_LIGHT = 1;
    private static final int CELL_DARK = 2;

    private static final int DIR_NORTH = 0;
    private static final int DIR_WEST = 1;
    private static final int DIR_EAST = 2;
    private static final int DIR_SOUTH = 3;

    private static final Image ROBOT_NORTH_IMAGE = loadImage("robotnorth.gif");
    private static final Image ROBOT_SOUTH_IMAGE = loadImage("robotsouth.gif");
    private static final Image ROBOT_EAST_IMAGE = loadImage("roboteast.gif");
    private static final Image ROBOT_WEST_IMAGE = loadImage("robotwest.gif");
    private static final Image WALL_IMAGE = loadImage("wall.gif");

    private static final Color LIGHT_COLOR = new Color(230, 170, 120);
    private static final Color DARK_COLOR = new Color(150, 110, 80);

    //hide constructor
    private Robot()
    {
    }

    public static void load(String mapFileName)
    {
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

        grid = new int[lines.size()][lines.get(0).length()];

        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                if (lines.get(row).length() != grid[0].length)
                    throw new RuntimeException("Inconsistent line length in map file \"" + mapFileName + "\"");

                char ch = lines.get(row).charAt(col);
                if ("NSEWnsew".indexOf(ch) != -1)
                {
                    if ("NSEW".indexOf(ch) != -1)
                        grid[row][col] = CELL_LIGHT;
                    else
                        grid[row][col] = CELL_DARK;
                    if (ch == 'N' || ch == 'n')
                        robotDir = DIR_NORTH;
                    else if (ch == 'S' || ch == 's')
                        robotDir = DIR_SOUTH;
                    else if (ch == 'E' || ch == 'e')
                        robotDir = DIR_EAST;
                    else
                        robotDir = DIR_WEST;
                    robotRow = row;
                    robotCol = col;
                }
                else if (ch == 'X')
                    grid[row][col] = CELL_WALL;
                else if (ch == '.')
                    grid[row][col] = CELL_LIGHT;
                else if (ch == ':')
                    grid[row][col] = CELL_DARK;
                else
                    throw new RuntimeException("Invalid character '" + ch + "' in map file \"" + mapFileName + "\"");
            }
        }

        if (frame == null)
        {
            frame = new JFrame();
            canvas = new RobotComponent();
            frame.getContentPane().add(canvas);
        }

        frame.setTitle(mapFileName);
        int cellSize = 500 / Math.max(grid.length, grid[0].length);
        canvas.setPreferredSize(new Dimension(grid[0].length * cellSize, grid.length * cellSize));
        frame.pack();
        frame.setVisible(true);
        canvas.repaint();
        pause(1);
    }

    private static void checkLoad()
    {
        if (frame == null)
            throw new RuntimeException("Map not loaded yet");
    }

    private static void update()
    {
        canvas.repaint();
        pause(delay);
        numSteps++;
    }

    public static void move()
    {
        checkLoad();
        int row = robotRow;
        int col = robotCol;
        if (robotDir == DIR_NORTH)
            row--;
        else if (robotDir == DIR_SOUTH)
            row++;
        else if (robotDir == DIR_EAST)
            col++;
        else
            col--;

        if (!isValid(row, col))
            throw new RuntimeException("Attempt to move robot from " + locString(robotRow, robotCol) + " to invalid location " + locString(row, col));
        if (grid[row][col] == CELL_WALL)
            throw new RuntimeException("Attempt to move robot from " + locString(robotRow, robotCol) + " to occupied location " + locString(row, col));

        robotRow = row;
        robotCol = col;
        update();
    }

    public static void turnLeft()
    {
        checkLoad();
        if (robotDir == DIR_NORTH)
            robotDir = DIR_WEST;
        else if (robotDir == DIR_SOUTH)
            robotDir = DIR_EAST;
        else if (robotDir == DIR_EAST)
            robotDir = DIR_NORTH;
        else
            robotDir = DIR_SOUTH;
        update();
    }

    public static void makeLight()
    {
        checkLoad();
        if (!onDark())
            throw new RuntimeException("Location " + locString(robotRow, robotCol) + " is already light");
        grid[robotRow][robotCol] = CELL_LIGHT;
        update();
    }

    public static void makeDark()
    {
        checkLoad();
        if (onDark())
            throw new RuntimeException("Location " + locString(robotRow, robotCol) + " is already dark");
        grid[robotRow][robotCol] = CELL_DARK;
        update();
    }

    public static boolean onDark()
    {
        checkLoad();
        return grid[robotRow][robotCol] == CELL_DARK;
    }

    public static boolean frontIsClear()
    {
        checkLoad();
        int row = robotRow;
        int col = robotCol;
        if (robotDir == DIR_NORTH)
            row--;
        else if (robotDir == DIR_SOUTH)
            row++;
        else if (robotDir == DIR_EAST)
            col++;
        else
            col--;

        return isValid(row, col) && grid[row][col] != CELL_WALL;
    }

    public static void setDelay(int ms)
    {
        delay = ms;
    }

    public static int getNumSteps()
    {
        return numSteps;
    }

    private static Image loadImage(String fileName)
    {
        try
        {
            return ImageIO.read(Robot.class.getResource(fileName));
        }
        catch (IOException e)
        {
            throw new RuntimeException("unable to load image file \"" + fileName + "\"");
        }
    }

    public static void pause(int ms)
    {
        try { Thread.sleep(ms); } catch(Exception e) { }
    }

    private static boolean isValid(int row, int col)
    {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    private static String locString(int row, int col)
    {
        return "(" + row + ", " + col + ")";
    }

    private static class RobotComponent extends JComponent
    {
        public void paintComponent(Graphics g)
        {
            int cellSize = Math.min(getWidth() / grid[0].length, getHeight() / grid.length);
            for (int row = 0; row < grid.length; row++)
            {
                for (int col = 0; col < grid[0].length; col++)
                {
                    int x = col * cellSize;
                    int y = row * cellSize;
                    if (grid[row][col] == CELL_WALL)
                        g.drawImage(WALL_IMAGE, x, y, cellSize, cellSize, null);
                    else if (grid[row][col] == CELL_LIGHT)
                    {
                        g.setColor(LIGHT_COLOR);
                        g.fillRect(x, y, cellSize, cellSize);
                    }
                    else if (grid[row][col] == CELL_DARK)
                    {
                        g.setColor(DARK_COLOR);
                        g.fillRect(x, y, cellSize, cellSize);
                    }
                    if (row == robotRow && col == robotCol)
                    {
                        Image image;
                        if (robotDir == DIR_NORTH)
                            image = ROBOT_NORTH_IMAGE;
                        else if (robotDir == DIR_WEST)
                            image = ROBOT_WEST_IMAGE;
                        else if (robotDir == DIR_EAST)
                            image = ROBOT_EAST_IMAGE;
                        else
                            image = ROBOT_SOUTH_IMAGE;
                        g.drawImage(image, x, y, cellSize, cellSize, null);
                    }
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, cellSize, cellSize);
                }
            }
            //don't forget to draw black line grid
        }
    }
}