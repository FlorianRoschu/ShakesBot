package Service;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.io.IOException;

public class SystemService {

    private final RobotService robotService;

    public SystemService(RobotService robotService) {
        this.robotService = robotService;
    }

    private static SystemService instance;

    public static SystemService getInstance() {
        if(instance == null) {
            instance = new SystemService(RobotService.getInstance());
        }
        return instance;
    }

    public void bootOrFocus() {
        if(isShakesOpen()) {
            System.out.println("Shakes allready started. Making it focused window.");
            focusShakes();
        } else {
            System.out.println("Shakes not started yet. Booting it now.");
            openChromeWithShakes();
            wait4Boot();
            if(!isShakesFocused()) {
                System.exit(1);
            }
        }
    }

    public boolean isShakesFocused() {
        User32 user32 = User32.INSTANCE;
        WinDef.HWND shakesWindow = getShakesWindow();
        if(!user32.IsWindowEnabled(shakesWindow) || shakesWindow == null) {
            System.out.println("Shakes window not focused anymore. Terminating program.");
            return false;
        }
        return true;
    }

    private void focusShakes() {
        User32 user32 = User32.INSTANCE;
        WinDef.HWND shakesWindow = getShakesWindow();
        user32.ShowWindow(shakesWindow, 3);
        user32.SetForegroundWindow(shakesWindow);
    }

    private boolean isShakesOpen() {
        return getShakesWindow() != null;
    }

    private void openChromeWithShakes() {
        String path = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(path + " https://w53.sfgame.net");
        } catch(IOException ioe) {
            System.out.println("Opening Chrome failed.");
        }
    }

    private void wait4Boot() {
        robotService.sleep(10);
    }

    private WinDef.HWND getShakesWindow() {
        User32 user32 = User32.INSTANCE;
        WinDef.HWND shakesWindow = user32.FindWindow("Chrome_WidgetWin_1", null);
        if(shakesWindow == null) {
            System.out.println("Window with Class 'Chrome_WidgetWin_1' not found, try to search for the name 'Shakes & Fidget (11.000.220105.1) - Google Chrome'.");
            shakesWindow = user32.FindWindow(null, "Shakes & Fidget (11.000.220105.1) - Google Chrome");
            if(shakesWindow == null) {
                System.out.println("Window with Name 'Shakes & Fidget (11.000.220105.1) - Google Chrome' not found. Abort the process.");
            }
        }
        return shakesWindow;
    }

    public String getWindowName(WinDef.HWND window) {
        User32 user32 = User32.INSTANCE;

        int length = 100;
        char[] chars = new char[length];
        user32.GetWindowText(window, chars, length);

        return buildString(chars);
    }

    private String buildString(char[] chars) {
        String result = "";
        for(char c : chars) {
            if(c != '\u0000') {
                result = result + c;
            }
        }
        return result;
    }

}
