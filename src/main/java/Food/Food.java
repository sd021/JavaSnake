package Food;

import Utils.Point;

import java.util.Random;

public class Food {
    private Point location;
    private int maxX, maxY;

    private Random rand = new Random();


    public Food(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;

        genNewFood();
    }

    public void genNewFood() {
        location = new Point(rand.nextInt(maxX) + 1, rand.nextInt(maxY) + 1);
    }

    public Point getLocation() {
        return location;
    }
}
