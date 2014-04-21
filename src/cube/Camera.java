package cube;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

class Camera {
    float x;
    float y;
    float z;
    float rx;
    float ry;
    float rz;

    float fov;
    float aspect;
    float near;
    float far;

    Camera(float fov, float aspect, float near, float far) {
        x = 0f;
        y = 0f;
        z = 0f;
        rx = 0f;
        ry = 0f;
        rz = 0f;

        this.fov = fov;
        this.aspect = aspect;
        this.near = near;
        this.far = far;
        init_projection();
    }

    void init_projection() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(fov,aspect,near,far);
        glMatrixMode(GL_MODELVIEW);

        glEnable(GL_DEPTH_TEST);
    }

    void use_view() {
        glRotatef(rx,1,0,0);
        glRotatef(ry,0,1,0);
        glRotatef(rz,0,0,1);
        glTranslatef(x,y,z);
    }

    float x() {
        return x;
    }

    float y() {
        return y;
    }

    float z() {
        return z;
    }

    void set_x(float x) {
        this.x = x;
    }

    void set_y(float y) {
        this.y = y;
    }

    void set_z(float z) {
        this.z = z;
    }

    float rx() {
        return rx;
    }

    float ry() {
        return ry;
    }

    float rz() {
        return rz;
    }

    void set_rx(float rx) {
        if(rx > 80f)
            this.rx = 80f;
        else if(rx < -80f)
            this.rx = -80f;
        else
            this.rx = rx;
    }

    void set_ry(float ry) {
        this.ry = ry;
    }

    void set_rz(float rz) {
        this.rz = rz;
    }

    void move(float dx, float dy, float dz) {
        x += dx * Math.cos(Math.toRadians(ry));
        z += dx * Math.sin(Math.toRadians(ry));
        y += dy * -1.0f;
        x += dz * Math.cos(Math.toRadians(ry + 90));
        z += dz * Math.sin(Math.toRadians(ry + 90));
    }

    void rotate(float rx, float ry) {
        set_rx(this.rx + rx);
        set_ry(this.ry + ry);
    }

}
