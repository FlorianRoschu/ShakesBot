package Enum;

public enum Position {

    AD_OPEN(680, 230),
    AD_CLOSE(1273, 344);

    private int x;
    private int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
