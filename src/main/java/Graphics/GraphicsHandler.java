package Graphics;

import Board.Board;
import Game.Game;
import Game.GameConfig;
import Game.GameState;
import Game.State;
import Input.InputHandler;

import java.awt.*;
import javax.swing.*;

public class GraphicsHandler extends JPanel{
    private static final int RECT_X = 20;
    private static final int RECT_Y = RECT_X;
    private static final int RECT_WIDTH = 500;
    private static final int RECT_HEIGHT = RECT_WIDTH;

    public Board board;

    public GraphicsHandler(Board board) {
        this.board = board;
        JFrame frame = new JFrame("JavaSnake");
        frame.addKeyListener(new InputHandler(board.getSnake()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setFocusable(true);

        frame.requestFocus();
        frame.requestFocusInWindow();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public void drawScore(Graphics g) {
        String scoreStr = String.format("Score %s", GameState.getScore());

        // Draw the string 70 pixels before the right side of the board
        // and 20 pixels below the first square (wall)
        g.drawString(scoreStr, ((GameConfig.boardWidth * GameConfig.squareSize) - 70),
                GameConfig.squareSize + 20);
    }

    public void drawPlayingGame(Graphics g) {
        int boardSquareDim = GameConfig.squareSize;

        // Loop through the board state array and draw coloured squares
        // in appropriate places for walls, snake and food
        for (int i =0; i<board.getWidth();i++) {
            for (int j=0; j<board.getHeight(); j++) {
                // Walls
                if (board.getBoardArray()[i][j] == 1) {
                    g.setColor(java.awt.Color.BLACK);
                    g.fillRect(i*boardSquareDim, j*boardSquareDim, boardSquareDim, boardSquareDim);
                }
                // Snake
                else if (board.getBoardArray()[i][j] == 2) {
                    g.setColor(java.awt.Color.BLUE);
                    g.fillRect(i*boardSquareDim, j*boardSquareDim, boardSquareDim, boardSquareDim);
                }
                // Food
                else if (board.getBoardArray()[i][j] == 4) {
                    g.setColor(Color.GREEN);
                    g.fillRect(i*boardSquareDim, j*boardSquareDim, boardSquareDim, boardSquareDim);
                }
            }
        }
    }

    public void drawMenu(Graphics g) {
        g.drawString("Press Space to start game!", 100, 100);
    }

    public void drawDeathMessage(Graphics g) {
        String msg = String.format("Dead! You scored %s.", GameState.getScore());
        g.drawString(msg, 100, 100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (GameState.getState() == State.PLAYING) {
            drawPlayingGame(g);
            drawScore(g);
        }
        else if (GameState.getState()  == State.DEAD) {
            drawPlayingGame(g);
            drawDeathMessage(g);
        }
        else if (GameState.getState()  == State.INTRO) {
            drawMenu(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(GameConfig.boardWidth * GameConfig.squareSize,
                GameConfig.boardHeight * GameConfig.squareSize);
    }


}