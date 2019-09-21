package Input;

import Controllable.ControllableCharacter;
import Game.GameState;
import Game.State;
import Utils.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter{

    private final ControllableCharacter controllable;

    public InputHandler(ControllableCharacter controllable) {
        this.controllable = controllable;
    }

    public void playingInput(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            controllable.setDirection(Direction.LEFT);
        }

        if (key == KeyEvent.VK_RIGHT) {
            controllable.setDirection(Direction.RIGHT);
        }

        if (key == KeyEvent.VK_UP) {
            controllable.setDirection(Direction.UP);
        }

        if (key == KeyEvent.VK_DOWN) {
            controllable.setDirection(Direction.DOWN);
        }
    }

    public void menuInput(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            GameState.setState(State.PLAYING);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (GameState.getState() == State.PLAYING) {
            playingInput(e);
        }
        else if (GameState.getState() == State.INTRO) {
            menuInput(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // different stuff
    }
    @Override
    public void keyTyped(KeyEvent event) {
        // more stuff
    }
}
