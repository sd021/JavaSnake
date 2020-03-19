package Board;

import Controllable.Snake;
import Game.GameState;
import Game.State;
import Utils.Point;
import Food.Food;

public class Board extends Snake {

    private final int width, height;
    private int[][] boardState; // 0 = empty, 1 = wall, 2 = snake, 3 = snakehead??, 4 = food
    private int maxSquares;
    private Snake snake;
    private Food food;

    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int SNAKE = 2;
    public static final int FOOD = 4;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.boardState = new int[width][height];
        this.snake = new Snake(width - 1, height - 1, width / 2, height / 2);
        this.food = new Food(width - 2, height - 2);

        maxSquares = width * height;
    }

    public Snake getSnake() {
        return snake;
    }

    public int[][] getBoardArray() {
        return this.boardState;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void generateBlankBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if ((i % (this.width - 1) == 0) || (j % (this.height - 1) == 0)) {
                    boardState[i][j] = WALL;
                } else {
                    boardState[i][j] = EMPTY;
                }
            }

        }
    }

    // Reset the board and snake after death
    public void resetBoard() {
        snake = new Snake(width - 1, height - 1, width / 2, height / 2);
        food = new Food(width - 2, height - 2);
    }
    private void updateSnake() {
        snake.updatePosition();
    }

    private void checkSnakeCollision() {
        for (int i=1; i<snake.getLength();i++) {
            if (snake.getPoints()[0].equals(snake.getPoints()[i])) {
                GameState.setState(State.DEAD);
            }
        }
    }

    private void checkFoodCollision() {
        if (snake.getPoints()[0].equals(food.getLocation())) {
            snake.addJoint();
            GameState.updateScore(1);
            food.genNewFood();
        }
    }

    private void addSnakeToBoard() {
        for (int i = 0; i < snake.getLength(); i++) {
            Point currentPoint = snake.getPoints()[i];
            if (currentPoint.getX() != 0 && currentPoint.getY() != 0) {
                boardState[currentPoint.getX()][currentPoint.getY()] = SNAKE;
            }
        }
    }

    private void addFoodToBoard() {
        boardState[food.getLocation().getX()][food.getLocation().getY()] = FOOD;
    }

    public void updateBoard() {
        generateBlankBoard();
        updateSnake();
        checkFoodCollision();
        checkSnakeCollision();
        addSnakeToBoard();
        addFoodToBoard();
    }


}
