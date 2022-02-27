package Enum;

import java.awt.*;
import java.util.List;

public enum State {

    AD_FINISHED(800, 1120, 340, 370, List.of(new Color(0, 255, 0), Color.GREEN)),
    AD_ONGOING(807, 819, 347, 363, List.of(Color.BLACK, Color.GREEN));

    private final int xFrom;
    private final int xTo;
    private final int yFrom;
    private final int yTo;
    private final List<Color> colors;

    private State(int xFrom, int xTo, int yFrom, int yTo, List<Color> colors) {
        this.xFrom = xFrom;
        this.xTo = xTo;
        this.yFrom = yFrom;
        this.yTo = yTo;
        this.colors = colors;
    }

    public int getXFrom() {
        return xFrom;
    }

    public int getXTo() {
        return xTo;
    }

    public int getYFrom() {
        return yFrom;
    }

    public int getYTo() {
        return yTo;
    }

    public List<Color> getColors() {
        return colors;
    }

}
