package Game;

import Board.Board;
import Events.EventHandler;
import Graphics.GraphicsHandler;

public class Game {
    public static void main(String[] args) {
        GameState gameState = new GameState();
        Board theBoard = new Board(GameConfig.boardWidth, GameConfig.boardHeight);
        GraphicsHandler gh = new GraphicsHandler(theBoard);
        EventHandler eventHandler = new EventHandler(gh);

        // Creates a new thread so our GUI can process itself
        Thread t = new Thread(eventHandler);
        t.start();

    }

}
