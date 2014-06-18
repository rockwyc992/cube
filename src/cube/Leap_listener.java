package cube;

import java.lang.Math;
import com.leapmotion.leap.*;

class Leap_listener extends Listener {

    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
    }

    public void onDisconnect(Controller controller) {
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

    public void onFrame(Controller controller) {
        Frame frame = controller.frame();
        GestureList gestures = frame.gestures();
        int num = gestures.count();

        Gesture gesture = gestures.get(0);
        Gesture.Type type = gesture.type();

        if(type == Gesture.Type.TYPE_CIRCLE) {
            CircleGesture circle = new CircleGesture(gesture);

            if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/4) {
                Control.leap_control("F", num);
            } else {
                Control.leap_control("B", num);
            }
        } else if (type == Gesture.Type.TYPE_SWIPE) {
            SwipeGesture swipe = new SwipeGesture(gesture);
            Vector vector = swipe.direction();
            Vector    up = new Vector( 0.0f,  1.0f, 0.0f);
            Vector  down = new Vector( 0.0f, -1.0f, 0.0f);
            Vector  left = new Vector(-1.0f,  0.0f, 0.0f);
            Vector right = new Vector( 1.0f,  0.0f, 0.0f);

            if(vector.angleTo(up) < 0.5) {
                Control.leap_control("R", num);
            } else if(vector.angleTo(down) < 0.5) {
                Control.leap_control("L", num);
            } else if(vector.angleTo(left) < 0.5) {
                Control.leap_control("U", num);
            } else if(vector.angleTo(right) < 0.5) {
                Control.leap_control("D", num);
            }
        }
    }

}

