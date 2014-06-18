package cube;

class Global {

    static int Forward_Front = 0;
    static int Forward_Back  = 1;
    static int Forward_Up    = 2;
    static int Forward_Down  = 3;
    static int Forward_Left  = 4;
    static int Forward_Right = 5;

    static int Cube_Side = 4;
    static boolean Is_Gamepad = false;
    static boolean Is_Demo = false;
    static boolean Is_Leap = true;
    
    static int Button_A = 0;
    static int Button_B = 1;
    static int Button_X = 2;
    static int Button_Y = 3;
    static int Button_L = 4;
    static int Button_R = 5;
    static int Button_Back = 6;
    static int Button_Logo = 7;
    static int Button_RAsix = 8;
    static int Button_LAsix = 9;
    
    static int Pov_Up    = 0;
    static int Pov_Down  = 1;
    static int Pov_Left  = 2;
    static int Pov_Right = 3;
    
    static int Mode_Null = 0;
    static int Mode_F1 = 1;
    static int Mode_B1 = 2;
    static int Mode_U1 = 3;
    static int Mode_D1 = 4;
    static int Mode_L1 = 5;
    static int Mode_R1 = 6;
    static int Mode_f  = 7;
    static int Mode_b  = 8;
    static int Mode_u  = 9;
    static int Mode_d  = 10;
    static int Mode_l  = 11;
    static int Mode_r  = 12;
    static int Mode_F2 = 13;
    static int Mode_B2 = 14;
    static int Mode_U2 = 15;
    static int Mode_D2 = 16;
    static int Mode_L2 = 17;
    static int Mode_R2 = 18;
    static int Mode_F3 = 19;
    static int Mode_B3 = 20;
    static int Mode_U3 = 21;
    static int Mode_D3 = 22;
    static int Mode_L3 = 23;
    static int Mode_R3 = 24;
    static int Mode_xNull = 25;
    static int Mode_xF1 = 26;
    static int Mode_xB1 = 27;
    static int Mode_xU1 = 28;
    static int Mode_xD1 = 29;
    static int Mode_xL1 = 30;
    static int Mode_xR1 = 31;
    static int Mode_xf  = 32;
    static int Mode_xb  = 33;
    static int Mode_xu  = 34;
    static int Mode_xd  = 35;
    static int Mode_xl  = 36;
    static int Mode_xr  = 37;
    static int Mode_xF2 = 38;
    static int Mode_xB2 = 39;
    static int Mode_xU2 = 40;
    static int Mode_xD2 = 41;
    static int Mode_xL2 = 42;
    static int Mode_xR2 = 43;
    static int Mode_xF3 = 44;
    static int Mode_xB3 = 45;
    static int Mode_xU3 = 46;
    static int Mode_xD3 = 47;
    static int Mode_xL3 = 48;
    static int Mode_xR3 = 49;
    static int Mode_AI = 50;

    static Point[] Color() {
        Point[] colors = new Point[6];

        colors[0] = Colors.Red();
        colors[1] = Colors.Gray();
        colors[2] = Colors.White();
        colors[3] = Colors.Yellow();
        colors[4] = Colors.Blue();
        colors[5] = Colors.Green();

        return colors;
    }
}

