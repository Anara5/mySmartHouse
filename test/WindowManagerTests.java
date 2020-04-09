import SmartHouse.Window;
import SmartHouse.WindowManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WindowManagerTests {

    @Test
    void closesAllWindows() {

        TestWindow testWindow = new TestWindow(WindowState.OPEN);
        WindowManager manager = new WindowManager(
                new Window[]{testWindow});

        manager.closeAllWindows();
        assertEquals(WindowState.CLOSED, testWindow.state);
    }

    @Test
    void opensAllWindows() {

        TestWindow testWindow = new TestWindow(WindowState.CLOSED);
        WindowManager manager = new WindowManager(
                new Window[]{testWindow});

        manager.openAllWindows();
        assertEquals(WindowState.OPEN, testWindow.state);
    }

    private static class TestWindow implements Window {
        public WindowState state;

        //constructor
        public TestWindow(WindowState state) {
            this.state = state;
        }

        //function to close the window
        @Override
        public void close(){
            state = WindowState.CLOSED;
        }

        @Override
        public void open() {
            state = WindowState.OPEN;
        }
    }

    //class with specific values
    private enum WindowState {
        CLOSED, OPEN
    }
}
