//Be sure to have the Google document open with instructions
//while you work on the lab!

public class Lab4
{
    public static void loadTest1()
    {
        Robot.load("test1.txt");
        Robot.setDelay(10);
    }

    public static void loadTest2()
    {
        Robot.load("test2.txt");
        Robot.setDelay(10);
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
    }

    //pre:   on a base
    //post:  in same place; returns number of non-empty bases
    public static int numTowers()
    {
        return 0;  //Delete this line when you start working on this method.
    }

    //pre:   in leftmost square of a disk
    //post:  in same place; returns width of disk
    public static int width()
    {
        return 0;  //Delete this line when you start working on this method.
    }

    //pre:   on a base
    //post:  in same place; returns width of top disk, or 9999 if base is empty
    public static int topWidth()
    {
        return 0;  //Delete this line when you start working on this method.
    }

    //pre:   on a base
    //post:  on base with smallest disk
    public static void findSmallest()
    {
    }

    //pre:   on a base
    //post:  smallest disk has been moved to top of next base; robot on that base
    public static void moveSmallest()
    {
    }

    //pre:   on a non-empty base
    //post:  top disk has been moved to top of next base (to right);
    //       robot on that base
    public static void moveTopToNextBase()
    {
    }

    //pre:   on a non-empty base
    //post:  top disk has been moved to top of previous base (to left);
    //       robot on that base
    public static void moveTopToPreviousBase()
    {
    }

    //pre:   on a base
    //post:  top disk has been moved on top of larger disk on another base;
    //       robot on that base
    public static void moveNonSmallest()
    {
    }

    //pre:   on a base; there is only one tower
    //post:  tower has moved to a different base; robot on some base
    public static void moveTower()
    {
    }
}