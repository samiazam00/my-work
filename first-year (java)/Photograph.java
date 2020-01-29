import java.io.File;

/**
 * @author Samreen Azam (sa3tnc)
 */

public class Photograph implements Comparable<Photograph> //Photograph objects will be compared by implementing Comparable interface
{
	//global fields:
	private String caption;
	private final String FILE_NAME;
	private int rating;
	private String dateTaken;
	private File imageFile; 



	//Overloaded Constructors (differing ones depending on what arguments are passed):
	/**
	 * Constructor:
	 * @param caption
	 * @param filename
	 */
	public Photograph(String caption, String filename)
	{
		this.caption = caption;
		this.FILE_NAME = filename;
		imageFile = new File(filename);

	}

	/**
	 * Constructor: 
	 * @param caption
	 * @param dateTaken
	 * @param rating
	 */
	public Photograph(String caption, String dateTaken, int rating)
	{
		this.caption = caption;
		this.dateTaken = dateTaken;
		this.rating = rating;
		this.FILE_NAME = "";
	}

	/**
	 * Constructor:
	 * @param filename
	 * @param caption
	 * @param dateTaken
	 * @param rating
	 */
	public Photograph(String caption, String filename, String dateTaken, int rating)
	{
		this.caption = caption;
		this.dateTaken = dateTaken;
		this.rating = rating;
		this.FILE_NAME = filename;
		imageFile = new File(filename);
	}

	/**
	 * Accessor
	 * @return rating
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * Mutator method
	 * @param rating 
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Accessor method that gets the private String caption
	 * @return caption
	 */
	public String getCaption()
	{
		return caption;
	}

	/**
	 * Accessor method
	 * @return dateTaken
	 */
	public String getDateTaken() {
		return dateTaken;
	}

	/**
	 * Mutator method
	 * @param dateTaken
	 * @return dateTaken after modification 
	 */
	public void setDateTaken(String dateTaken) {
		this.dateTaken = dateTaken;
	}

	/**
	 * Accessor method
	 * @return imageFile
	 */
	public File getImageFile() {
		return imageFile;
	}

	/**
	 * Mutator method
	 * @param imageFile 
	 * @return imageFile after modification
	 */
	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	/**
	 * Mutator method
	 * @param caption 
	 * @return caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * Accessor method that gets the private String FILE_NAME
	 * @return FILE_NAME
	 */
	public String getFilename()
	{
		return FILE_NAME;
	}

	/**
	 * Overrides the equals method to check if an object passed to method is the same as a certain Photograph object
	 * @param o (Object type to compare)
	 * @return true if the Photograph objects are the same; false if they aren't equal, the object is null, or of a different class
	 */
	@Override 
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != this.getClass()) 
			return false;
		else
		{
			Photograph photoToCompare = (Photograph) o; //Object o converted to Photograph type and saved to new Photograph object photoToCompare
			return (this.caption.equals(photoToCompare.caption) && (this.getFilename().equals(photoToCompare.getFilename()))); 
			//recursively checks if caption & file name of current Photograph object equals the Photograph object passed as an argument by, returns true if both parts match
		}
	}

	/**
	 * @return String representation of the file name and caption of a Photograph object
	 */
	@Override
	public String toString()
	{
		return "File Name: " + getFilename() + ", Caption: " + getCaption();
	}	

	/**
	 * Compare the dateTaken fields for both objects to determine order in which Photograph objects should be sorted
	 * @return the int value based on the date or caption of the photos
	 */
	@Override
	public int compareTo(Photograph p)
	{
		int val = this.getDateTaken().compareTo(p.getDateTaken()); //invokes the inherited compareTo method for Strings from String class
		if(val < 0)
			return -1;   ////if this Photograph object has a date that follow p's date, a value of -1 is returned 
		else if(val > 0) //if this Photograph object has a date preceding p's date, a value of 1 is returned 
			return 1;
		else   			 //the values must be identical if val = 0, so the captions are compared when sorting
		{	 
			int retval = 0;
			int val2 = this.getCaption().compareTo(p.getCaption());
			if(val2 < 0)
				retval = -1;
			else if(val2 > 0) // 
				retval =  1;

			return retval;
		}

	}


}
