import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Lab2
{	
	public static String path = Paths.get("").toAbsolutePath().toString() + File.separator + "cs1lab2" + File.separator;
	public static void main(String[] args) {
		try {
			Lab2Test.test();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    //Complete this method.  You will need to write additional helper methods.
    public static void lightCandles()
    {	
        Robot.turnLeft();
        Robot.move();
        turnRight();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    	checkACandle();
    }

    //This method has been provided to help you test your code.
    //Do not modify this code.
    public static void testLightCandles1()
    {
        Robot.load(path + "candles1.txt");
        Robot.setDelay(5);
        lightCandles();
    }

    //This method has been provided to help you test your code.
    //Do not modify this code.
    public static void testLightCandles2()
    {
        Robot.load(path + "candles2.txt");
        Robot.setDelay(5);
        lightCandles();
    }


    //Complete this method.  You will need to write additional helper methods.
    public static void swapAll()
    {
        //insert instructions below
    	turnRight();
    	Robot.move();
    	Robot.turnLeft();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    	Robot.move();
    	checkLeft();
    
    }

    //This method has been provided to help you test your code.
    //Do not modify this code.
    public static void testSwapAll1()
    {
        Robot.load(path + "swap1.txt");
        Robot.setDelay(5);
        swapAll();
    }

    //This method has been provided to help you test your code.
    //Do not modify this code.
    public static void testSwapAll2()
    {
        Robot.load(path + "swap2.txt");
        Robot.setDelay(5);
        swapAll();
    } 
    
    //ADDITIONAL CREDIT! 
    
    //Complete this method.  You will need to write additional helper methods.
    public static void completeRoom()
    {
        //insert instructions below
    	checkARow();
    	checkARow();
    	checkARow();
    	checkARow();
    	
    }

    //This method has been provided to help you test your code.
    //Do not modify this code.
    public static void testCompleteRoom1()
    {
        Robot.load(path + "room1.txt");
        Robot.setDelay(50);
        completeRoom();
    }

    //This method has been provided to help you test your code.
    //Do not modify this code.
    public static void testCompleteRoom2()
    {
    	Robot.load(path + "room2.txt");
        Robot.setDelay(50);
        completeRoom();
    }
    public static void carpetTallRooms() {
    	Robot.load(path + "carpet.txt");
    	Robot.setDelay(50);
    	carpetOneRoom();
    	carpetOneRoom();
    	carpetOneRoom();
    	carpetOneRoom();
    	carpetOneRoom();
    	carpetOneRoom();
    	carpetOneRoom();
    	carpetOneRoom();
    }
    public static void cleanOrSleep() {
    	Robot.load(path + "sleep.txt");
    	Robot.setDelay(50);
    	turnRight();
    	doARoom();
    	Robot.move();
    	Robot.move();
    	doARoom();
    	Robot.move();
    	Robot.move();
    	doARoom();
    	Robot.move();
    	Robot.move();
    	doARoom();
    	Robot.move();
    	Robot.move();
    	doARoom();
    }
    public static void carpetOneRoom() {
    	if(Robot.frontIsClear()) {
    		Robot.move();
    		Robot.move();
    		Robot.turnLeft();
    	}
    	if(!Robot.frontIsClear()) {
    		Robot.turnLeft();
    		Robot.turnLeft();
    		makeDarkMove();
    	}
    	else if(moveCheckSides()) {
    		if(!Robot.frontIsClear()) {
        		Robot.turnLeft();
        		Robot.turnLeft();
        		makeDarkMove();
        	}
        	else if(moveCheckSides()) {
        		if(!Robot.frontIsClear()) {
            		Robot.turnLeft();
            		Robot.turnLeft();
            		makeDarkMove();
            		makeDarkMove();
            	}
            	else if(moveCheckSides()) {
            		if(!Robot.frontIsClear()) {
                		Robot.turnLeft();
                		Robot.turnLeft();
                		makeDarkMove();
                		makeDarkMove();
                		makeDarkMove();
                	}
                	else if(moveCheckSides()) {
                		if(!Robot.frontIsClear()) {
                    		Robot.turnLeft();
                    		Robot.turnLeft();
                    		makeDarkMove();
                    		makeDarkMove();
                    		makeDarkMove();
                    		makeDarkMove();
                    	}
                    	else if(moveCheckSides()) {
                    		if(!Robot.frontIsClear()) {
                        		Robot.turnLeft();
                        		Robot.turnLeft();
                        		makeDarkMove();
                        		makeDarkMove();
                        		makeDarkMove();
                        		makeDarkMove();
                        		makeDarkMove();
                        	}
                        	else if(moveCheckSides()) {
                        		Robot.turnLeft();
                        		Robot.turnLeft();
                        		makeDarkMove();
                        		makeDarkMove();
                        		makeDarkMove();
                        		makeDarkMove();
                        		makeDarkMove();
                        		makeDarkMove();
                        	}	
                        	else {
                        		Robot.turnLeft();
                        		Robot.turnLeft();
                        		Robot.move();
                        		Robot.move();
                        		Robot.move();
                        		Robot.move();
                        		Robot.move();
                        		Robot.move();
                        	}
                    	}
                    	else {
                    		Robot.turnLeft();
                    		Robot.turnLeft();
                    		Robot.move();
                    		Robot.move();
                    		Robot.move();
                    		Robot.move();
                    		Robot.move();
                    	}
                	}
                	else {
                		Robot.turnLeft();
                		Robot.turnLeft();
                		Robot.move();
                		Robot.move();
                		Robot.move();
                		Robot.move();
                	}
            	}
            	else {
            		Robot.turnLeft();
            		Robot.turnLeft();
            		Robot.move();
            		Robot.move();
            		Robot.move();
            	}
        	}
        	else {
        		Robot.turnLeft();
        		Robot.turnLeft();
        		Robot.move();
        		Robot.move();
        	}
    	}
    	else {
    		Robot.turnLeft();
    		Robot.turnLeft();
    		Robot.move();
    	}
    	Robot.turnLeft();
    }
    public static boolean moveCheckSides() {
    	if(Robot.frontIsClear()) {
    		Robot.move();
    		Robot.turnLeft();
    		if(!Robot.frontIsClear()) {
    			Robot.turnLeft();
    			Robot.turnLeft();
    			if(!Robot.frontIsClear()) {
    				Robot.turnLeft();
    				return true;
    			}
    			else{Robot.turnLeft();}
    		}
    		else {turnRight();}
    	}
		return false;
    }
    public static void makeDarkMove() {
    	Robot.makeDark();
    	Robot.move();
    }
    public static void turnRight() {
    	Robot.turnLeft();
    	Robot.turnLeft();
    	Robot.turnLeft();
    }
    public static void checkACandle() {
    	if (Robot.frontIsClear()) {smallCandle();}
    	else {bigCandle();}
    }
    public static void smallCandle() {
    	Robot.move();
    	Robot.makeDark();
    	Robot.move();
    }
    public static void bigCandle() {
    	Robot.turnLeft();
    	Robot.move();
    	turnRight();
    	Robot.move();
    	Robot.makeDark();
    	Robot.move();
    	turnRight();
    	Robot.move();
    	Robot.turnLeft();
    }

    public static void checkLeft() {
    	if (!Robot.onDark()) {
    		toLeft();
    		checkRight();
    		if (Robot.onDark()) {
    			Robot.makeLight();
    		}
    		toRight();
    	}
    	else {
    		toLeft();
    		checkRight();
    		if (!Robot.onDark()) {
    			Robot.makeDark();
    		}
    		toRight();
    	}
    }
    public static void checkRight() {
    	if (!Robot.onDark()) {
    		toRight();
    		if (Robot.onDark()) {
    			Robot.makeLight();
    		}
    		toLeft();
    	}
    	else {
    		toRight();
    		if (!Robot.onDark()) {
    			Robot.makeDark();
    		}
    		toLeft();
    	}
    }
    public static void toLeft() {
    	Robot.turnLeft();
    	Robot.move();
    	Robot.move();
    	turnRight();
    }
    public static void toRight() {
    	turnRight();
    	Robot.move();
    	Robot.move();
    	Robot.turnLeft();
    }
    public static void checkSquare() {
    	Robot.turnLeft();
    	if(Robot.frontIsClear()) {
    		Robot.move();
    		if(!Robot.onDark()) {Robot.makeDark();}
    		Robot.turnLeft();
    		Robot.turnLeft();
    		Robot.move();
    		Robot.turnLeft();
    		Robot.turnLeft();
    	}
    	turnRight();
    }
    public static void checkARow() {
    	checkSquare();
    	Robot.move();
    	checkSquare();
    	Robot.move();
    	checkSquare();
    	Robot.move();
    	checkSquare();
    	Robot.move();
    	checkSquare();
    	turnRight();
    }
    
    public static boolean checkDown() {
    	if(!Robot.onDark()) {
    		Robot.move();
    		if(!Robot.onDark()) {
    			Robot.move();
        		if(!Robot.onDark()) {
        			Robot.move();
            		if(!Robot.onDark()) {
            			Robot.move();
                		if(!Robot.onDark()) {
                			Robot.turnLeft();
                	    	if(Robot.frontIsClear()) {
                	    		Robot.move();
                	    	}
                	    	Robot.turnLeft();
                			return true;
                		}
                		else {
                    		checkMoves();
                    	}
            		}	
            		else {
                		checkMoves();
                	}
        		}
        		else {
            		checkMoves();
            	}
    		}
    		else {
        		checkMoves();
        	}
    	}
    	else {
    		checkMoves();
    	}
    	Robot.turnLeft();
    	if(Robot.frontIsClear()) {
    		Robot.move();
    	}
    	Robot.turnLeft();
    	return false;
    }
    public static boolean checkUp() {
    	if(!Robot.onDark()) {
    		Robot.move();
    		if(!Robot.onDark()) {
    			Robot.move();
        		if(!Robot.onDark()) {
        			Robot.move();
            		if(!Robot.onDark()) {
            			Robot.move();
                		if(!Robot.onDark()) {
                			turnRight();
                	    	if(Robot.frontIsClear()) {
                	    		Robot.move();
                	    		turnRight();
                	    	}
                	    	else {
                	    		turnRight();
                	    	}
                			return true;
                		}
                		else {
                    		checkMoves();
                    	}
            		}	
            		else {
                		checkMoves();
                	}
        		}
        		else {
            		checkMoves();
            	}
    		}
    		else {
        		checkMoves();
        	}
    	}
    	else {
    		checkMoves();
    	}
    	turnRight();
    	if(Robot.frontIsClear()) {
    		Robot.move();
    		turnRight();
    	}
    	else {
    		turnRight();
    	}
    	return false;
    }
    public static void checkMoves() {
    	if(Robot.frontIsClear()) {
    		Robot.move();
    		if(Robot.frontIsClear()) {
        		Robot.move();
        		if(Robot.frontIsClear()) {
            		Robot.move();
            		if(Robot.frontIsClear()) {
                		Robot.move();
                		if(Robot.frontIsClear()) {
                    		Robot.move();
                    	}
                	}
            	}
        	}
    	}
    }
    public static void doARoom() {
    	enterRoom();
    	if(checkDown()) {
    		if (checkUp()) {
    			if (checkDown()) {
    				if(checkUp()) {
    					if(checkDown()) {
    						backToTheStart();
    			    		darkenWholeRoom();
    			    		turnRight();
    			        	checkMoves();
    			        	turnRight();
    			        	Robot.turnLeft();
    			        	Robot.turnLeft();
    					}
    					else {
    						backToTheStart();
    					}
    				}
    				else {
    					checkDown();
    					backToTheStart();
    				}
    			}
    			else {
    				checkUp();
    				checkDown();
    				backToTheStart();
    			}
    		}
    		else {
    			checkDown();
    			checkUp();
    			checkDown();
    			backToTheStart();
    		}
    		
    	}
    	else {
    		checkUp();
    		checkDown();
			checkUp();
			checkDown();
    		backToTheStart();
    	}
    	exitRoom();
    }
    public static void backToTheStart() {
    	Robot.turnLeft();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	turnRight();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	Robot.move();
    	Robot.turnLeft();
    	Robot.turnLeft();
    }
    public static void enterRoom() {
    	Robot.move();
    	Robot.move();
    	turnRight();
    	Robot.move();
    	Robot.move();
    	turnRight();
    	Robot.move();
    	Robot.move();
    	Robot.turnLeft();
    }
    public static void exitRoom() {
    	Robot.turnLeft();
    	Robot.move();
    	Robot.move();
    	Robot.turnLeft();
    	Robot.move();
    	Robot.move();
    	turnRight();
    	Robot.move();
    	Robot.move();
    }
    public static void darkenWholeRoom() {
    	darkenRow();
    	Robot.turnLeft();
    	Robot.move();
    	Robot.turnLeft();
    	darkenRow();
    	turnRight();
    	Robot.move();
    	turnRight();
    	darkenRow();
    	Robot.turnLeft();
    	Robot.move();
    	Robot.turnLeft();
    	darkenRow();
    	turnRight();
    	Robot.move();
    	turnRight();
    	darkenRow();
    	turnRight();
    	checkMoves();
    	turnRight();
    	checkMoves();
    	Robot.turnLeft();
    	Robot.turnLeft();
    }
    public static void darkenRow() {
    	makeDarkMove();
    	makeDarkMove();
    	makeDarkMove();
    	makeDarkMove();
    	Robot.makeDark();
    }

    //for other additional credits, add your own methods
}