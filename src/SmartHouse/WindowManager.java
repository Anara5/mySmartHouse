package SmartHouse;

public class WindowManager {

    private final Window[] windows;

    public WindowManager (Window[] windows) {
        this.windows = windows;
    }

    public void closeAllWindows() {

        for (Window window : windows){
            window.close();
        }
    }

    public void openAllWindows() {

        for (Window window : windows) {
            window.open();
        }
    }
}
