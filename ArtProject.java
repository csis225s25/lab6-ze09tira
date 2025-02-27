/**
 * ArtProject class - a simple Java Swing program that creates a window
 * with a custom drawing panel to display an artistic scene.
 * 
 * 
 * @author Zi'Aire Tirado
 * @version 02/27/2025
 */

 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.Graphics;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.SwingUtilities;
 
 public class ArtProject implements Runnable {
 
     /**
      * Sets up the main application window and adds an ArtPanel for custom drawing.
      */
     @Override
     public void run() {
         // Create the application window (JFrame)
         JFrame frame = new JFrame("Art Project");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
         // Set the preferred size of the window
         frame.setPreferredSize(new Dimension(600, 400));
 
         // Add an instance of ArtPanel which contains our custom drawing
         frame.add(new ArtPanel());
 
         // Pack the frame and display it
         frame.pack();
         frame.setVisible(true);
     }
 
     /**
      * Main method to launch the ArtProject application.
      * 
      * @param args Command line arguments (not used)
      */
     public static void main(String[] args) {
         // Schedule a job for the event-dispatching thread to create and show the GUI.
         SwingUtilities.invokeLater(new ArtProject());
     }
 }
 
 /**
  * ArtPanel class extends JPanel to provide custom painting.
  * @author Zi'Aire Tirado
  * @version 02/27/2025
  */
 class ArtPanel extends JPanel {
 
     // Named constants for the scene layout and dimensions
     private static final int FRAME_WIDTH = 600;
     private static final int FRAME_HEIGHT = 400;
     private static final int HOUSE_X = 200;
     private static final int HOUSE_Y = 200;
     private static final int HOUSE_WIDTH = 150;
     private static final int HOUSE_HEIGHT = 150;
     private static final int DOOR_WIDTH = 40;
     private static final int DOOR_HEIGHT = 70;
     private static final int ROOF_PEAK_Y = 130;
 
     /**
      * Constructor for ArtPanel.
      */
     public ArtPanel() {
         // Set the background color to simulate a clear sky.
         setBackground(Color.CYAN);
     }
 
     /**
      * Overrides the paintComponent method to perform custom drawing.
      * 
      * @param g The Graphics context used for drawing
      */
     @Override
     public void paintComponent(Graphics g) {
         // Always call the superclass method first to ensure proper painting.
         super.paintComponent(g);
 
         // -------------------------
         // Draw the House Body
         // -------------------------
         // Set the color for the house (tan)
         g.setColor(new Color(210, 180, 140));
         g.fillRect(HOUSE_X, HOUSE_Y, HOUSE_WIDTH, HOUSE_HEIGHT);
 
         // -------------------------
         // Draw the Roof
         // -------------------------
         // Set the color for the roof (brown)
         g.setColor(new Color(139, 69, 19));
         // Define the x-coordinates and y-coordinates for the roof polygon vertices
         int[] roofX = { HOUSE_X - 10, HOUSE_X + HOUSE_WIDTH / 2, HOUSE_X + HOUSE_WIDTH + 10 };
         int[] roofY = { HOUSE_Y, ROOF_PEAK_Y, HOUSE_Y };
         g.fillPolygon(roofX, roofY, roofX.length);
 
         // -------------------------
         // Draw the Door
         // -------------------------
         // Set the color for the door (darker brown)
         g.setColor(new Color(102, 51, 0));
         int doorX = HOUSE_X + (HOUSE_WIDTH - DOOR_WIDTH) / 2;
         int doorY = HOUSE_Y + HOUSE_HEIGHT - DOOR_HEIGHT;
         g.fillRect(doorX, doorY, DOOR_WIDTH, DOOR_HEIGHT);
 
         // -------------------------
         // Draw the Windows
         // -------------------------
         // Set the color for the windows (white)
         g.setColor(Color.WHITE);
         // Left window
         g.fillRect(HOUSE_X + 20, HOUSE_Y + 30, 30, 30);
         // Right window
         g.fillRect(HOUSE_X + HOUSE_WIDTH - 50, HOUSE_Y + 30, 30, 30);
 
         // -------------------------
         // Draw the Sun
         // -------------------------
         // Set the color for the sun (yellow)
         g.setColor(Color.YELLOW);
         g.fillOval(50, 50, 80, 80);
 
         // -------------------------
         // Draw the Tree
         // -------------------------
         // Draw the tree trunk using fillRect (dark brown)
         g.setColor(new Color(102, 51, 0));
         g.fillRect(480, 250, 20, 100);
         // Draw the tree foliage using fillOval (green)
         g.setColor(Color.GREEN);
         g.fillOval(450, 200, 80, 80);
 
         // -------------------------
         // Add a Smiling Arc on the Door
         // -------------------------
         // Set the color for the smile (red)
         g.setColor(Color.RED);
         g.drawArc(doorX, doorY - 10, DOOR_WIDTH, 20, 0, -180);
 
         // -------------------------
         // Draw Window Details
         // -------------------------
         // Set the color for the window details (black)
         g.setColor(Color.BLACK);
         // Left window detail lines
         int leftWindowX = HOUSE_X + 20;
         int leftWindowY = HOUSE_Y + 30;
         g.drawLine(leftWindowX, leftWindowY + 15, leftWindowX + 30, leftWindowY + 15);
         g.drawLine(leftWindowX + 15, leftWindowY, leftWindowX + 15, leftWindowY + 30);
         // Right window detail lines
         int rightWindowX = HOUSE_X + HOUSE_WIDTH - 50;
         int rightWindowY = HOUSE_Y + 30;
         g.drawLine(rightWindowX, rightWindowY + 15, rightWindowX + 30, rightWindowY + 15);
         g.drawLine(rightWindowX + 15, rightWindowY, rightWindowX + 15, rightWindowY + 30);
     }
 }
 