/**
 * @author Samreen Azam
 * GUI class for HW5
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhotoViewer extends JFrame 
{
	private PhotographContainer imageLibrary;	
	public ArrayList<Photograph> myImages;
	public JLabel currentImg;
	public JPanel imgButtonPanel;
	JLabel ratingLabel;
	JPanel storeThumbnails;

	public static void main(String[] args) 
	{
		PhotoViewer myViewer = new PhotoViewer();
		//Create 5 Photograph objects from images stored in file:
		String imageDirectory ="images\\";
		Photograph p1 = new Photograph("Lake", imageDirectory + "pic1.jpg", "2015-06-02", 5);
		Photograph p2 = new Photograph("Roses", imageDirectory + "pic2.jpg", "2016-10-27", 4); 
		Photograph p3 = new Photograph("Sakura", imageDirectory + "pic3.jpg", "2016-01-12", 2); 
		Photograph p4 = new Photograph("Tears", imageDirectory + "pic4.jpg", "2018-04-13", 7); 
		Photograph p5 = new Photograph("Sunflowers", imageDirectory + "pic5.jpg", "2017-05-01", 8); 

		//Add all photos to a PhotoLibrary object's hash set:
		myViewer.imageLibrary = new PhotoLibrary("My Library", 1);
		myViewer.imageLibrary.addPhoto(p1);
		myViewer.imageLibrary.addPhoto(p2);
		myViewer.imageLibrary.addPhoto(p3);
		myViewer.imageLibrary.addPhoto(p4);
		myViewer.imageLibrary.addPhoto(p5);

		Collections.sort(myViewer.imageLibrary.getPhotos());
		javax.swing.SwingUtilities.invokeLater(() -> myViewer.createAndShowGUI() );
	}

	//Method for creating GUI components for the frame
	public void createAndShowGUI()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponentsToPane(getContentPane());
		pack();
		this.setVisible(true);
	}

	/** determine how to sort thumbnails
	 * @param isByDate
	 * @param isByRating
	 * @param isByCaption
	 * @return sorted list
	 */
	public ArrayList<Photograph> sortThumbnails(boolean isByDate, boolean isByRating, boolean isByCaption)
	{
		ArrayList<Photograph> myImages = imageLibrary.getPhotos();
		if(isByRating == true)
		{
			Collections.sort(myImages, new CompareByRating());
		}
		else if(isByCaption == true)
		{
			Collections.sort(myImages, new CompareByCaption()); 
		}
		else
		{
			Collections.sort(myImages); //default
		}

		return myImages;

	}

	/**
	 * Create ArrayList of JLabels for the thumbnails and captions, display each image or an error message if file not found:
	 * @param myPhotos
	 * @return JPanel containing sorted thumbnails
	 */
	public JPanel displayThumbnails(ArrayList<Photograph> myPhotos)
	{
		JPanel thumbPan = new JPanel(); //make a panel for thumbnails and captions
		thumbPan.setLayout(new GridLayout(5,2)); //Display thumbnail images in a column
		ArrayList<JLabel> allThumbnails = new ArrayList<>();
		ArrayList<JLabel> allCaptions = new ArrayList<>();
		for(int x = 0; x < 5; x++)
		{
			allThumbnails.add(new JLabel());
			allCaptions.add(new JLabel());
			JLabel t = allThumbnails.get(x);
			JLabel c = allCaptions.get(x);
			try 
			{			
				File f = myPhotos.get(x).getImageFile(); //read file name of each image in Photograph ArrayList
				BufferedImage b = ImageIO.read(f);
				t.setIcon(new ImageIcon(b.getScaledInstance(160, 128, Image.SCALE_DEFAULT))); 
				c.setText("'" + myPhotos.get(x).getCaption() + "', Date: " + myPhotos.get(x).getDateTaken() + ", Rating: " + myPhotos.get(x).getRating());
				t.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) //when thumbnail is clicked, image is enlarged
					{
						currentImg.setIcon(new ImageIcon(b.getScaledInstance(640, 512, Image.SCALE_DEFAULT))); 
						currentImg.setVisible(true);
						imgButtonPanel.setVisible(true);
						pack();
					}
				});		
			}
			catch(IOException e)
			{
				t.setText("Error loading photo.");
			}

			thumbPan.add(t);
			thumbPan.add(c);
		}
		return thumbPan;
	}


	/**
	 * Set up JPanel components (to be added to JFrame later on)
	 * @param p
	 */
	public void addComponentsToPane(Container p)
	{
		myImages = sortThumbnails(true, false, false); //sort by date (default) 
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		currentImg = new JLabel(); //Displays image to be viewed
		currentImg.setVisible(false);
		JPanel mainImgPanel = new JPanel(); //contains the chosen image as well as buttons for going back/next/exit/rating change
		storeThumbnails = displayThumbnails(myImages);
		mainImgPanel.setLayout(new BoxLayout(mainImgPanel, BoxLayout.Y_AXIS));

		//Create buttons for moving to next or previous photo, and for exiting (implement Listeners after creating class)
		imgButtonPanel = new JPanel();
		JButton prevButton = new JButton("Previous");
		JButton nextButton = new JButton("Next");
		JButton exitButton = new JButton("Exit");

		//Create Sorting Buttons
		JPanel sortButtonPanel = new JPanel();
		JButton sortByDate = new JButton("Sort by Date");
		JButton sortByRating = new JButton("Sort by Rating");
		JButton sortByCaption = new JButton("Sort by Caption");

		//Button for changing the rating of an image
		JPanel ratingPanel = new JPanel();
		ratingLabel = new JLabel();
		JTextField ratingEntered = new JTextField("Enter New Rating");
		JButton rateButton = new JButton("Change Rating");

		/**
		 * Create ButtonListener class for implementation
		 * of JButton objects, implements ActionListener interface
		 */
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().contentEquals("date"))
				{
					mainPanel.remove(storeThumbnails);
					mainPanel.remove(mainImgPanel);
					myImages = sortThumbnails(true, false, false);
					storeThumbnails = displayThumbnails(myImages); 
					storeThumbnails.setVisible(true);
					mainPanel.add(storeThumbnails);
					mainPanel.add(mainImgPanel);
					pack();
				}
				else if(e.getActionCommand().contentEquals("rating"))
				{
					mainPanel.remove(storeThumbnails);
					mainPanel.remove(mainImgPanel);
					myImages = sortThumbnails(false, true, false);
					storeThumbnails = displayThumbnails(myImages); 
					storeThumbnails.setVisible(true);
					mainPanel.add(storeThumbnails);
					mainPanel.add(mainImgPanel);
					pack();
				}
				else if(e.getActionCommand().contentEquals("caption"))
				{
					mainPanel.remove(storeThumbnails);
					mainPanel.remove(mainImgPanel);
					myImages = sortThumbnails(false, false, true);
					storeThumbnails = displayThumbnails(myImages); 
					storeThumbnails.setVisible(true);
					mainPanel.add(storeThumbnails);
					mainPanel.add(mainImgPanel);
					pack();

				}
				else if(e.getActionCommand().contentEquals("next"))
				{
					pack();
				}
				else if(e.getActionCommand().contentEquals("prev"))
				{
					pack();
				} 
				else if(e.getActionCommand().contentEquals("exit"))
				{
					currentImg.setVisible(false);
					imgButtonPanel.setVisible(false);
					pack();
				} 
				else if(e.getActionCommand().contentEquals("changeRating"))
				{
					try 
					{
						int input = Integer.parseInt(ratingEntered.getText());
						ratingLabel.setText("Rating changed!"); 
					}
					catch(NumberFormatException ex)
					{
						ratingLabel.setText("Invalid input. Try Again.");
					}
					pack();
				}

			}
		}

		//Add Listeners to buttons:
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(new ButtonListener());
		imgButtonPanel.add(prevButton);
		imgButtonPanel.add(nextButton);
		imgButtonPanel.add(exitButton);
		imgButtonPanel.setVisible(false);
		sortByDate.setActionCommand("date");
		sortByDate.addActionListener(new ButtonListener());
		sortByRating.setActionCommand("rating");
		sortByRating.addActionListener(new ButtonListener());
		sortByCaption.setActionCommand("caption");
		sortByCaption.addActionListener(new ButtonListener());
		sortButtonPanel.add(sortByDate);
		sortButtonPanel.add(sortByRating);
		sortButtonPanel.add(sortByCaption);
		rateButton.setActionCommand("changeRating");
		rateButton.addActionListener(new ButtonListener());
		ratingPanel.add(ratingEntered);
		ratingPanel.add(rateButton);
		imgButtonPanel.add(ratingPanel);

		//Add all components to main panel, and then to pane
		mainImgPanel.add(sortButtonPanel);
		mainImgPanel.add(currentImg);
		mainImgPanel.add(imgButtonPanel, BorderLayout.PAGE_END);
		mainPanel.add(storeThumbnails);
		mainPanel.add(mainImgPanel);
		p.add(mainPanel);
	}

}
