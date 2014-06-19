package cube;

import java.util.*;

class AI {

    Rubiks cubes;
    Queue<Integer> step;

    AI(Rubiks cubes) {
        this.cubes = cubes;
        step = new LinkedList<Integer>();
    }

    void hack(Stack<Integer> stack) {
        int mode;
        while(!stack.isEmpty()) {
            mode = stack.pop();
            if(mode >= 25) {
                mode -= 25;
            } else {
                mode += 25;
            }
            step.add(mode);
        }
    }
    
    boolean solve() {
        if (!step.isEmpty()) {
            return true;
        }
        return false;
    }

    int next() {
        if (!step.isEmpty()) {
            return step.remove();
        }
        return 0;
    }

    boolean check_color(int no1, int forward1, int no2, int forward2) {
        Point color1 = cubes.cubes(no1).colors[forward1];
        Point color2 = cubes.cubes(no2).colors[forward2];
        return color1.x==color2.x && color1.y==color2.y && color1.z==color2.z;
    }

    boolean solve_Cross() {
        if (check_color(10, Global.Forward_Down, 3, Global.Forward_Back) &&
            check_color( 4, Global.Forward_Left, 3, Global.Forward_Left)) {
            step.add(Global.Mode_xL1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 5, Global.Forward_Front) &&
                   check_color( 4, Global.Forward_Left, 5, Global.Forward_Left)) {
            step.add(Global.Mode_L1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 7, Global.Forward_Up) &&
                   check_color( 4, Global.Forward_Left, 7, Global.Forward_Left)) {
            step.add(Global.Mode_L1);
            step.add(Global.Mode_L1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 9, Global.Forward_Down) &&
                   check_color( 4, Global.Forward_Left, 9, Global.Forward_Back)) {
            step.add(Global.Mode_xD1);
            step.add(Global.Mode_xD1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 19, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 19, Global.Forward_Down)) {
            step.add(Global.Mode_xD1);
            step.add(Global.Mode_F1);
            step.add(Global.Mode_L1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 9, Global.Forward_Down) &&
                   check_color( 4, Global.Forward_Left, 9, Global.Forward_Back)) {
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 9, Global.Forward_Back) &&
                   check_color( 4, Global.Forward_Left, 9, Global.Forward_Down)) {
            step.add(Global.Mode_xB1);
            step.add(Global.Mode_xL1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 3, Global.Forward_Left) &&
                   check_color( 4, Global.Forward_Left, 3, Global.Forward_Back)) {
            step.add(Global.Mode_xL1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 3, Global.Forward_Back) &&
                   check_color( 4, Global.Forward_Left, 3, Global.Forward_Left)) {
            step.add(Global.Mode_B1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 5, Global.Forward_Front) &&
                   check_color( 4, Global.Forward_Left, 5, Global.Forward_Left)) {
            step.add(Global.Mode_L1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 5, Global.Forward_Left) &&
                   check_color( 4, Global.Forward_Left, 5, Global.Forward_Front)) {
            step.add(Global.Mode_xF1);
            step.add(Global.Mode_xD1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 21, Global.Forward_Back) &&
                   check_color( 4, Global.Forward_Left, 21, Global.Forward_Right)) {
            step.add(Global.Mode_R1);
            step.add(Global.Mode_D1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 21, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 21, Global.Forward_Back)) {
            step.add(Global.Mode_xB1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Front) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Right)) {
            step.add(Global.Mode_xR1);
            step.add(Global.Mode_D1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        } else if (check_color(10, Global.Forward_Down, 23, Global.Forward_Right) &&
                   check_color( 4, Global.Forward_Left, 23, Global.Forward_Front)) {
            step.add(Global.Mode_F1);
            step.add(Global.Mode_D1);
            return true;
        }
        return false;
    }

    boolean solve_F2L() {
        return false;
    }

    boolean solve_OLL() {
        return false;
    }

    boolean solve_PLL() {
        return false;
    }

}
