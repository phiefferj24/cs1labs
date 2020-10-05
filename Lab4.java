//Be sure to have the Google document open with instructions
//while you work on the lab!

public class Lab4
{
    public static void main(String[] args) {
        System.out.println(Add.addAll(35));
    }
    public static void loadTest1()
    {
        Robot.load("test1.txt");
        Robot.setDelay(1);
    }

    public static void loadTest2()
    {
        Robot.load("test2.txt");
        Robot.setDelay(1);
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

    public static void turnRight()
    {
        int turnsMade;
        turnsMade = 0;
        while ( turnsMade < 3 )
        {
            Robot.turnLeft();
            turnsMade = turnsMade + 1;
        }
    }

    public static void moveToWall()
    {
        while ( Robot.frontIsClear() )
        {
            Robot.move();
        }
    }

    public static void moveToLight()
    {
        while ( Robot.onDark() )
        {
            Robot.move();
        }
    }

    //All of the methods below require (1) that the robot is facing north and
    //(2) that the robot is left-aligned with one of the bases
    //(above the leftmost wall of the base).
    //After these methods are called, both of these conditions must remain true.

    //pre:   on a base
    //post:  on next base to right
    //       (if was on rightmost base, now on leftmost base)
    public static void nextBase()
    {
        turnAround();
        while ( !Robot.frontIsClear() )
        {
            Robot.turnLeft();
            Robot.move();
            turnRight();
        }
        Robot.turnLeft();
        if ( Robot.frontIsClear() )
        {
            Robot.move();
            Robot.turnLeft();
        }
        else
        {
            turnAround();
            moveToWall();
            backUp();
            turnRight();
        }
    }

    //pre:   on a non-empty base
    //post:  in same place; top has been removed
    public static void removeTop()
    {
        moveToLight();
        turnAround();
        if(Robot.frontIsClear()) Robot.move();
        Robot.turnLeft();
        int dist = 0;
        while(Robot.onDark()) {
            Robot.makeLight();
            dist++;
            Robot.move();
        }
        turnAround();
        while(dist != 0) {
            Robot.move();
            dist--;
        }
        Robot.turnLeft();
        moveToWall();
        turnAround();
    }

    //pre:   on a base
    //post:  in same place; returns number of non-empty bases
    public static int numTowers()
    {
        int iter = 0;
        int numTowers = 0;
        while (iter < 3) {
            nextBase();
            if(Robot.onDark()) numTowers++;
            iter++;
        }
        return numTowers;  //Delete this line when you start working on this method.
    }

    //pre:   in leftmost square of a disk
    //post:  in same place; returns width of disk
    public static int width()
    {
        int w = 0;
        turnRight();
        while(Robot.onDark()) {
            w++;
            Robot.move();
        }
        int x = w;
        turnAround();
        while (w != 0) {
            w--;
            Robot.move();
        }
        turnRight();
        return x;  //Delete this line when you start working on this method.
    }

    //pre:   on a base
    //post:  in same place; returns width of top disk, or 9999 if base is empty
    public static int topWidth()
    {
        moveToLight();
        turnAround();
        if(Robot.frontIsClear()) Robot.move();
        turnAround();
        int y = width();
        turnAround();
        moveToWall();
        turnAround();
        if(y == 0) y = 9999;
        return y;
    }

    //pre:   on a base
    //post:  on base with smallest disk
    public static void findSmallest()
    {
        while(topWidth() != 1) nextBase();
    }

    //pre:   on a base
    //post:  smallest disk has been moved to top of next base; robot on that base
    public static void moveSmallest()
    {
        findSmallest();
        removeTop();
        nextBase();
        moveToLight();
        Robot.makeDark();
        turnAround();
        moveToWall();
        turnAround();
    }

    //pre:   on a non-empty base
    //post:  top disk has been moved to top of next base (to right);
    //       robot on that base
    public static void moveTopToNextBase()
    {
        int i = topWidth();
        removeTop();
        nextBase();
        moveToLight();
        turnRight();
        int j = i;
        if(j == 9999) {j = 0; i = 0;}
        while(j != 0) {
            Robot.makeDark();
            Robot.move();
            j--;
        }
        turnAround();
        while(i != 0) {
            Robot.move();
            i--;
        }
        Robot.turnLeft();
        moveToWall();
        turnAround();
    }

    //pre:   on a non-empty base
    //post:  top disk has been moved to top of previous base (to left);
    //       robot on that base
    public static void moveTopToPreviousBase()
    {
        int i = topWidth();
        removeTop();
        nextBase();
        nextBase();
        moveToLight();
        turnRight();
        int j = i;
        if(j == 9999) {j = 0; i = 0;}
        while(j != 0) {
            Robot.makeDark();
            Robot.move();
            j--;
        }
        turnAround();
        while(i != 0) {
            Robot.move();
            i--;
        }
        Robot.turnLeft();
        moveToWall();
        turnAround();
    }

    //pre:   on a base
    //post:  top disk has been moved on top of larger disk on another base;
    //       robot on that base
    public static void moveNonSmallest()
    {
        int t1 = topWidth();
        nextBase();
        int t2 = topWidth();
        nextBase();
        int t3 = topWidth();
        nextBase();
        if(t1 > 1 && t1 < 9999) {
            if(t2 > t1) moveTopToNextBase();
            else if (t3 > t1) moveTopToPreviousBase();
        }
        nextBase();
        if(t2 > 1 && t2 < 9999) {;
            if(t3 > t2) moveTopToNextBase();
            else if (t1 > t2) moveTopToPreviousBase();
        }
        nextBase();
        if(t3 > 1 && t3 < 9999) {
            if(t1 > t3) moveTopToNextBase();
            else if (t2 > t3) moveTopToPreviousBase();
        }
    }

    //pre:   on a base; there is only one tower
    //post:  tower has moved to a different base; robot on some base
    public static void moveTower()
    {
        int n = 0;
        while(n != 1) {
            moveSmallest();
            moveNonSmallest();
            n = numTowers();
        }
    }
    public static long towerTimer() {
        long startTime = System.currentTimeMillis();
        moveTower();
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }
    public static void runTimes() {
        int x = 1;
        while(x < 11) {
            Robot.load("t"+x+".txt");
            System.out.println(x+" : " + towerTimer());
            x++;
        }
    }
}