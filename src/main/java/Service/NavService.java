package Service;

import Enum.Location;

public class NavService {

    private final RobotService robotService;

    public NavService(RobotService robotService) {
        this.robotService = robotService;
    }

    private static NavService instance;

    public static NavService getInstance() {
        if(instance == null) {
            instance = new NavService(RobotService.getInstance());
        }
        return instance;
    }

    public void toTavern() {
        System.out.println("Moving to Tavern.");
        robotService.moveToLocation(Location.TAVERN);
    }

    public void toWheel() {
        System.out.println("Moving to Wheel.");
        robotService.moveToLocation(Location.WHEEL);
    }

}
