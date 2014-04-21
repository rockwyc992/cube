package cube;

import java.util.*;

class AI {

    Cube[][][] cubes;
    Queue<Integer> step;

    AI(Cube[][][] cubes) {
        this.cubes = cubes;
        step = new PriorityQueue<Integer>();
    }

    boolean solve() {
        if (!step.isEmpty()) {
            return true;
        } else if (solve_bottom_ten()) {
            step.add(Global.Mode_F1);
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

    boolean solve_bottom_ten() {
        if(cubes[1][0][1].colors[Global.Forward_Down] != 
           cubes[0][0][1].colors[Global.Forward_Down]) {
            return true;
        } else if(cubes[1][0][1].colors[Global.Forward_Down] != 
           cubes[1][0][0].colors[Global.Forward_Down]) {
            return true;
        } else if(cubes[1][0][1].colors[Global.Forward_Down] != 
           cubes[2][0][1].colors[Global.Forward_Down]) {
            return true;
        } else if(cubes[1][0][1].colors[Global.Forward_Down] != 
           cubes[1][0][2].colors[Global.Forward_Down]) {
            return true;
        }
        return false;
    }
    
    boolean same() {
        Point[] t = new Point[6];
        for(int k=0 ; k<6 ; k++)
            t[k] = cubes[0][0][0].colors[k];

        for(int i=0 ; i<3 ; i++)
            for(int j=0 ; j<3 ; j++)
                for(int a=0 ; a<3 ; a++)
                    for(int k=0 ; k<6 ; k++)
                        if(i!=0 && j!=0 && a!=0)
                        {
                            if(t[k].x!=cubes[i][j][a].colors[k].x)
                                return false;
                            if(t[k].y!=cubes[i][j][a].colors[k].y)
                                return false;
                            if(t[k].z!=cubes[i][j][a].colors[k].z)
                                return false;
                        }
        return true;
    }

}
