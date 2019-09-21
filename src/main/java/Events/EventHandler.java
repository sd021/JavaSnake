package Events;

import Game.GameConfig;
import Game.GameState;
import Game.State;
import Graphics.GraphicsHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener, Runnable {

    Timer timer=new Timer(1000 / GameConfig.gameSpeed, this);
    GraphicsHandler graphicsHandler;

    public EventHandler(GraphicsHandler graphicsHandler) {
        this.graphicsHandler = graphicsHandler;
        timer.start();
    }

    @Override
    public void run() {
        while (true) {
            graphicsHandler.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            if (GameState.getState() == State.PLAYING) {
                graphicsHandler.board.updateBoard();
            }
        }
    }
}
