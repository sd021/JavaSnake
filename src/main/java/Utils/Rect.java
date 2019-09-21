package Utils;

public class Rect {
    public int width, height;

    public Rect() {
        this.width = 0;
        this.height = 0;
    }

    public Rect(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getArea() {
        return this.width * this.height;
    }
}
