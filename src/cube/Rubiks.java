package cube;

class Rubiks {

    Cube[][][] cubes;
    int[][][]  locate;

    Rubiks() {
        cubes = new Cube[3][3][3];
        locate = new int[3][3][3];
        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<3 ; j++) {
                for(int k=0 ; k<3 ; k++) {
                    cubes[i][j][k] = new Cube(i, j, k);
                    locate[i][j][k] = i*9 + j*3 + k;
                }
            }
        }
    }

    boolean win() {
        for(int i=0 ; i<6 ; i++) {
            if(!check_color_same(i)) {
                return false;
            }
        }
        return true;
    }

    boolean check_color_same(int forward) {
        Point color = cubes[0][0][0].colors[forward];
        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<3 ; j++) {
                for(int k=0 ; k<3 ; k++) {
                    if(color.x != cubes[i][j][k].colors[forward].x) {
                        return false;
                    }
                    if(color.y != cubes[i][j][k].colors[forward].y) {
                        return false;
                    }
                    if(color.z != cubes[i][j][k].colors[forward].z) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    Cube cubes(int x, int y, int z) {
        return cubes[x][y][z];
    }

    Cube cubes(int no) {
        int x = no/9;
        int y = no/3%3;
        int z = no%3;
        return cubes[x][y][z];
    }

    void show(int mode, float degree) {
        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<3 ; j++) {
                for(int k=0 ; k<3 ; k++) {
                    cubes[i][j][k].show(mode, degree);
                }
            }
        }
    }

    void change_four_color(Point a, Point b, Point c, Point d) {
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

    void change_color(int mode) {
        if (mode == Global.Mode_Null) {
            return;
        } else if(mode == Global.Mode_xNull) {
            return;
        } else if(mode == Global.Mode_F1) {
            change_color_F1();
        } else if(mode == Global.Mode_B1) {
            change_color_B1();
        } else if(mode == Global.Mode_U1) {
            change_color_U1();
        } else if(mode == Global.Mode_D1) {
            change_color_D1();
        } else if(mode == Global.Mode_L1) {
            change_color_L1();
        } else if(mode == Global.Mode_R1) {
            change_color_R1();
        } else if(mode == Global.Mode_f) {
            change_color_f();
        } else if(mode == Global.Mode_b) {
            change_color_b();
        } else if(mode == Global.Mode_u) {
            change_color_u();
        } else if(mode == Global.Mode_d) {
            change_color_d();
        } else if(mode == Global.Mode_l) {
            change_color_l();
        } else if(mode == Global.Mode_r) {
            change_color_r();
        } else if(mode == Global.Mode_F2) {
            change_color_F1();
            change_color_f();
        } else if(mode == Global.Mode_B2) {
            change_color_B1();
            change_color_b();
        } else if(mode == Global.Mode_U2) {
            change_color_U1();
            change_color_u();
        } else if(mode == Global.Mode_D2) {
            change_color_D1();
            change_color_d();
        } else if(mode == Global.Mode_L2) {
            change_color_L1();
            change_color_l();
        } else if(mode == Global.Mode_R2) {
            change_color_R1();
            change_color_r();
        } else if(mode == Global.Mode_F3) {
            change_color_F1();
            change_color_f();
            change_color_xB1();
        } else if(mode == Global.Mode_B3) {
            change_color_B1();
            change_color_b();
            change_color_xF1();
        } else if(mode == Global.Mode_U3) {
            change_color_U1();
            change_color_u();
            change_color_xD1();
        } else if(mode == Global.Mode_D3) {
            change_color_D1();
            change_color_d();
            change_color_xU1();
        } else if(mode == Global.Mode_L3) {
            change_color_L1();
            change_color_l();
            change_color_xR1();
        } else if(mode == Global.Mode_R3) {
            change_color_R1();
            change_color_r();
            change_color_xL1();
        } else if(mode == Global.Mode_xF1) {
            change_color_xF1();
        } else if(mode == Global.Mode_xB1) {
            change_color_xB1();
        } else if(mode == Global.Mode_xU1) {
            change_color_xU1();
        } else if(mode == Global.Mode_xD1) {
            change_color_xD1();
        } else if(mode == Global.Mode_xL1) {
            change_color_xL1();
        } else if(mode == Global.Mode_xR1) {
            change_color_xR1();
        } else if(mode == Global.Mode_xf) {
            change_color_b();
        } else if(mode == Global.Mode_xb) {
            change_color_f();
        } else if(mode == Global.Mode_xu) {
            change_color_d();
        } else if(mode == Global.Mode_xd) {
            change_color_u();
        } else if(mode == Global.Mode_xl) {
            change_color_r();
        } else if(mode == Global.Mode_xr) {
            change_color_l();
        } else if(mode == Global.Mode_xF2) {
            change_color_xF1();
            change_color_b();
        } else if(mode == Global.Mode_xB2) {
            change_color_xB1();
            change_color_f();
        } else if(mode == Global.Mode_xU2) {
            change_color_xU1();
            change_color_d();
        } else if(mode == Global.Mode_xD2) {
            change_color_xD1();
            change_color_u();
        } else if(mode == Global.Mode_xL2) {
            change_color_xL1();
            change_color_r();
        } else if(mode == Global.Mode_xR2) {
            change_color_xR1();
            change_color_l();
        } else if(mode == Global.Mode_xF3) {
            change_color_xF1();
            change_color_b();
            change_color_B1();
        } else if(mode == Global.Mode_xB3) {
            change_color_xB1();
            change_color_f();
            change_color_F1();
        } else if(mode == Global.Mode_xU3) {
            change_color_xU1();
            change_color_d();
            change_color_D1();
        } else if(mode == Global.Mode_xD3) {
            change_color_xD1();
            change_color_u();
            change_color_U1();
        } else if(mode == Global.Mode_xL3) {
            change_color_xL1();
            change_color_r();
            change_color_R1();
        } else if(mode == Global.Mode_xR3) {
            change_color_xR1();
            change_color_l();
            change_color_L1();
        }
    }

    void change_color_F1() {
        change_color_z(2);
    }

    void change_color_B1() {
        change_color_z(0);
        change_color_z(0);
        change_color_z(0);
    }

    void change_color_U1() {
        change_color_y(2);
    }

    void change_color_D1() {
        change_color_y(0);
        change_color_y(0);
        change_color_y(0);
    }

    void change_color_L1() {
        change_color_x(0);
    }

    void change_color_R1() {
        change_color_x(2);
        change_color_x(2);
        change_color_x(2);
    }

    void change_color_f() {
        change_color_z(1);
    }

    void change_color_b() {
        change_color_z(1);
        change_color_z(1);
        change_color_z(1);
    }

    void change_color_u() {
        change_color_y(1);
    }

    void change_color_d() {
        change_color_y(1);
        change_color_y(1);
        change_color_y(1);
    }

    void change_color_l() {
        change_color_x(1);
    }

    void change_color_r() {
        change_color_x(1);
        change_color_x(1);
        change_color_x(1);
    }

    void change_color_xF1() {
        change_color_z(2);
        change_color_z(2);
        change_color_z(2);
    }

    void change_color_xB1() {
        change_color_z(0);
    }

    void change_color_xU1() {
        change_color_y(2);
        change_color_y(2);
        change_color_y(2);
    }

    void change_color_xD1() {
        change_color_y(0);
    }

    void change_color_xL1() {
        change_color_x(0);
        change_color_x(0);
        change_color_x(0);
    }

    void change_color_xR1() {
        change_color_x(2);
    }

    void change_color_x(int x) {
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

    void change_color_y(int y) {
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

    void change_color_z(int z) {
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
}
