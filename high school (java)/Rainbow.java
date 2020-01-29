/* Name: Samreen Azam
 * AP Computer Science
 * Period 6
 * Chapter 5 Question 27 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  Color skyColor = Color.CYAN; // Declare skyColor, initializes color to blue (cyan)

  public Rainbow()
  {
    setBackground(skyColor); //sets background to cyan
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();
   
    int xCenter = width/2; // Declare and initialize local int variables xCenter, yCenter
    int yCenter = height*(3/4); // that represent the center of the rainbow rings:
 
    // Declare and initialize the radius of the large semicircle:
    int largeRadius = width/4;
    
    g.setColor(Color.RED); 

    // Draw the large semicircle:
    g.fillArc(xCenter/2, (yCenter + largeRadius)/2, largeRadius*2, largeRadius*2, 0, 180);

    // Declare and initialize the radii of the small and medium semicircles:
    int smallRadius = height/4; 
    int medRadius = (int) (Math.sqrt(largeRadius * smallRadius)); //casts double to int to round the square root 
                                                                  //of the geometric mean of large & small radii
    g.setColor(Color.GREEN); 
    g.fillArc((xCenter + largeRadius - smallRadius)/2, (yCenter + medRadius), medRadius*2, medRadius*2, 0, 180); //draws green semicircle
  
    g.setColor(Color.MAGENTA); 
    g.fillArc((xCenter + medRadius)/2, yCenter + (largeRadius + medRadius)/2, smallRadius*2, smallRadius*2, 0, 180); //draws magenta semicircle
   
    
   
    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    
    int innerRadius = smallRadius - 2*(medRadius - smallRadius) + (largeRadius - medRadius);
    g.setColor(skyColor); //sets innermost semicircle to cyan
    // Draw the sky-color semicircle:
    g.fillArc((xCenter + (largeRadius + medRadius + innerRadius))/3, (yCenter + (largeRadius + medRadius + innerRadius))/2, innerRadius*2, innerRadius*2, 0, 180); 
 
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
