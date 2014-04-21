package cube;

class Colors extends Point {

    Colors(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    static Point Black() {
        Point color = new Point(0f, 0f, 0f);
        return color;
    }

    static Point White() {
        Point color = new Point(1f, 1f, 1f);
        return color;
    }

    static Point Red() {
        Point color = new Point(1f, 0f, 0f);
        return color;
    }

    static Point Blue() {
        Point color = new Point(0f, 0f, 1f);
        return color;
    }

    static Point Green() {
        Point color = new Point(0f, 1f, 0f);
        return color;
    }

    static Point Orange() {
        Point color = new Point(1f, 0.55f, 0f);
        return color;
    }
    
    static Point Gray() {
        Point color = new Point(0.5f, 0.5f, 0.5f);
        return color;
    }

    static Point Yellow() {
        Point color = new Point(1f, 1f, 0f);
        return color;
    }
}
