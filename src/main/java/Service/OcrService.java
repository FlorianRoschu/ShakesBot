package Service;

import Enum.State;

import java.awt.*;
import java.util.List;

public class OcrService {

    private final RobotService robotService;

    private OcrService(RobotService robotService) {
        this.robotService = robotService;
    }

    private static OcrService instance;

    public static OcrService getInstance() {
        if(instance == null) {
            instance = new OcrService(RobotService.getInstance());
        }
        return instance;
    }

    public boolean isInExpectedState(State expectedState) {

        int xFrom = expectedState.getXFrom();
        int xTo = expectedState.getXTo();
        int yFrom = expectedState.getYFrom();
        int yTo = expectedState.getYTo();
        List<Color> colors = expectedState.getColors();

        // Check the designated area of any pixel that is not expected
        for(int i = yFrom; i <= yTo; i++) {
            for(int j = xFrom; j <= xTo; j++) {
                Color actualColor = robotService.getColor(j, i);
                System.out.println(actualColor.getColorSpace().getName(1));
//                if(!isAcceptedColor(actualColor, colors)) {
//                    return false;
//                }
            }
        }
        return true;
    }

    public boolean isAcceptedColor(Color color, List<Color> acceptedColors) {
        for(Color acceptedColor : acceptedColors) {
            if(color == acceptedColor) {
                return true;
            }
        }
        return false;
    }

}
