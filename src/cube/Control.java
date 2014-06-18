package cube;

import java.util.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

class Control {

    Controller controller;
    boolean lock;
    init_Leap init;
    Thread leap;
    static int leap_step;

    float x;
    float y;
    float z;
    float rx;
    float ry;
    float rz;
    float t;
    int mode;

    boolean[] button_events;
    boolean[] button_status;

    boolean[] pov_events;
    boolean[] pov_status;

    Control() {
        if(Global.Is_Gamepad) {
            init_Gamepad();
            button_events = new boolean[controller.getButtonCount()];
            button_status = new boolean[controller.getButtonCount()];
            pov_events = new boolean[4];
            pov_status = new boolean[4];
        }
        if(Global.Is_Leap) {
            init = new init_Leap();
            leap = new Thread(init);
            leap.start();
            leap_step = Global.Mode_Null;
        }
    }

    void update_keys() {
        move_and_rotate();

        if(Global.Is_Gamepad) {
            for(int i=0 ; i<controller.getButtonCount() ; i++) {
                button_events[i] = false;
                button_status[i] = controller.isButtonPressed(i);
            }
            for(int i=0 ; i<4 ; i++) {
                pov_events[i] = false;
                pov_status[i] = is_pov_down(i);
            }

            while (Controllers.next()) {
                if(Controllers.isEventButton()) {
                    int index = Controllers.getEventControlIndex();
                    button_events[index] = true;
                } else if (Controllers.isEventPovX()) {
                    int index = Controllers.getEventControlIndex();
                    if(index == 0) {
                        pov_events[Global.Pov_Left] = true;
                        pov_events[Global.Pov_Right] = true;
                    }
                } else if (Controllers.isEventPovY()) {
                    int index = Controllers.getEventControlIndex();
                    if(index == 0) {
                        pov_events[Global.Pov_Up] = true;
                        pov_events[Global.Pov_Down] = true;
                    }
                }
            }
        } 
    }

    void move_and_rotate() {
        x = y = z = rx = ry = rz = t = 0f;
        if(Keyboard.isKeyDown(Keyboard.KEY_W))
            z += 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_S))
            z -= 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_A))
            x += 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_D))
            x -= 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            y += 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            y -= 1f;

        if(Keyboard.isKeyDown(Keyboard.KEY_UP))
            rx -= 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
            rx += 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
            ry -= 1f;
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
            ry += 1f;

        if(Global.Is_Gamepad) {
        x  -= controller.getXAxisValue()  * 2;
        z  -= controller.getYAxisValue()  * 2;
        y  -= controller.getZAxisValue();
        ry += controller.getRXAxisValue() * 2;
        rx += controller.getRYAxisValue() * 2;
        y  += controller.getRZAxisValue();
        }
    }

    boolean is_pov_down (int i) {
        if(i == Global.Pov_Up) {
            return controller.getPovY() == -1f;
        } else if( i == Global.Pov_Down) {
            return controller.getPovY() == 1f;
        } else if( i == Global.Pov_Left) {
            return controller.getPovX() == -1f;
        } else if( i == Global.Pov_Right) {
            return controller.getPovX() == 1f;
        }
        return false;
    }

    boolean button_A_pressed() {
        return button_events[Global.Button_A] && button_status[Global.Button_A];
    }

    boolean button_B_pressed() {
        return button_events[Global.Button_B] && button_status[Global.Button_B];
    }

    boolean button_X_pressed() {
        return button_events[Global.Button_X] && button_status[Global.Button_X];
    }

    boolean button_Y_pressed() {
        return button_events[Global.Button_Y] && button_status[Global.Button_Y];
    }

    boolean button_L_pressed() {
        return button_events[Global.Button_L] && button_status[Global.Button_L];
    }

    boolean button_R_pressed() {
        return button_events[Global.Button_R] && button_status[Global.Button_R];
    }

    boolean button_LAsix_pressed() {
        return button_events[Global.Button_LAsix] && button_status[Global.Button_LAsix];
    }

    boolean button_RAsix_pressed() {
        return button_events[Global.Button_RAsix] && button_status[Global.Button_RAsix];
    }

    boolean button_Back_pressed() {
        return button_events[Global.Button_Back] && button_status[Global.Button_Back];
    }

    boolean button_Logo_pressed() {
        return button_events[Global.Button_Logo] && button_status[Global.Button_Logo];
    }

    boolean pov_Up_pressed() {
        return pov_events[Global.Pov_Up] && pov_status[Global.Pov_Up];
    }

    boolean pov_Down_pressed() {
        return pov_events[Global.Pov_Down] && pov_status[Global.Pov_Down];
    }

    boolean pov_Left_pressed() {
        return pov_events[Global.Pov_Left] && pov_status[Global.Pov_Left];
    }

    boolean pov_Right_pressed() {
        return pov_events[Global.Pov_Right] && pov_status[Global.Pov_Right];
    }

    boolean Up_Y_pressed() {
        if(pov_Up_pressed()) {
            return button_status[Global.Button_Y];
        } else if(button_Y_pressed()) {
            return pov_status[Global.Pov_Up];
        }
        return false;
    }

    boolean Down_A_pressed() {
        if(pov_Down_pressed()) {
            return button_status[Global.Button_A];
        } else if(button_A_pressed()) {
            return pov_status[Global.Pov_Down];
        }
        return false;
    }

    boolean Left_X_pressed() {
        if(pov_Left_pressed()) {
            return button_status[Global.Button_X];
        } else if(button_X_pressed()) {
            return pov_status[Global.Pov_Left];
        }
        return false;
    }

    boolean Right_B_pressed() {
        if(pov_Right_pressed()) {
            return button_status[Global.Button_B];
        } else if(button_B_pressed()) {
            return pov_status[Global.Pov_Right];
        }
        return false;
    }

    void init_Gamepad() {
        try {
            Controllers.create();
        } catch (LWJGLException ex) {
            ex.printStackTrace();
        }
        Controllers.poll();

        for(int i=0;i<Controllers.getControllerCount() ; i++) {
            controller = Controllers.getController(i);
            if(controller.getName().matches(".*Gamepad.*"))
            {
                System.out.println(controller.getName());
                break;
            }
        }
    }

    class init_Leap implements Runnable {

        public void run() {
            Leap_listener listener = new Leap_listener();
            com.leapmotion.leap.Controller controller = new com.leapmotion.leap.Controller();
            controller.addListener(listener);
            try {
            System.in.read();
            } catch (Exception e) {
            }
            controller.removeListener(listener);
        }
    }

    static void leap_control(String str, int num) {
        if(leap_step != Global.Mode_Null)
            return;
        if(str.matches("B")) {
            if(num == 1) {
                leap_step = Global.Mode_B1;
            } else if(num == 2) {
                leap_step = Global.Mode_b;
            } else if(num == 3) {
                leap_step = Global.Mode_xF1;
            }
        } else if(str.matches("F")) {
            if(num == 1) {
                leap_step = Global.Mode_F1;
            } else if(num == 2) {
                leap_step = Global.Mode_f;
            } else if(num == 3) {
                leap_step = Global.Mode_xB1;
            }
        } else if(str.matches("U")) {
            if(num == 1) {
                leap_step = Global.Mode_U1;
            } else if(num == 2) {
                leap_step = Global.Mode_u;
            } else if(num == 3) {
                leap_step = Global.Mode_xD1;
            }
        } else if(str.matches("D")) {
            if(num == 1) {
                leap_step = Global.Mode_D1;
            } else if(num == 2) {
                leap_step = Global.Mode_d;
            } else if(num == 3) {
                leap_step = Global.Mode_xU1;
            }
        } else if(str.matches("R")) {
            if(num == 1) {
                leap_step = Global.Mode_R1;
            } else if(num == 2) {
                leap_step = Global.Mode_r;
            } else if(num == 3) {
                leap_step = Global.Mode_xL1;
            }
        } else if(str.matches("L")) {
            if(num == 1) {
                leap_step = Global.Mode_L1;
            } else if(num == 2) {
                leap_step = Global.Mode_l;
            } else if(num == 3) {
                leap_step = Global.Mode_xR1;
            }
        }
    }
}
