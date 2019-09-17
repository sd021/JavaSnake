
public class Snake implements ControllableCharacter {
    public int[] x;
    public int[] y;
    private int maxX , maxY;
    public int length = 3;

    public Direction direction;

    public Snake() {
    }

    public Snake(int maxX, int maxY) {
        this(maxX, maxY, maxX / 2, maxY / 2);
    }

    // TODO Initial facing direction
    public Snake(int maxX, int maxY, int initialX, int initialY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.x = new int[maxX*maxY];
        this.y = new int[maxX*maxY];

        this.x[0] = initialX;
        this.y[0] = initialY;

        for (int i=1;i<this.length;i++) {
            this.x[i] = this.x[0]- i;
            this.y[i] = this.y[0];
        }

        setDirection(Direction.RIGHT);
    }

    @Override
    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    // Set each joint's position equal to the one in front of it, excluding the head
    private void updateJointsPosition() {
        for (int i=this.length-1;i>0;i--) {
            this.x[i] = this.x[i-1] ;
            this.y[i] = this.y[i-1] ;
        }
    }

    // Decide where the head is going
    private void updateHeadPosition() {
        switch (this.direction) {
            case RIGHT:
                this.x[0] += 1;
                break;
            case LEFT:
                this.x[0] -= 1;
                break;
            case UP:
                this.y[0] -= 1;
                break;
            case DOWN:
                this.y[0] += 1;
                break;
        }
    }

    // Check if any joint has gone through a wall
    // If it has put it on the opposite side of the board
    private void handleWallInteractions(){
        for (int i=this.length-1;i>=0;i--) {
            if (this.x[i] >= this.maxX-1) {
                this.x[i] = 1;
            } else if (this.x[i] < 1) {
                this.x[i] = this.maxX - 1;
            }

            if (this.y[i] >= this.maxY-1) {
                this.y[i] = 1;
            } else if (this.y[i] < 1) {
                this.y[i] = this.maxY - 1;
            }
        }
    }

    public void updatePosition() {
        updateJointsPosition();
        updateHeadPosition();
        handleWallInteractions();
    }
}
