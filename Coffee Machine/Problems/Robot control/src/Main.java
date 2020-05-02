public static void moveRobot(Robot robot, int toX, int toY) {    
    while (toX != robot.getX()) {
        if (toX > robot.getX()) {
            // turn to the right direction
            switch (robot.getDirection()) {
                case RIGHT: 
                    break;
                case DOWN: 
                    robot.turnLeft(); 
                    break;
                case LEFT: 
                    robot.turnRight(); 
                    robot.turnRight(); 
                    break;
                case UP: 
                    robot.turnRight(); 
                    break;
                default:
                    System.out.println("illegle input");
            }
            // go to the right position
            for (int i = robot.getX(); i < toX; i++) {
                robot.stepForward();
            }
            break;
        } else {
            // turn to the right direction
            switch (robot.getDirection()) {
                case RIGHT: 
                    robot.turnRight(); 
                    robot.turnRight(); 
                    break;
                case DOWN: 
                    robot.turnRight(); 
                    break;
                case LEFT: 
                    break;
                case UP: 
                    robot.turnLeft(); 
                    break;
                default:
                    System.out.println("illegle input");
            }
            // go to the right position
            for (int i = robot.getX(); i > toX; i--) {
                robot.stepForward();
            }
            break;
        }
    }
    
    while (toY != robot.getY()) {
        if (toY > robot.getY()) {
            // turn to the right direction
            switch (robot.getDirection()) {
                case RIGHT: 
                    robot.turnLeft();
                    break;
                case DOWN: 
                    robot.turnRight(); 
                    robot.turnRight(); 
                    break;
                case LEFT: 
                    robot.turnRight(); 
                    break;
                case UP: 
                    break;
                default:
                    System.out.println("illegle input");
            }
            // go to the right position
            for (int i = robot.getY(); i < toY; i++) {
                robot.stepForward();
            }
            break;
        } else {
            // turn to the right direction
            switch (robot.getDirection()) {
                case RIGHT: 
                    robot.turnRight(); 
                    break;
                case DOWN: 
                    break;
                case LEFT:
                    robot.turnLeft();
                    break;
                case UP: 
                    robot.turnRight();
                    robot.turnRight(); 
                    break;
                default:
                    System.out.println("illegle input");
            }
            // go to the right position
            for (int i = robot.getY(); i > toY; i--) {
                robot.stepForward();
            }
            break;
        }
    }
}
