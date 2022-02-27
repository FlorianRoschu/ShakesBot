package Service;

import Enum.Position;

public class AdService {

    private final RobotService robotService;

    public AdService(RobotService robotService) {
        this.robotService = robotService;
    }

    private static AdService instance;

    public static AdService getInstance() {
        if(instance == null) {
            instance = new AdService(RobotService.getInstance());
        }
        return instance;
    }

    public void openAd() {
        System.out.println("Opening Ad.");
        robotService.clickOnPosition(Position.AD_OPEN);
    }

    public void closeAd() {
        System.out.println("Closing Ad.");
        robotService.clickOnPosition(Position.AD_CLOSE);
    }

    public void wait4Ad() {
        System.out.println("Waiting for the Ad to finish.");
        robotService.sleep(40);
    }

}
