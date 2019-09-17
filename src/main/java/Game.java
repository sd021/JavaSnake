import java.awt.*;

public class Game {
    public static void main(String[] args) {

        // Creates a new thread so our GUI can process itself
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Board theBoard = new Board(25, 15);

                GraphicsHandler gh = new GraphicsHandler(theBoard);
                gh.createAndShowGui();
                gh.setVisible(true);
            }
        });

//        while (true) {
//            theBoard.generateBlankBoard();
//            theBoard.updateSnake();
//            theBoard.addSnakeToBoard();
//
//            //Utils.clearScreen();
//            //theBoard.drawBoard();
//            Utils.sleep(1000);
//
//        }
    }

}
