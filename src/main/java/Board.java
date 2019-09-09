public class Board extends Snake {

    private final int width, height;
    private int[][] board; // 0 = empty, 1 = wall, 2 = snake, 4 = food
    private Snake snake;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[this.width][this.height];
        this.snake = new Snake(this.width, this.height, this.width -2, this.height / 2);
    }

    public void genBlankBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if ((i == 0 || i == this.width - 1) || (j == 0 || j == this.height - 1)) {
                    board[i][j] = 1;     // Wall
                }
                else {
                    board[i][j] = 0;    // Empty
                }
            }

        }
    }

    public void updateSnake() {
        this.snake.updatePosition();
    }

    public void addSnakeToBoard() {
        for (int i = 0; i < 100; i++) {
            if (this.snake.x[i] != 0 && this.snake.y[i] != 0) {
                this.board[this.snake.x[i]][this.snake.y[i]] = 2;
            }
        }
    }

    public void drawBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.board[j][i] == 1) {
                    System.out.print("#");
                } else if (this.board[j][i] == 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    private Boolean checkSquare(int x, int y) {
        return true;
    }

    public void genSnake() {

    }
}
