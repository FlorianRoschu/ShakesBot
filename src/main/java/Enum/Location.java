package Enum;

import java.awt.event.KeyEvent;

public enum Location {

    TAVERN(KeyEvent.VK_T, 1),
    WHEEL(KeyEvent.VK_R, 1);

    private final int keyCode;
    private final int clicks;

    private Location(int keyCode, int clicks) {
        this.keyCode = keyCode;
        this.clicks = clicks;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getClicks() {
        return clicks;
    }
}
