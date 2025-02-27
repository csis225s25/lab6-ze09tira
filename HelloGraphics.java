import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    public GraphicsPanel() {
        // Set the panel's background color.
        setBackground(Color.BLUE);
        // Set the panel's foreground color which we'll use for drawing.
        setForeground(Color.RED);
    }

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
        
        
        // Use the panel's foreground color for drawing the string.
        g.setColor(getForeground());
        
        String message = "Hello, Java Graphics World!";
        FontMetrics fm = g.getFontMetrics();
        
        int stringWidth = fm.stringWidth(message);
        int stringAscent = fm.getAscent();
        
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        // Center the string both horizontally and vertically.
        int x = (panelWidth - stringWidth) / 2;
        int y = (panelHeight + stringAscent) / 2;
        
        g.drawString(message, x, y);
    }
}


public class HelloGraphics implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}