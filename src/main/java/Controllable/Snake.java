package Controllable;

import Controllable.ControllableCharacter;
import Utils.Direction;
import Utils.Point;

import static Utils.Direction.*;

public class Snake implements ControllableCharacter {
    public int length = 3;
    public Direction direction;
    private Point[] points;
    private int maxX, maxY;

    public Snake() {
    }

    public Snake(int maxX, int maxY) {
        this(maxX, maxY, maxX / 2, maxY / 2);
    }

    // TODO Initial facing direction
    public Snake(int maxX, int maxY, int initialX, int initialY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.points = new Point[maxX * maxY];

        for (int i = 0; i < this.length; i++) {
            points[i] = new Point(initialX - i, initialY);
        }

        setDirection(RIGHT);
    }

    public Point[] getPoints(){
        return points;
    }

    public int getLength() {
        return length;
    }

    public void addJoint() {
        length += 1;
        points[length - 1] = new Point();
    }

    @Override
    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    // Set each joint's position equal to the one in front of it, excluding the head
    private void updateJointsPosition() {
        for (int i = this.length - 1; i > 0; i--) {
            points[i].setPoint(points[i - 1]);
        }
    }

    // Decide where the head is going
    private void updateHeadPosition() {
        switch (direction) {
            case RIGHT:
                points[0].addX(1);
                break;
            case LEFT:
                points[0].addX(-1);
                break;
            case UP:
                points[0].addY(-1);
                break;
            case DOWN:
                points[0].addY(1);
                break;
        }
    }

    // Check if any joint has gone through a wall
    // If it has put it on the opposite side of the board
    private void handleWallInteractions() {
        for (int i = this.length - 1; i >= 0; i--) {
            if (points[i].getX() >= maxX ) {
                points[i].setX(1);
            } else if (points[i].getX() < 1) {
                points[i].setX(this.maxX - 1);
            }

            if (points[i].getY() >= this.maxY ) {
                points[i].setY(1);
                System.out.println(points[0].getY());
                System.out.println(this.maxY);
            } else if (points[i].getY() < 1) {
                points[i].setY(this.maxY - 1); // TODO WHy?

            }
        }
    }

    public void updatePosition() {
        updateJointsPosition();
        updateHeadPosition();
        handleWallInteractions();
    }
}
