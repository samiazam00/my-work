import java.util.Collections;

public class Testingstuff {
PhotoContainer imageLibrary = new PhotoContainer();
	public static void main(String[] args) {
		Testingstuff myViewer = new Testingstuff();
		//Create 5 Photograph objects from images stored in file:
		String imageDirectory1 ="C:\\Users\\sammy\\eclipse-workspace\\HW3\\src\\images\\pic1.jpg";
		Photograph p1 = new Photograph("Lake", imageDirectory1 + "img1.jpg", "2015-06-02", 5);
		String imageDirectory2 ="C:\\Users\\sammy\\eclipse-workspace\\HW3\\src\\images\\pic2.jpg";
		Photograph p2 = new Photograph("Roses", imageDirectory2 + "img2.jpg", "2016-10-27", 4); 
		String imageDirectory3 ="C:\\Users\\sammy\\eclipse-workspace\\HW3\\src\\images\\pic3.jpg";
		Photograph p3 = new Photograph("Hana", imageDirectory3 + "img3.jpg", "2016-10-27", 2); 
		String imageDirectory4 ="C:\\Users\\sammy\\eclipse-workspace\\HW3\\src\\images\\pic4.jpg";
		Photograph p4 = new Photograph("Tears", imageDirectory4 + "img4.jpg", "2018-04-13", 7); 
		String imageDirectory5 ="C:\\Users\\sammy\\eclipse-workspace\\HW3\\src\\images\\pic5.jpg"; 
		Photograph p5 = new Photograph("Sunflowers", imageDirectory4=5 + "img5.jpg", "2017-05-01", 8); 

		//Add all photos to a PhotoLibrary object's hash set:
		myViewer.imageLibrary = new PhotoLibrary("My Library", 1);
		myViewer.imageLibrary.addPhoto(p1);
		myViewer.imageLibrary.addPhoto(p2);
		myViewer.imageLibrary.addPhoto(p3);
		myViewer.imageLibrary.addPhoto(p4);
		myViewer.imageLibrary.addPhoto(p5);

		Collections.sort(myViewer.imageLibrary.photos);
		javax.swing.SwingUtilities.invokeLater(() -> myViewer.createAndShowGUI() );
	}

}
