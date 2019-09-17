public class Board extends Snake {

    private final int width, height;
    private int[][] board; // 0 = empty, 1 = wall, 2 = snake, 3 = snakehead??, 4 = food
    private Snake snake;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
        this.snake = new Snake(width, height, width / 2, height / 2);
    }

    public Snake getSnake() {
        return snake;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void generateBlankBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if ((i % (this.width - 1) == 0) || (j % (this.height - 1) == 0)) {
                    board[i][j] = 1;     // Wall
                }
                else {
                    board[i][j] = 0;    // Empty
                }
            }

        }
    }

    public void updateSnake() {
        snake.updatePosition();
    }

    public void addSnakeToBoard() {
        for (int i = 0; i < 100; i++) {
            if (snake.x[i] != 0 && snake.y[i] != 0) {
                board[snake.x[i]][snake.y[i]] = 2;
            }
        }
    }

    // TODO outsource this
    public void drawBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[j][i] == 1) {
                    System.out.print("#");  // Walls
                } else if (board[j][i] == 2) {
                    System.out.print("*");  // Snake
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

}
