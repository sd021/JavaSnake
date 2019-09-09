public class Snake {
    public int[] x;
    public int[] y;
    private int maxX , maxY;
    public int length = 3;

    public Direction direction = Direction.RIGHT;

    public Snake() {

    }

    public Snake(int maxX, int maxY, int initialX, int initialY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.x = new int[maxX*maxY];
        this.y = new int[maxX*maxY];

        this.x[0] = initialX;
        this.y[0] = initialY;

        for (int i=1;i<this.length;i++) {
            this.x[i] = initialX - i;
            this.y[i] = initialY;
        }
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public void updatePosition() {
        System.out.println(this.direction);
        System.out.println(this.x[0]);

        for (int i=this.length-1;i>0;i--) {
            this.x[i] = this.x[i-1] ;
            this.y[i] = this.y[i-1] ;
        }

        switch (this.direction) {
            case RIGHT:
                this.x[0] += 1;
                break;
            case LEFT:
                this.x[0] -= 1;
                break;
            case UP:
                this.y[0] += 1;
                break;
            case DOWN:
                this.y[0] -= 1;
                break;
        }

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
        System.out.println(this.x[0]);

    }
}
