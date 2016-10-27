import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class GlobalMouseWheelListenerExample implements NativeMouseWheelListener {
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        System.out.println("Mosue Wheel Moved: " + e.getWheelRotation());
    }

    public static void main(String[] args) {
    	  Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
          logger.setLevel(Level.OFF);

          // Don't forget to disable the parent handlers.
          logger.setUseParentHandlers(false);
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            ex.printStackTrace();

            System.exit(1);
        }

        GlobalScreen.addNativeMouseWheelListener(new GlobalMouseWheelListenerExample());
    }
}