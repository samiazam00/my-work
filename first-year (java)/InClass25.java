/**
 * Samreen Azam
 * 3/20/19
 */


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class InClass25 extends JFrame {
	JLabel infoLabel;
	public static void main(String[] args) {
		//start window
		javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
		
	}
	
	public static void createAndShowGUI()
	{
		InClass25 frm = new InClass25();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.addComponentsToPane(frm.getContentPane());
		frm.pack();
		frm.setVisible(true);	
	}
	
	public void addComponentsToPane(Container p)
	{
		JPanel pan = new JPanel(); 
		pan.setLayout(new FlowLayout());
		infoLabel = new JLabel("Type a value into the text field. \nPress the button to convert from kilometers to miles");
		pan.add(infoLabel);
		p.add(pan);
		
		JTextField txt = new JTextField("Input here");
		pan.add(txt);
		txt.setVisible(true);
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().contentEquals("readInput"))
				{
					try {
						double input = Double.parseDouble(txt.getText());
						double convert = input/1.6009344;
						infoLabel.setText(convert + " miles"); }
					catch(NumberFormatException ex)
					{
						infoLabel.setText("Invalid input. Try Again.");
					}
					pack();
				}
			}
		}
			
	
		JButton act = new JButton("Submit");
		act.setActionCommand("readInput");
		act.addActionListener(new ButtonListener());
		pan.add(act);
		
		
	}

}

class WindowRun implements Runnable
{
	public void run()
	{
		InClass25.createAndShowGUI();
	}
}


/*
try 
{
	File x = new File("images\\pic1.jpg");
	//BufferedImage b1 = ImageIO.read(imageLibrary.getPhotos().get(0).getImageFile());
	BufferedImage b1 = ImageIO.read(x);
	thumbnail1.setIcon(new ImageIcon(b1.getScaledInstance(160, 128, Image.SCALE_DEFAULT)));

	//Add MouseListener - image enlarged and displayed when thumbnail is clicked
	thumbnail1.addMouseListener(new MouseAdapter() 
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			currentImg.setIcon(new ImageIcon(b1.getScaledInstance(1280, 1024, Image.SCALE_DEFAULT))); 
			photoIndex = 0;
		}
	});		
}
catch(IOException e)
{
	thumbnail1.setText("Error loading image");
}

try {
	BufferedImage b2 = ImageIO.read(imageLibrary.getPhotos().get(1).getImageFile());
	thumbnail2.setIcon(new ImageIcon(b2.getScaledInstance(160, 128, Image.SCALE_DEFAULT)));
	thumbnail2.addMouseListener(new MouseAdapter() 
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			currentImg.setIcon(new ImageIcon(b2.getScaledInstance(1280, 1024, Image.SCALE_DEFAULT))); 
			photoIndex = 1;
		}
	});		
}
catch(IOException e)
{
	thumbnail2.setText("Error loading image");
}		

try {
	BufferedImage b3 = ImageIO.read(imageLibrary.getPhotos().get(2).getImageFile());
	thumbnail3.setIcon(new ImageIcon(b3.getScaledInstance(160, 128, Image.SCALE_DEFAULT)));
	thumbnail3.addMouseListener(new MouseAdapter() 
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			currentImg.setIcon(new ImageIcon(b3.getScaledInstance(1280, 1024, Image.SCALE_DEFAULT))); 
			photoIndex = 2;
		}
	});		
}
catch(IOException e)
{
	thumbnail3.setText("Error loading image");
}	
try {
	BufferedImage b4 = ImageIO.read(imageLibrary.getPhotos().get(3).getImageFile());
	thumbnail4.setIcon(new ImageIcon(b4.getScaledInstance(160, 128, Image.SCALE_DEFAULT)));
	thumbnail4.addMouseListener(new MouseAdapter() 
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			currentImg.setIcon(new ImageIcon(b4.getScaledInstance(1280, 1024, Image.SCALE_DEFAULT))); 
			photoIndex = 3;
		}
	});		
}

catch(IOException e)
{
	thumbnail4.setText("Error loading image");
}	

try {
	BufferedImage b5 = ImageIO.read(imageLibrary.getPhotos().get(4).getImageFile());
	thumbnail5.setIcon(new ImageIcon(b5.getScaledInstance(160, 128, Image.SCALE_DEFAULT)));
	thumbnail5.addMouseListener(new MouseAdapter() 
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			currentImg.setIcon(new ImageIcon(b5.getScaledInstance(1280, 1024, Image.SCALE_DEFAULT)));  
			photoIndex = 4;
		}
	});		
}

catch(IOException e)
{
	thumbnail5.setText("Error loading image"); */
//}	

