import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GraphicsHandler extends JPanel implements ActionListener {
    private static final int RECT_X = 20;
    private static final int RECT_Y = RECT_X;
    private static final int RECT_WIDTH = 100;
    private static final int RECT_HEIGHT = RECT_WIDTH;

    GraphicsHandler mainPanel;
    Board board;
    Timer timer=new Timer(500, this);

    public GraphicsHandler(Board board) {
        this.board = board;
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the rectangle here
        System.out.println(board.getSnake().x[0]);
        g.drawRect(board.getSnake().x[0], RECT_Y, RECT_WIDTH, RECT_HEIGHT);

    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);
    }

    // create the GUI explicitly on the Swing event thread
    public void createAndShowGui() {
        GraphicsHandler mainPanel = new GraphicsHandler(board);



        JFrame frame = new JFrame("DrawRect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            board.generateBlankBoard();
            board.addSnakeToBoard();
            board.updateSnake();
            repaint();// this will call at every 1 second
        }
    }

}