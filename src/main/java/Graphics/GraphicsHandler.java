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
    public Board board;

    public GraphicsHandler(Board board) {
        this.board = board;
        JFrame frame = new JFrame("JavaSnake");
        frame.addKeyListener(new InputHandler(board));
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
                switch (board.getBoardArray()[i][j]) {
                    case Board.WALL:
                        g.setColor(Color.BLACK);
                        break;
                    case Board.SNAKE:
                        g.setColor(Color.BLUE);
                        break;
                    case Board.FOOD:
                        g.setColor(Color.GREEN);
                        break;
                    case Board.EMPTY:
                        g.setColor(Color.WHITE);
                        break;
                }
                g.fillRect(i*boardSquareDim, j*boardSquareDim, boardSquareDim, boardSquareDim);
            }
        }
    }

    public void drawMenu(Graphics g) {
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 35));
        g.drawString("Press Space to start game!",(GameConfig.boardWidth * GameConfig.squareSize) / 5,
                (GameConfig.boardWidth  * GameConfig.squareSize) / 2);
    }

    public void drawDeathMessage(Graphics g) {
        g.setFont(new Font("Bauhaus 93", Font.PLAIN, 35));
        String msg = String.format("Dead! You scored %s.", GameState.getScore());
        g.drawString(msg, (GameConfig.boardWidth * GameConfig.squareSize) / 5,
                (GameConfig.boardWidth  * GameConfig.squareSize) / 2);

        msg = "Press Space to restart!";
        g.drawString(msg, (GameConfig.boardWidth * GameConfig.squareSize) / 5,
                ((GameConfig.boardWidth  * GameConfig.squareSize) / 2) + 35 );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (GameState.getState()) {
            case INTRO:
                drawMenu(g);
                break;
            case PLAYING:
                drawPlayingGame(g);
                drawScore(g);
                break;
            case DEAD:
                drawPlayingGame(g);
                drawDeathMessage(g);
                break;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // This will be the initial size of the window, we set it to the dimensions of the game
        return new Dimension(GameConfig.boardWidth * GameConfig.squareSize,
                GameConfig.boardHeight * GameConfig.squareSize);
    }


}