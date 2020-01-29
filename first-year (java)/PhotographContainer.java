import java.util.ArrayList;

/**
 * Samreen Azam
 * Abstract Class 
 *
 */
abstract class PhotographContainer {
	//Fields:
	protected String name;
	protected ArrayList<Photograph> photos;
	
	

	/**
	 * Constructor:
	 * @param name
	 */
	public PhotographContainer(String name)
	{
		this.name = name;
		this.photos = new ArrayList<>();
	}

	/**
	 * Accessor method
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator method (to change name field)
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Accessor method
	 * @return photos
	 */
	public ArrayList<Photograph> getPhotos() {
		return photos;
	}

	/**
	 * Overloaded method
	 * @param rating
	 * @return ArrayList of photos taken higher than/equal to the desired rating
	 */
	public ArrayList<Photograph> getPhotos(int rating)
	{
		ArrayList<Photograph> highRatedPhotos = new ArrayList<>();
		for(int x = 0; x < this.photos.size(); x++ )
		{
			if(this.photos.get(x).getRating() >= rating)
				highRatedPhotos.add(this.photos.get(x));
		}
		return highRatedPhotos;
	}

	/**
	 * Mutator method
	 * @param photos 
	 */
	public void setPhotos(ArrayList<Photograph> photos) {
		this.photos = photos;
	}

	/**
	 * Helper method that checks if ArrayList of photos contains Photograph p
	 * @param p
	 * @return true if p is present in photos, false if not present
	 */
	public boolean hasPhoto(Photograph p)
	{
		if(photos.contains(p))
			return true;
		else
			return false;
	}

	/**
	 * Add Photograph object to photos if it is not already contained in there
	 * @param p
	 * @return true if p was added to the ArrayList, false if not added/p is null
	 */
	public boolean addPhoto(Photograph p)
	{
		if(!hasPhoto(p) && p != null)
		{
			photos.add(p);
			return true;
		}
		else
			return false;
	}

	/**
	 * Calls hasPhoto() to determine if Photograph p is contained in ArrayList photos, and removes it if it's there
	 * @param p
	 * @return true if p was removed, false if p was not there
	 */
	public boolean removePhoto(Photograph p)
	{
		if(hasPhoto(p)) 
		{
			photos.remove(p);
			return true;
		}
		else
			return false;
	}


	/**
	 * @return the number of photos taken (size of ArrayList photos)
	 */
	public int numPhotographs()
	{
		return photos.size();
	}

	/**
	 * Overrides the equals method to check if an object passed to method is the same as a certain PhotographContainer object
	 * @param o (Object to compare to)
	 * @return true if them objects are the same; false if they aren't equal, the object is null, or of a different class
	 */
	@Override 
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != this.getClass()) 
			return false;
		else
		{
			PhotographContainer objToCompare = (PhotographContainer) o; 
			return (this.name.equals(objToCompare.getName()) && (this.photos.equals(objToCompare.getPhotos()))); 
		}
	}

	/**
	 * @return String representation of PhotographContainer object 
	 */
	@Override
	public String toString()
	{
		return "Container Name: " + getName() + ", Contained Photos: " + getPhotos();
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}


	/**
	 * @param month
	 * @param year
	 * @return ArrayList of all Photograph objects taken within a given month & year passed as arguments 
	 */
	public ArrayList<Photograph> getPhotosInMonth(int month, int year)
	{
		ArrayList<Photograph> thisMonthsPhotos = new ArrayList<>();
		try {
			for(int x = 0; x < this.photos.size(); x++)
			{
				int yr = Integer.parseInt(this.photos.get(x).getDateTaken().substring(0,4));
				int mnth = Integer.parseInt(this.photos.get(x).getDateTaken().substring(5,7));
				if(yr == year && mnth == month && mnth > 0 && mnth < 13 && yr > 0)
					thisMonthsPhotos.add(this.photos.get(x));	
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Formatting error ocurred.");
		}
		return  thisMonthsPhotos;
	}

	/**
	 * @param year
	 * @return ArrayList of all Photograph objects taken within a given year
	 */
	public ArrayList<Photograph> getPhotosInYear(int year)
	{
		if(year < 0)
			return null;
		else {
			ArrayList<Photograph> thisYearsPhotos = new ArrayList<>();
			try {
				for(int x = 0; x < this.photos.size(); x++)
				{
					int yr = Integer.parseInt(this.photos.get(x).getDateTaken().substring(0,4));
					if(yr == year && (yr > 0))
						thisYearsPhotos.add(this.photos.get(x));	
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Formatting error ocurred.");
			}

			return  thisYearsPhotos;
		}
	}

	/**
	 * @param beginDate
	 * @param endDate
	 * @return ArrayList of all photos in between the two dates
	 */
	public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate)
	{
		ArrayList<Photograph> photosInBetween = new ArrayList<>();
		if(this.photos.size() == 0)
			return photosInBetween;
		else if(beginDate.compareTo(endDate) > 0) //If dates in wrong order and later date is first, return null
			return null;
		else if(beginDate.length() != 10 && endDate.length() != 10) //If the date is not in the proper format, return null
			return null;
		else if(Integer.parseInt(beginDate.substring(5,7)) > 12 || Integer.parseInt(endDate.substring(5,7)) > 12)
			return null;
		else if(Integer.parseInt(beginDate.substring(8)) > 31 || Integer.parseInt(endDate.substring(8)) > 31)
			return null;
		else
		{
			for(int x = 0; x < this.photos.size(); x++)
			{
				if(this.photos.get(x).getDateTaken().compareTo(beginDate) > 0 && this.photos.get(x).getDateTaken().compareTo(endDate) < 0) 
					photosInBetween.add(this.photos.get(x));
			}
		}
		return photosInBetween;
	}


}
