public class FastLab4 extends Lab4 {
    public static int towerWidth = 0;
    public static int towerOn = 0;
    public static void setTowerWidth() {
        turnRight();
        moveToWall();
        turnAround();
        Robot.move();
        Robot.turnLeft();
        int i = 0;
        while (!Robot.frontIsClear()) {
            turnRight();
            Robot.move();
            Robot.turnLeft();
            i++;
        }
        Robot.turnLeft();
        Robot.move();
        Robot.turnLeft();
        towerWidth = i;
        towerOn = 3;
    }
    public static void newNextBase() {
        if (towerOn != 3) {
            turnRight();
            int i = 0;
            while(i < towerWidth) {
                Robot.move();
                i++;
            }
            Robot.move();
            Robot.turnLeft();
            towerOn++;
        }
        else {
            Robot.turnLeft();
            moveToWall();
            turnAround();
            Robot.move();
            Robot.turnLeft();
            towerOn = 1;
        }
        System.out.println("Currently on tower "+ towerOn);
    }
    public static void moveSmallest2()
    {
        moveToLight();
        turnAround();
        if(Robot.frontIsClear()) Robot.move();
        Robot.turnLeft();
        while(frontIsDark() || !Robot.onDark()){
            Robot.turnLeft();
            newNextBase();
            moveToLight();
            turnAround();
            if(Robot.frontIsClear()) Robot.move();
            Robot.turnLeft();
        }
        turnRight();
        Robot.makeLight();
        moveToWall();
        turnAround();
        newNextBase();
        moveToLight();
        Robot.makeDark();
        turnAround();
        moveToWall();
        turnAround();
    }
    public static void moveNonSmallest2()
    {
        int t1 = topWidth();
        newNextBase();
        int t2 = topWidth();
        newNextBase();
        int t3 = topWidth();
        newNextBase();
        if(t1 > 1 && t1 < 9999) {
            if(t2 > t1) moveTopToNextBase();
            else if (t3 > t1) moveTopToPreviousBase();
        }
        newNextBase();
        if(t2 > 1 && t2 < 9999) {;
            if(t3 > t2) moveTopToNextBase();
            else if (t1 > t2) moveTopToPreviousBase();
        }
        newNextBase();
        if(t3 > 1 && t3 < 9999) {
            if(t1 > t3) moveTopToNextBase();
            else if (t2 > t3) moveTopToPreviousBase();
        }
    }
    public static boolean frontIsDark() {
        Robot.move();
        boolean b = Robot.onDark();
        turnAround();
        Robot.move();
        turnAround();
        return b;
    }

    public static void moveTopToNextBase2()
    {
        int widthBuffer = 0;
        moveToLight();
        turnAround();
        if(Robot.frontIsClear()) Robot.move();
        Robot.turnLeft();
        while(Robot.onDark()) {
            Robot.move();
            widthBuffer++;
        }
        turnAround();
        Robot.move();
        int k = widthBuffer;
        while(k > 0) {
            Robot.move();
            Robot.makeLight();
            k--;
        }
        FastLab4.newNextBase();
        moveToLight();
        turnRight();
        int j = widthBuffer;
        if(j == 9999) {j = 0; widthBuffer = 0;}
        while(j != 0) {
            Robot.makeDark();
            Robot.move();
            j--;
        }
        turnAround();
        while(widthBuffer != 0) {
            Robot.move();
            widthBuffer--;
        }
        Robot.turnLeft();
        moveToWall();
        turnAround();
    }
}
