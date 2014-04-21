package cube;

import static org.lwjgl.opengl.GL11.*;

class Cube{

    int no;
    int locate;
    int x;
    int y;
    int z;
    int forward;
    int side;
    Point[] colors;

    Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        no = hash(x, y, z);
        locate = no;
        side = Global.Cube_Side;
        forward = Global.Forward_Up;
        colors = Global.Color();
    }

    static Cube[][][] new_many() {
        Cube[][][] cubes = new Cube[3][3][3];
        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<3 ; j++) {
                for(int k=0 ; k<3 ; k++) {
                    cubes[i][j][k] = new Cube(i, j, k);
                }
            }
        }
        return cubes;
    }

    int hash(int x, int y, int z) {
        return x*9 + y*3 + z;
    }

    void show(int mode, float degree) {
        glPushMatrix(); {
            glTranslatef(0,0,-40); 

            if(Global.Is_Demo) {
                glRotatef(45f, 0f, 7f,0f);
                glRotatef(20f, 7f, 0f,7f);
            }

            rotate(mode, degree);
            where();

            glBegin(GL_QUADS); {
                draw();
            }
            glEnd();
        }
        glPopMatrix();
    }

    void rotate(int mode, float degree) {
        if (mode == Global.Mode_Null) {
            glRotatef(0f, 0f, 0f, 0f);
        } else if(mode == Global.Mode_xNull) {
            glRotatef(0f, 0f, 0f, 0f);
        } else if(mode == Global.Mode_F1) {
            F1(degree);
        } else if(mode == Global.Mode_B1) {
            B1(degree);
        } else if(mode == Global.Mode_U1) {
            U1(degree);
        } else if(mode == Global.Mode_D1) {
            D1(degree);
        } else if(mode == Global.Mode_L1) {
            L1(degree);
        } else if(mode == Global.Mode_R1) {
            R1(degree);
        } else if(mode == Global.Mode_f) {
            f(degree);
        } else if(mode == Global.Mode_b) {
            b(degree);
        } else if(mode == Global.Mode_u) {
            u(degree);
        } else if(mode == Global.Mode_d) {
            d(degree);
        } else if(mode == Global.Mode_l) {
            l(degree);
        } else if(mode == Global.Mode_r) {
            r(degree);
        } else if(mode == Global.Mode_F2) {
            F1(degree);
            f(degree);
        } else if(mode == Global.Mode_B2) {
            B1(degree);
            b(degree);
        } else if(mode == Global.Mode_U2) {
            U1(degree);
            u(degree);
        } else if(mode == Global.Mode_D2) {
            D1(degree);
            d(degree);
        } else if(mode == Global.Mode_L2) {
            L1(degree);
            l(degree);
        } else if(mode == Global.Mode_R2) {
            R1(degree);
            r(degree);
        } else if(mode == Global.Mode_F3) {
            F1(degree);
            f(degree);
            xB1(degree);
        } else if(mode == Global.Mode_B3) {
            B1(degree);
            b(degree);
            xF1(degree);
        } else if(mode == Global.Mode_U3) {
            U1(degree);
            u(degree);
            xD1(degree);
        } else if(mode == Global.Mode_D3) {
            D1(degree);
            d(degree);
            xU1(degree);
        } else if(mode == Global.Mode_L3) {
            L1(degree);
            l(degree);
            xR1(degree);
        } else if(mode == Global.Mode_R3) {
            R1(degree);
            r(degree);
            xL1(degree);
        } else if(mode == Global.Mode_xF1) {
            xF1(degree);
        } else if(mode == Global.Mode_xB1) {
            xB1(degree);
        } else if(mode == Global.Mode_xU1) {
            xU1(degree);
        } else if(mode == Global.Mode_xD1) {
            xD1(degree);
        } else if(mode == Global.Mode_xL1) {
            xL1(degree);
        } else if(mode == Global.Mode_xR1) {
            xR1(degree);
        } else if(mode == Global.Mode_xf) {
            b(degree);
        } else if(mode == Global.Mode_xb) {
            f(degree);
        } else if(mode == Global.Mode_xu) {
            d(degree);
        } else if(mode == Global.Mode_xd) {
            u(degree);
        } else if(mode == Global.Mode_xl) {
            r(degree);
        } else if(mode == Global.Mode_xr) {
            l(degree);
        } else if(mode == Global.Mode_xF2) {
            xF1(degree);
            b(degree);
        } else if(mode == Global.Mode_xB2) {
            xB1(degree);
            f(degree);
        } else if(mode == Global.Mode_xU2) {
            xU1(degree);
            d(degree);
        } else if(mode == Global.Mode_xD2) {
            xD1(degree);
            u(degree);
        } else if(mode == Global.Mode_xL2) {
            xL1(degree);
            r(degree);
        } else if(mode == Global.Mode_xR2) {
            xR1(degree);
            l(degree);
        } else if(mode == Global.Mode_xF3) {
            xF1(degree);
            b(degree);
            B1(degree);
        } else if(mode == Global.Mode_xB3) {
            xB1(degree);
            f(degree);
            F1(degree);
        } else if(mode == Global.Mode_xU3) {
            xU1(degree);
            u(degree);
            D1(degree);
        } else if(mode == Global.Mode_xD3) {
            xD1(degree);
            u(degree);
            U1(degree);
        } else if(mode == Global.Mode_xL3) {
            xL1(degree);
            r(degree);
            R1(degree);
        } else if(mode == Global.Mode_xR3) {
            xR1(degree);
            l(degree);
            L1(degree);
        }
    }

    void where() {
        float x = this.x*(side+1) - side*1.5f - 1f;
        float y = this.y*(side+1) - side*1.5f - 1f;
        float z = this.z*(side+1) - side*1.5f - 1f;
        glTranslatef(x, y, z);
    }

    void F1(float degree) {
        if(is_front()) {
            glRotatef(degree, 0f, 0f, -7f);
        }
    }

    void B1(float degree) {
        if(is_back()) {
            glRotatef(degree, 0f, 0f, 7f);
        }
    }

    void U1(float degree) {
        if(is_up()) {
            glRotatef(degree, 0f, -7f, 0f);
        }
    }

    void D1(float degree) {
        if(is_down()) {
            glRotatef(degree, 0f, 7f, 0f);
        }
    }

    void L1(float degree) {
        if(is_left()) {
            glRotatef(degree, 7f, 0f, 0f);
        }
    }

    void R1(float degree) {
        if(is_right()) {
            glRotatef(degree, -7f, 0f, 0f);
        }
    }

    void xF1(float degree) {
        if(is_front()) {
            glRotatef(degree, 0f, 0f, 7f);
        }
    }

    void xB1(float degree) {
        if(is_back()) {
            glRotatef(degree, 0f, 0f, -7f);
        }
    }

    void xU1(float degree) {
        if(is_up()) {
            glRotatef(degree, 0f, 7f, 0f);
        }
    }

    void xD1(float degree) {
        if(is_down()) {
            glRotatef(degree, 0f, -7f, 0f);
        }
    }

    void xL1(float degree) {
        if(is_left()) {
            glRotatef(degree, -7f, 0f, 0f);
        }
    }

    void xR1(float degree) {
        if(is_right()) {
            glRotatef(degree, 7f, 0f, 0f);
        }
    }

    void f(float degree) {
        if(is_mid_z()) {
            glRotatef(degree, 0f, 0f, -7f);
        }
    }

    void b(float degree) {
        if(is_mid_z()) {
            glRotatef(degree, 0f, 0f, 7f);
        }
    }

    void u(float degree) {
        if(is_mid_y()) {
            glRotatef(degree, 0f, -7f, 0f);
        }
    }

    void d(float degree) {
        if(is_mid_y()) {
            glRotatef(degree, 0f, 7f, 0f);
        }
    }

    void l(float degree) {
        if(is_mid_x()) {
            glRotatef(degree, 7f, 0f, 0f);
        }
    }

    void r(float degree) {
        if(is_mid_x()) {
            glRotatef(degree, -7f, 0f, 0f);
        }
    }

    void draw() {
        draw_front();
        draw_back();
        draw_up();
        draw_down();
        draw_left();
        draw_right();
    }

    void draw_front() {
        if(!is_front()) {
            return;
        }
        color(colors[0]);
        vertex(1);
        vertex(3);
        vertex(7);
        vertex(5);
    }

    void draw_back() {
        if(!is_back()) {
            return;
        }
        color(colors[1]);
        vertex(0);
        vertex(2);
        vertex(6);
        vertex(4);
    }

    void draw_up() {
        if(!is_up()) {
            return;
        }
        color(colors[2]);
        vertex(2);
        vertex(3);
        vertex(7);
        vertex(6);
    }

    void draw_down() {
        if(!is_down()) {
            return;
        }
        color(colors[3]);
        vertex(0);
        vertex(4);
        vertex(5);
        vertex(1);
    }

    void draw_left() {
        if(!is_left()) {
            return;
        }
        color(colors[4]);
        vertex(0);
        vertex(1);
        vertex(3);
        vertex(2);
    }

    void draw_right() {
        if(!is_right()) {
            return;
        }
        color(colors[5]);
        vertex(4);
        vertex(5);
        vertex(7);
        vertex(6);
    }

    boolean is_front() {
        return z == 2;
    }

    boolean is_back() {
        return z == 0;
    }

    boolean is_up() {
        return y == 2;
    }

    boolean is_down() {
        return y == 0;
    }

    boolean is_left() {
        return x == 0;
    }

    boolean is_right() {
        return x == 2;
    }

    boolean is_mid_x() {
        return x == 1;
    }

    boolean is_mid_y() {
        return y == 1;
    }

    boolean is_mid_z() {
        return z == 1;
    }

    static void change_four_color(Point a, Point b, Point c, Point d) {
        float t = a.x;
        a.x = b.x;
        b.x = c.x;
        c.x = d.x;
        d.x = t;

        t = a.y;
        a.y = b.y;
        b.y = c.y;
        c.y = d.y;
        d.y = t;

        t = a.z;
        a.z = b.z;
        b.z = c.z;
        c.z = d.z;
        d.z = t;
    }

    static void change_color(Cube[][][] cubes, int mode) {
        if (mode == Global.Mode_Null) {
            return;
        } else if(mode == Global.Mode_xNull) {
            return;
        } else if(mode == Global.Mode_F1) {
            change_color_F1(cubes);
        } else if(mode == Global.Mode_B1) {
            change_color_B1(cubes);
        } else if(mode == Global.Mode_U1) {
            change_color_U1(cubes);
        } else if(mode == Global.Mode_D1) {
            change_color_D1(cubes);
        } else if(mode == Global.Mode_L1) {
            change_color_L1(cubes);
        } else if(mode == Global.Mode_R1) {
            change_color_R1(cubes);
        } else if(mode == Global.Mode_f) {
            change_color_f(cubes);
        } else if(mode == Global.Mode_b) {
            change_color_b(cubes);
        } else if(mode == Global.Mode_u) {
            change_color_u(cubes);
        } else if(mode == Global.Mode_d) {
            change_color_d(cubes);
        } else if(mode == Global.Mode_l) {
            change_color_l(cubes);
        } else if(mode == Global.Mode_r) {
            change_color_r(cubes);
        } else if(mode == Global.Mode_F2) {
            change_color_F1(cubes);
            change_color_f(cubes);
        } else if(mode == Global.Mode_B2) {
            change_color_B1(cubes);
            change_color_b(cubes);
        } else if(mode == Global.Mode_U2) {
            change_color_U1(cubes);
            change_color_u(cubes);
        } else if(mode == Global.Mode_D2) {
            change_color_D1(cubes);
            change_color_d(cubes);
        } else if(mode == Global.Mode_L2) {
            change_color_L1(cubes);
            change_color_l(cubes);
        } else if(mode == Global.Mode_R2) {
            change_color_R1(cubes);
            change_color_r(cubes);
        } else if(mode == Global.Mode_F3) {
            change_color_F1(cubes);
            change_color_f(cubes);
            change_color_xB1(cubes);
        } else if(mode == Global.Mode_B3) {
            change_color_B1(cubes);
            change_color_b(cubes);
            change_color_xF1(cubes);
        } else if(mode == Global.Mode_U3) {
            change_color_U1(cubes);
            change_color_u(cubes);
            change_color_xD1(cubes);
        } else if(mode == Global.Mode_D3) {
            change_color_D1(cubes);
            change_color_d(cubes);
            change_color_xU1(cubes);
        } else if(mode == Global.Mode_L3) {
            change_color_L1(cubes);
            change_color_l(cubes);
            change_color_xR1(cubes);
        } else if(mode == Global.Mode_R3) {
            change_color_R1(cubes);
            change_color_r(cubes);
            change_color_xL1(cubes);
        } else if(mode == Global.Mode_xF1) {
            change_color_xF1(cubes);
        } else if(mode == Global.Mode_xB1) {
            change_color_xB1(cubes);
        } else if(mode == Global.Mode_xU1) {
            change_color_xU1(cubes);
        } else if(mode == Global.Mode_xD1) {
            change_color_xD1(cubes);
        } else if(mode == Global.Mode_xL1) {
            change_color_xL1(cubes);
        } else if(mode == Global.Mode_xR1) {
            change_color_xR1(cubes);
        } else if(mode == Global.Mode_xf) {
            change_color_b(cubes);
        } else if(mode == Global.Mode_xb) {
            change_color_f(cubes);
        } else if(mode == Global.Mode_xu) {
            change_color_d(cubes);
        } else if(mode == Global.Mode_xd) {
            change_color_u(cubes);
        } else if(mode == Global.Mode_xl) {
            change_color_r(cubes);
        } else if(mode == Global.Mode_xr) {
            change_color_l(cubes);
        } else if(mode == Global.Mode_xF2) {
            change_color_xF1(cubes);
            change_color_b(cubes);
        } else if(mode == Global.Mode_xB2) {
            change_color_xB1(cubes);
            change_color_f(cubes);
        } else if(mode == Global.Mode_xU2) {
            change_color_xU1(cubes);
            change_color_d(cubes);
        } else if(mode == Global.Mode_xD2) {
            change_color_xD1(cubes);
            change_color_u(cubes);
        } else if(mode == Global.Mode_xL2) {
            change_color_xL1(cubes);
            change_color_r(cubes);
        } else if(mode == Global.Mode_xR2) {
            change_color_xR1(cubes);
            change_color_l(cubes);
        } else if(mode == Global.Mode_xF3) {
            change_color_xF1(cubes);
            change_color_b(cubes);
            change_color_B1(cubes);
        } else if(mode == Global.Mode_xB3) {
            change_color_xB1(cubes);
            change_color_f(cubes);
            change_color_F1(cubes);
        } else if(mode == Global.Mode_xU3) {
            change_color_xU1(cubes);
            change_color_d(cubes);
            change_color_D1(cubes);
        } else if(mode == Global.Mode_xD3) {
            change_color_xD1(cubes);
            change_color_u(cubes);
            change_color_U1(cubes);
        } else if(mode == Global.Mode_xL3) {
            change_color_xL1(cubes);
            change_color_r(cubes);
            change_color_R1(cubes);
        } else if(mode == Global.Mode_xR3) {
            change_color_xR1(cubes);
            change_color_l(cubes);
            change_color_L1(cubes);
        }
    }

    static void change_color_F1(Cube[][][] cubes) {
        change_color_z(cubes, 2);
    }

    static void change_color_B1(Cube[][][] cubes) {
        change_color_z(cubes, 0);
        change_color_z(cubes, 0);
        change_color_z(cubes, 0);
    }

    static void change_color_U1(Cube[][][] cubes) {
        change_color_y(cubes, 2);
    }

    static void change_color_D1(Cube[][][] cubes) {
        change_color_y(cubes, 0);
        change_color_y(cubes, 0);
        change_color_y(cubes, 0);
    }

    static void change_color_L1(Cube[][][] cubes) {
        change_color_x(cubes, 0);
    }

    static void change_color_R1(Cube[][][] cubes) {
        change_color_x(cubes, 2);
        change_color_x(cubes, 2);
        change_color_x(cubes, 2);
    }

    static void change_color_f(Cube[][][] cubes) {
        change_color_z(cubes, 1);
    }

    static void change_color_b(Cube[][][] cubes) {
        change_color_z(cubes, 1);
        change_color_z(cubes, 1);
        change_color_z(cubes, 1);
    }

    static void change_color_u(Cube[][][] cubes) {
        change_color_y(cubes, 1);
    }

    static void change_color_d(Cube[][][] cubes) {
        change_color_y(cubes, 1);
        change_color_y(cubes, 1);
        change_color_y(cubes, 1);
    }

    static void change_color_l(Cube[][][] cubes) {
        change_color_x(cubes, 1);
    }

    static void change_color_r(Cube[][][] cubes) {
        change_color_x(cubes, 1);
        change_color_x(cubes, 1);
        change_color_x(cubes, 1);
    }

    static void change_color_xF1(Cube[][][] cubes) {
        change_color_z(cubes, 2);
        change_color_z(cubes, 2);
        change_color_z(cubes, 2);
    }

    static void change_color_xB1(Cube[][][] cubes) {
        change_color_z(cubes, 0);
    }

    static void change_color_xU1(Cube[][][] cubes) {
        change_color_y(cubes, 2);
        change_color_y(cubes, 2);
        change_color_y(cubes, 2);
    }

    static void change_color_xD1(Cube[][][] cubes) {
        change_color_y(cubes, 0);
    }

    static void change_color_xL1(Cube[][][] cubes) {
        change_color_x(cubes, 0);
        change_color_x(cubes, 0);
        change_color_x(cubes, 0);
    }

    static void change_color_xR1(Cube[][][] cubes) {
        change_color_x(cubes, 2);
    }

    static void change_color_x(Cube[][][] cubes, int x) {
        change_four_color(cubes[x][0][0].colors[Global.Forward_Front],
                cubes[x][0][2].colors[Global.Forward_Up],
                cubes[x][2][2].colors[Global.Forward_Back],
                cubes[x][2][0].colors[Global.Forward_Down]);
        change_four_color(cubes[x][0][0].colors[Global.Forward_Back],
                cubes[x][0][2].colors[Global.Forward_Down],
                cubes[x][2][2].colors[Global.Forward_Front],
                cubes[x][2][0].colors[Global.Forward_Up]);
        change_four_color(cubes[x][0][0].colors[Global.Forward_Up],
                cubes[x][0][2].colors[Global.Forward_Back],
                cubes[x][2][2].colors[Global.Forward_Down],
                cubes[x][2][0].colors[Global.Forward_Front]);
        change_four_color(cubes[x][0][0].colors[Global.Forward_Down],
                cubes[x][0][2].colors[Global.Forward_Front],
                cubes[x][2][2].colors[Global.Forward_Up],
                cubes[x][2][0].colors[Global.Forward_Back]);
        change_four_color(cubes[x][0][0].colors[Global.Forward_Left],
                cubes[x][0][2].colors[Global.Forward_Left],
                cubes[x][2][2].colors[Global.Forward_Left],
                cubes[x][2][0].colors[Global.Forward_Left]);
        change_four_color(cubes[x][0][0].colors[Global.Forward_Right],
                cubes[x][0][2].colors[Global.Forward_Right],
                cubes[x][2][2].colors[Global.Forward_Right],
                cubes[x][2][0].colors[Global.Forward_Right]);

        change_four_color(cubes[x][0][1].colors[Global.Forward_Front],
                cubes[x][1][2].colors[Global.Forward_Up],
                cubes[x][2][1].colors[Global.Forward_Back],
                cubes[x][1][0].colors[Global.Forward_Down]);
        change_four_color(cubes[x][0][1].colors[Global.Forward_Back],
                cubes[x][1][2].colors[Global.Forward_Down],
                cubes[x][2][1].colors[Global.Forward_Front],
                cubes[x][1][0].colors[Global.Forward_Up]);
        change_four_color(cubes[x][0][1].colors[Global.Forward_Up],
                cubes[x][1][2].colors[Global.Forward_Back],
                cubes[x][2][1].colors[Global.Forward_Down],
                cubes[x][1][0].colors[Global.Forward_Front]);
        change_four_color(cubes[x][0][1].colors[Global.Forward_Down],
                cubes[x][1][2].colors[Global.Forward_Front],
                cubes[x][2][1].colors[Global.Forward_Up],
                cubes[x][1][0].colors[Global.Forward_Back]);
        change_four_color(cubes[x][0][1].colors[Global.Forward_Left],
                cubes[x][1][2].colors[Global.Forward_Left],
                cubes[x][2][1].colors[Global.Forward_Left],
                cubes[x][1][0].colors[Global.Forward_Left]);
        change_four_color(cubes[x][0][1].colors[Global.Forward_Right],
                cubes[x][1][2].colors[Global.Forward_Right],
                cubes[x][2][1].colors[Global.Forward_Right],
                cubes[x][1][0].colors[Global.Forward_Right]);

        change_four_color(cubes[x][1][1].colors[Global.Forward_Front],
                cubes[x][1][1].colors[Global.Forward_Up],
                cubes[x][1][1].colors[Global.Forward_Back],
                cubes[x][1][1].colors[Global.Forward_Down]);
    }

    static void change_color_y(Cube[][][] cubes, int y) {
        change_four_color(cubes[0][y][0].colors[Global.Forward_Front],
                          cubes[0][y][2].colors[Global.Forward_Right],
                          cubes[2][y][2].colors[Global.Forward_Back],
                          cubes[2][y][0].colors[Global.Forward_Left]);
        change_four_color(cubes[0][y][0].colors[Global.Forward_Back],
                          cubes[0][y][2].colors[Global.Forward_Left],
                          cubes[2][y][2].colors[Global.Forward_Front],
                          cubes[2][y][0].colors[Global.Forward_Right]);
        change_four_color(cubes[0][y][0].colors[Global.Forward_Up],
                          cubes[0][y][2].colors[Global.Forward_Up],
                          cubes[2][y][2].colors[Global.Forward_Up],
                          cubes[2][y][0].colors[Global.Forward_Up]);
        change_four_color(cubes[0][y][0].colors[Global.Forward_Down],
                          cubes[0][y][2].colors[Global.Forward_Down],
                          cubes[2][y][2].colors[Global.Forward_Down],
                          cubes[2][y][0].colors[Global.Forward_Down]);
        change_four_color(cubes[0][y][0].colors[Global.Forward_Left],
                          cubes[0][y][2].colors[Global.Forward_Front],
                          cubes[2][y][2].colors[Global.Forward_Right],
                          cubes[2][y][0].colors[Global.Forward_Back]);
        change_four_color(cubes[0][y][0].colors[Global.Forward_Right],
                          cubes[0][y][2].colors[Global.Forward_Back],
                          cubes[2][y][2].colors[Global.Forward_Left],
                          cubes[2][y][0].colors[Global.Forward_Front]);
        
        change_four_color(cubes[0][y][1].colors[Global.Forward_Front],
                          cubes[1][y][2].colors[Global.Forward_Right],
                          cubes[2][y][1].colors[Global.Forward_Back],
                          cubes[1][y][0].colors[Global.Forward_Left]);
        change_four_color(cubes[0][y][1].colors[Global.Forward_Back],
                          cubes[1][y][2].colors[Global.Forward_Left],
                          cubes[2][y][1].colors[Global.Forward_Front],
                          cubes[1][y][0].colors[Global.Forward_Right]);
        change_four_color(cubes[0][y][1].colors[Global.Forward_Up],
                          cubes[1][y][2].colors[Global.Forward_Up],
                          cubes[2][y][1].colors[Global.Forward_Up],
                          cubes[1][y][0].colors[Global.Forward_Up]);
        change_four_color(cubes[0][y][1].colors[Global.Forward_Down],
                          cubes[1][y][2].colors[Global.Forward_Down],
                          cubes[2][y][1].colors[Global.Forward_Down],
                          cubes[1][y][0].colors[Global.Forward_Down]);
        change_four_color(cubes[0][y][1].colors[Global.Forward_Left],
                          cubes[1][y][2].colors[Global.Forward_Front],
                          cubes[2][y][1].colors[Global.Forward_Right],
                          cubes[1][y][0].colors[Global.Forward_Back]);
        change_four_color(cubes[0][y][1].colors[Global.Forward_Right],
                          cubes[1][y][2].colors[Global.Forward_Back],
                          cubes[2][y][1].colors[Global.Forward_Left],
                          cubes[1][y][0].colors[Global.Forward_Front]);

        change_four_color(cubes[1][y][1].colors[Global.Forward_Front],
                          cubes[1][y][1].colors[Global.Forward_Right],
                          cubes[1][y][1].colors[Global.Forward_Back],
                          cubes[1][y][1].colors[Global.Forward_Left]);
    }

    static void change_color_z(Cube[][][] cubes, int z) {
        change_four_color(cubes[0][0][z].colors[Global.Forward_Front],
                          cubes[2][0][z].colors[Global.Forward_Front],
                          cubes[2][2][z].colors[Global.Forward_Front],
                          cubes[0][2][z].colors[Global.Forward_Front]);
        change_four_color(cubes[0][0][z].colors[Global.Forward_Back],
                          cubes[2][0][z].colors[Global.Forward_Back],
                          cubes[2][2][z].colors[Global.Forward_Back],
                          cubes[0][2][z].colors[Global.Forward_Back]);
        change_four_color(cubes[0][0][z].colors[Global.Forward_Up],
                          cubes[2][0][z].colors[Global.Forward_Left],
                          cubes[2][2][z].colors[Global.Forward_Down],
                          cubes[0][2][z].colors[Global.Forward_Right]);
        change_four_color(cubes[0][0][z].colors[Global.Forward_Down],
                          cubes[2][0][z].colors[Global.Forward_Right],
                          cubes[2][2][z].colors[Global.Forward_Up],
                          cubes[0][2][z].colors[Global.Forward_Left]);
        change_four_color(cubes[0][0][z].colors[Global.Forward_Left],
                          cubes[2][0][z].colors[Global.Forward_Down],
                          cubes[2][2][z].colors[Global.Forward_Right],
                          cubes[0][2][z].colors[Global.Forward_Up]);
        change_four_color(cubes[0][0][z].colors[Global.Forward_Right],
                          cubes[2][0][z].colors[Global.Forward_Up],
                          cubes[2][2][z].colors[Global.Forward_Left],
                          cubes[0][2][z].colors[Global.Forward_Down]);

        change_four_color(cubes[1][0][z].colors[Global.Forward_Front],
                          cubes[2][1][z].colors[Global.Forward_Front],
                          cubes[1][2][z].colors[Global.Forward_Front],
                          cubes[0][1][z].colors[Global.Forward_Front]);
        change_four_color(cubes[1][0][z].colors[Global.Forward_Back],
                          cubes[2][1][z].colors[Global.Forward_Back],
                          cubes[1][2][z].colors[Global.Forward_Back],
                          cubes[0][1][z].colors[Global.Forward_Back]);
        change_four_color(cubes[1][0][z].colors[Global.Forward_Up],
                          cubes[2][1][z].colors[Global.Forward_Left],
                          cubes[1][2][z].colors[Global.Forward_Down],
                          cubes[0][1][z].colors[Global.Forward_Right]);
        change_four_color(cubes[1][0][z].colors[Global.Forward_Down],
                          cubes[2][1][z].colors[Global.Forward_Right],
                          cubes[1][2][z].colors[Global.Forward_Up],
                          cubes[0][1][z].colors[Global.Forward_Left]);
        change_four_color(cubes[1][0][z].colors[Global.Forward_Left],
                          cubes[2][1][z].colors[Global.Forward_Down],
                          cubes[1][2][z].colors[Global.Forward_Right],
                          cubes[0][1][z].colors[Global.Forward_Up]);
        change_four_color(cubes[1][0][z].colors[Global.Forward_Right],
                          cubes[2][1][z].colors[Global.Forward_Up],
                          cubes[1][2][z].colors[Global.Forward_Left],
                          cubes[0][1][z].colors[Global.Forward_Down]);
        
        change_four_color(cubes[1][1][z].colors[Global.Forward_Up],
                          cubes[1][1][z].colors[Global.Forward_Left],
                          cubes[1][1][z].colors[Global.Forward_Down],
                          cubes[1][1][z].colors[Global.Forward_Right]);
    }

    void color(Point color) {
        glColor3f(color.x, color.y, color.z);
    }

    void vertex(int no) {
        glVertex3f(no/4 * side, no/2%2*side,no%2*side);
    }
}

