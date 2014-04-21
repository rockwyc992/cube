package cube;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

import java.util.Random;

class Demo {

    Control input;
    Camera cam;
    AI ai;

    Cube[][][] cubes;

    Random rand = new Random();

    float degree;
    int mode;
    int step;
    boolean lock;
    boolean is_ai;

    Demo() {
        //        step = 60;
        step = 60;
        init_Display();
        init_cubes();
        init_ai();
        game_loop();
        clean_up();
    }

    public static void main(String[] args) {
        new Demo();
    }

    void game_loop() {
        while(!Display.isCloseRequested()) {
            if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
                break;
            }

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glLoadIdentity();

            cam.move(input.x, input.y, input.z);
            cam.rotate(input.rx, input.ry);
            cam.use_view();
            input.update_keys();

            if(Global.Is_Gamepad)
                if(input.button_Back_pressed())
                    break;

            if(lock) {
                if(Keyboard.isKeyDown(Keyboard.KEY_TAB))
                    degree += 30f;
                else
                    degree += 5f;
                if(degree > 0f) {
                    degree = 0f;
                    lock = false;
                    mode = 0;
                }
            } else if(is_ai){
                if(ai.solve()) {
                    lock_button(ai.next());
                } else {
                    is_ai = false;
                    System.out.println("AI do it!!!!");
                }
            } else if(step >= 0) {
                lock_button(rand.nextInt(50));
                step--;
            }else if(!Global.Is_Gamepad) {
                lock_button(Global.Mode_AI);
            } else if(input.button_L_pressed()) {
                lock_button(mode + 25);
            } else if (input.button_R_pressed()) {
                lock_button(mode);
            } else if (input.button_A_pressed()) {
                if(mode == Global.Mode_F1) {
                    mode = Global.Mode_f;
                } else if (mode == Global.Mode_f) {
                    mode = Global.Mode_F1;
                } else {
                    mode = Global.Mode_F1;
                }
            } else if (input.button_Y_pressed()) {
                if(mode == Global.Mode_B1) {
                    mode = Global.Mode_b;
                } else if (mode == Global.Mode_b) {
                    mode = Global.Mode_B1;
                } else {
                    mode = Global.Mode_B1;
                }
            } else if (input.pov_Up_pressed()) {
                if(mode == Global.Mode_U1) {
                    mode = Global.Mode_u;
                } else if (mode == Global.Mode_u) {
                    mode = Global.Mode_U1;
                } else {
                    mode = Global.Mode_U1;
                }
            } else if (input.pov_Down_pressed()) {
                if(mode == Global.Mode_D1) {
                    mode = Global.Mode_d;
                } else if (mode == Global.Mode_d) {
                    mode = Global.Mode_D1;
                } else {
                    mode = Global.Mode_D1;
                }
            } else if (input.pov_Left_pressed()) {
                if(mode == Global.Mode_L1) {
                    mode = Global.Mode_l;
                } else if (mode == Global.Mode_l) {
                    mode = Global.Mode_L1;
                } else {
                    mode = Global.Mode_L1;
                }
            } else if (input.pov_Right_pressed()) {
                if(mode == Global.Mode_R1) {
                    mode = Global.Mode_r;
                } else if (mode == Global.Mode_r) {
                    mode = Global.Mode_R1;
                } else {
                    mode = Global.Mode_R1;
                }
            }

            if(Global.Is_Gamepad)
                if (input.Up_Y_pressed()) {
                    lock_button(Global.Mode_U3);
                } else if (input.Down_A_pressed()) {
                    lock_button(Global.Mode_D3);
                } else if (input.Left_X_pressed()) {
                    lock_button(Global.Mode_L3);
                } else if (input.Right_B_pressed()) {
                    lock_button(Global.Mode_R3);
                } else if (input.button_LAsix_pressed()) {
                    lock_button(Global.Mode_F3);
                } else if (input.button_RAsix_pressed()) {
                    lock_button(Global.Mode_B3);
                } else if (input.button_Logo_pressed()) {
                    lock_button(Global.Mode_AI);
                }

            if(Global.Is_Gamepad)
                if(input.controller.getAxisValue(0) == 1.0)
                    cam.x = cam.y = cam.rx = cam.ry = cam.z = cam.rz = 0;

            for(int i=0 ; i<3 ; i++) {
                for(int j=0 ; j<3 ; j++) {
                    for(int k=0 ; k<3 ; k++) {
                        cubes[i][j][k].show(mode, degree);
                    }
                }
            }
            Display.update();

        }
    }

    void lock_button(int mode) {
        if(lock) {
            return;
        } else if(mode == Global.Mode_Null) {
            return;
        } else if(mode == Global.Mode_xNull) {
            return;
        } else if(mode == Global.Mode_AI) {
            is_ai = true;
            return;
        }
        lock = true;
        degree = -90f;
        Cube.change_color(cubes, mode);
        this.mode = mode;
    }

    void init_ai() {
        ai = new AI(cubes);
    }

    void init_Display() {
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.setFullscreen(true);
            Display.setVSyncEnabled(true);
            Display.setTitle("Cube");
            Display.create();
        } catch (LWJGLException ex) {
            ex.printStackTrace();
        }
        input = new Control();
        cam = new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
    }

    void init_cubes() {
        cubes = Cube.new_many();
    }

    void clean_up() {
        Display.destroy();
    }

}
