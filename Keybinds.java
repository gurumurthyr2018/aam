import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModKeyBindings {
    private static boolean power1Pressed = false;
    private static boolean power2Pressed = false;
    private static boolean power3Pressed = false;
    private static boolean power4Pressed = false;
    private static boolean power5Pressed = false;
    private static boolean power6Pressed = false;
    private static boolean power7Pressed = false;
    private static boolean power8Pressed = false;
    private static boolean power9Pressed = false;
    private static boolean power10Pressed = false;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (power1Pressed) {
            // Power 1 is being pressed
        }
        if (power2Pressed) {
            // Power 2 is being pressed
        }
        if (power3Pressed) {
            // Power 3 is being pressed
        }
          if (power4Pressed) {
            // Power 4 is being pressed
        }
        if (power5Pressed) {
            // Power 5 is being pressed
        }
        if (power6Pressed) {
            // Power 6 is being pressed
        }
        if (power7Pressed) {
            // Power 7 is being pressed
        }
        if (power8Pressed) {
            // Power 8 is being pressed
        }
        if (power9Pressed) {
            // Power 9 is being pressed
        }
        if (power10Pressed) {
            // Power 10 is being pressed
        }
    }

    public static void setPower1Pressed(boolean pressed) {
        power1Pressed = pressed;
    }

    public static void setPower2Pressed(boolean pressed) {
        power2Pressed = pressed;
    }

    public static void setPower3Pressed(boolean pressed) {
        power3Pressed = pressed;
    }

    public static void setPower4Pressed(boolean pressed) {
        power4Pressed = pressed;
    }

    public static void setPower5Pressed(boolean pressed) {
        power5Pressed = pressed;
    }

    public static void setPower6Pressed(boolean pressed) {
        power6Pressed = pressed;
    }

    public static void setPower7Pressed(boolean pressed) {
        power7Pressed = pressed;
    }

    public static void setPower8Pressed(boolean pressed) {
        power8Pressed = pressed;
    }

    public static void setPower9Pressed(boolean pressed) {
        power9Pressed = pressed;
    }

    public static void setPower10Pressed(boolean pressed) {
        power10Pressed = pressed;
    }
}