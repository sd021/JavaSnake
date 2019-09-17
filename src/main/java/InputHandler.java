import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter{

    public void keyPressed(KeyEvent e, ControllableCharacter controllable) {

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
}
