import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class ImageWindow extends JFrame {

	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater( () -> createAndShowGUI());

	}

	public static void createAndShowGUI()
	{
		ImageWindow frm = new ImageWindow();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.addComponentsToPane(frm.getContentPane());
		frm.pack();
		frm.setVisible(true);
			}
	
	public void addComponentsToPane(Container p)
	{
		JLabel imgHolder = new JLabel();
		JPanel anpanman = new JPanel(); 
		anpanman.setLayout(new FlowLayout());
		try {
			File imgfi = new File("C:\\Users\\sammy\\Downloads\\lol.jpg");
			BufferedImage bi = ImageIO.read(imgfi);
			imgHolder.setIcon(new ImageIcon(bi.getScaledInstance(400, 300, Image.SCALE_DEFAULT)));
		}
		catch(IOException e)
		{
			imgHolder.setText("Error loading img");
		}
	
		anpanman.add(imgHolder);
		p.add(anpanman);
		
	}
}
