package Input;

import Board.Board;
import Game.GameState;
import Game.State;
import Utils.Direction;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter{

    private final Board board;

    public InputHandler(Board board) {
        this.board = board;
    }

    public void playingInput(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                board.getSnake().setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                board.getSnake().setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                board.getSnake().setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                board.getSnake().setDirection(Direction.DOWN);
                break;
        }
    }

    public void menuInput(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            GameState.setState(State.PLAYING);
            GameState.resetScore();
            board.resetBoard();

        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (GameState.getState() == State.PLAYING) {
            playingInput(e);
        }
        else if ((GameState.getState() == State.INTRO) || (GameState.getState() == State.DEAD)) {
            menuInput(e);
        }
    }
}
