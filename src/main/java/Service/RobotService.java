package Service;

import java.awt.*;
import java.awt.event.InputEvent;

import Enum.Position;
import Enum.Location;

public class RobotService {

    private static final int SECOND = 1000;

    private Robot robot;

    private static RobotService instance;

    public RobotService() {
        try {
            this.robot = new Robot(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
        } catch(AWTException awte) {
            System.out.println("Initializing the Robot failed.");
        }
    }

    public static RobotService getInstance() {
        if(instance == null) {
            instance = new RobotService();
        }
        return instance;
    }

    public void moveToLocation(Location location) {
        robot.keyPress(location.getKeyCode());
        robot.delay(100);
        robot.keyRelease(location.getKeyCode());
        robot.delay(500);
    }

    public void clickOnPosition(Position position) {
        robot.mouseMove(position.getX(), position.getY());
        robot.delay(100);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(500);
    }

    public void sleep(int seconds) {
        robot.delay(SECOND * seconds);
    }

    public Color getColor(int x, int y) {
        return robot.getPixelColor(x, y);
    }

}
