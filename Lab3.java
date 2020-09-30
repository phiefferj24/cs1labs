import java.io.IOException;

public class Lab3 {
    // test 2
    public static void main(String[] args) throws IOException {
        testSort2();
        /*int delay = 2;
        int amt = 5;
        for(int i = 0 ; i < amt; i++)
            testSort(MapMaker.makeFile(), delay);*/
}
    public static void turnRight()
{
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
}

    public static void turnAround()
{
        Robot.turnLeft();
        Robot.turnLeft();
}

    public static void backUp()
{
        turnAround();
        Robot.move();
        turnAround();
}

    public static void completeBars()
{
        fillABar();
        while(Robot.frontIsClear()) {
            if(Robot.frontIsClear()) {
                Robot.move();
}
            fillABar();
}
        
}

    public static void testCompleteBars1()
{
        Robot.load("bars1.txt");
        Robot.setDelay(5);
        completeBars();
}

    public static void testCompleteBars2()
{
        Robot.load("bars2.txt");
        Robot.setDelay(5);
        completeBars();
}

    public static void combinePiles()
{
        //insert instructions below
        turnRight();
        while(!Robot.onDark()) {Robot.move();}
        Robot.turnLeft();
        while(Robot.onDark()) {
            toNextColumn();
}
}

    public static void testCombinePiles1()
{
        Robot.load("piles1.txt");
        Robot.setDelay(5);
        combinePiles();
}

    public static void testCombinePiles2()
{
        Robot.load("piles2.txt");
        Robot.setDelay(5);
        combinePiles();
}

    public static void connectDots()
{
        //insert instructions below
        connectSomeDots();
    
}

    public static void testConnectDots1()
{
        Robot.load("dots1.txt");
        Robot.setDelay(5);
        connectDots();
}

    public static void testConnectDots2()
{
        Robot.load("dots2.txt");
        Robot.setDelay(1);
        connectDots();
}
    public static void fillABar() {
        Robot.turnLeft();
        while(!Robot.onDark()) {
            Robot.move();
}
        turnAround();
        while(Robot.frontIsClear()) {
            Robot.move();
            Robot.makeDark();
}
        Robot.turnLeft();
}
    public static void toNextColumn() {
        Robot.makeLight();
        turnRight();
        Robot.move();
        Robot.turnLeft();
        while(Robot.onDark()) {
            Robot.move();
}
        Robot.makeDark();
        turnAround();
        while(Robot.frontIsClear()) {
            Robot.move();
}
        turnRight();
        Robot.move();
        turnRight();
        while(!Robot.onDark() && Robot.frontIsClear()) Robot.move();
}
    public static boolean connectStill = true;
    public static void connectSomeDots() {
        while(connectStill) {
            turnRight();
            while(!checkForDots()) {Robot.turnLeft();}
            if (!connectStill) {return;}
            Robot.move();
            Robot.makeDark();
            Robot.move();
        }
    }
    public static boolean checkForDots() {
        Robot.move();
        if(Robot.onDark()) {connectStill = false; return true;}
        Robot.move();
        turnAround();
        boolean b;
        if(Robot.onDark()) {b = true;}
        else {b = false;}
        Robot.move();
        Robot.move();
        turnAround();
        return b;
}
    public static void solveMaze() {
        while(!Robot.onDark()) {
            while(Robot.frontIsClear()) {
                Robot.move();
                Robot.turnLeft();
                if(Robot.frontIsClear()) break;
                turnRight();
            }
            if(!Robot.frontIsClear()) Robot.turnLeft();
            if(!Robot.frontIsClear()) turnAround();
            if(!Robot.frontIsClear()) turnRight();
        }
    }
    public static void testSolveMaze1() {
        Robot.load("maze1.txt");
        Robot.setDelay(5);
        solveMaze();
    }
    public static void testSolveMaze2() {
        Robot.load("maze2.txt");
        Robot.setDelay(5);
        solveMaze();
    }
    public static void testSort1() {
        Robot.load("sort1.txt");
        Robot.setDelay(5);
        sort();
    }
    public static void testSort2() {
        Robot.load("sort3.txt");
        Robot.setDelay(5);
        sort();
    }
    public static void testSort(String filename, int delay) {
        Robot.load("/Users/jimphieffer/Downloads/cs1lab3/" + filename);
        Robot.setDelay(delay);
        sort();
    }
    public static void sort() {
        sortRow();
        while(nextRow()) sortRow();
        sortRow();
    }
    public static boolean nextRow() {
        boolean b;
        turnAround();
        while(Robot.frontIsClear()) Robot.move();
        Robot.turnLeft();
        if(Robot.frontIsClear()) {
            b = true;
            Robot.move();
        }
        else b = false;
        Robot.turnLeft();
        return b;
    }
    public static void toBeginning() {
        turnAround();
        while(Robot.frontIsClear()) Robot.move();
        turnAround();
    }
    public static void sortRow() {
        boolean done = false;
        boolean b = false;
        while (!done) {
            //move down the line and look for a dark tile
            done = true;
            while(!Robot.onDark() && Robot.frontIsClear()) Robot.move();
            if(Robot.onDark()) Robot.makeLight();
            while(Robot.frontIsClear()) Robot.move();
            turnAround();
            while(Robot.onDark()) {
                if(!Robot.onDark()) done = false;
                Robot.move();
            }
            if(!Robot.onDark()) Robot.makeDark();
            b = false;
            while(Robot.frontIsClear()) {
                if(!Robot.onDark()) b = true;
                else if (Robot.onDark() && b) done = false;
                Robot.move();
            }
            turnAround();
        }
    }
}