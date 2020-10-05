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
    }
    public static void moveSmallest2()
    {
        moveToLight();
        turnAround();
        if(Robot.frontIsClear()) Robot.move();
        Robot.turnLeft();
        while(frontIsDark() || !Robot.onDark()){
            turnRight();
            moveToWall();
            turnAround();
            FastLab4.newNextBase();
            moveToLight();
            turnAround();
            if(Robot.frontIsClear()) Robot.move();
            Robot.turnLeft();
        }
        turnRight();
        Robot.makeLight();
        moveToWall();
        turnAround();
        FastLab4.newNextBase();
        moveToLight();
        Robot.makeDark();
        turnAround();
        moveToWall();
        turnAround();
    }
    public static void moveNonSmallest2()
    {
        int t1 = topWidth();
        FastLab4.newNextBase();
        int t2 = topWidth();
        FastLab4.newNextBase();
        int t3 = topWidth();
        FastLab4.newNextBase();
        if(t1 > 1 && t1 < 9999) {
            if(t2 > t1) moveTopToNextBase2();
            else if (t3 > t1) moveTopToPreviousBase2();
        }
        FastLab4.newNextBase();
        if(t2 > 1 && t2 < 9999) {;
            if(t3 > t2) moveTopToNextBase2();
            else if (t1 > t2) moveTopToPreviousBase2();
        }
        FastLab4.newNextBase();
        if(t3 > 1 && t3 < 9999) {
            if(t1 > t3) moveTopToNextBase2();
            else if (t2 > t3) moveTopToPreviousBase2();
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
        int k = widthBuffer;
        while(k > 0) {
            Robot.move();
            Robot.makeLight();
            k--;
        }
        Robot.turnLeft();
        moveToWall();
        turnAround();
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
    public static void moveTopToPreviousBase2()
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
        int k = widthBuffer;
        while(k > 0) {
            Robot.move();
            Robot.makeLight();
            k--;
        }
        Robot.turnLeft();
        moveToWall();
        turnAround();
        FastLab4.newNextBase();
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

    /////////////////
    public static void moveTower2()
    {
        setTowerWidth();
        int n = 0;
        while(n != 1) {
            FastLab4.moveSmallest2();
            FastLab4.moveNonSmallest2();
            n = numTowers2();
        }
    }
    ////////////
    public static int numTowers2()
    {
        int iter = 0;
        int numTowers2 = 0;
        while (iter < 3) {
            FastLab4.newNextBase();
            if(Robot.onDark()) numTowers2++;
            iter++;
        }
        return numTowers2;  //Delete this line when you start working on this method.
    }
}
