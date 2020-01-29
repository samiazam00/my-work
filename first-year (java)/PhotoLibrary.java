/**
 * @author Samreen Azam
 * subclass of PhotgraphContainer 
 */
import java.util.*;
public class PhotoLibrary extends PhotographContainer
{

	private final int id;
	private HashSet<Album> albums = new HashSet<>();

	/**
	 * Constructor: initializes fields based on arguments passed when declaring Person object
	 * @param name
	 * @param id
	 */
	public PhotoLibrary(String name, int id)
	{
		super(name); //name field is initialized in the constructor of the superclass
		this.id = id;
	}

	/**
	 * Accessor method for retrieving the Person object's ID
	 * @return ID
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return albums
	 */
	public HashSet<Album> getAlbums() {
		return albums;
	}


	/**
	 * Override since inherited method in superclass does not work as we want it to for a PhotoLibrary object
	 * Calls hasPhoto() to determine if Photograph p is contained in ArrayList photos, and removes it from all Album objects in the HashSet
	 * @param p
	 * @return true if p was totally removed, false if p was not present in photos
	 */
	@Override
	public boolean removePhoto(Photograph p)
	{
		if(hasPhoto(p)) 
		{
			java.util.Iterator<Album> i = albums.iterator();
			Album currentAlbum = new Album("");
			while(i.hasNext())
			{
				currentAlbum = i.next();
				if(currentAlbum.getPhotos().contains(p))
					currentAlbum.removePhoto(p);
			}

			photos.remove(p);
			return true;
		}
		else
			return false; 
	}

	/**
	 * @param o
	 * @return true if two PhotoLibrary objects are equal by comparing id numbers. false if o is null, if o is not of PhotoLibrary type, or if not equal
	 */
	@Override
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != this.getClass())
			return false;
		else
		{
			PhotoLibrary checkPhotoLibrary = (PhotoLibrary) o;
			return (this.getId() == checkPhotoLibrary.getId());
		}
	}

	/**
	 * @return String representation of PhotoLibrary object's fields
	 */
	@Override
	public String toString()
	{
		return "Name: " + name + ", ID: " + id + ", Photos Taken: " + photos + ", Albums: " + albums.toString();
	}

	/**
	 * Calls equals method to check if there are Photographs objects that a and b have
	 * @param a
	 * @param b
	 * @return ArrayList of photograph objects for all photos a and b have in common
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b)
	{
		ArrayList<Photograph> photoFeedCombo = new ArrayList<>();

		for(int x = 0; x < a.getPhotos().size(); x++)
		{
			for(int i = 0; i < b.getPhotos().size(); i++)
			{
				if(a.getPhotos().get(x).equals(b.getPhotos().get(i)))
					photoFeedCombo.add(b.getPhotos().get(i));
			}
		}
		return photoFeedCombo;
	}

	/** 
	 * @param a
	 * @param b
	 * @return value between 0.0 and 1.0 to determine how similar PhotoLibrary a and PhotoLibrary b's photo feeds are
	 */
	public static double similarity(PhotoLibrary a, PhotoLibrary b)
	{
		double min = 1.0;
		if(a.getPhotos().size() == 0  || b.getPhotos().size() == 0) //if one or both haven't taken any photos, there is 0 similarity
			return 0.0;
		else
		{
			if(a.getPhotos().size() >= b.getPhotos().size())
				min = b.getPhotos().size();
			else
				min = a.getPhotos().size();

			double numOfSamePhotos = commonPhotos(a,b).size();
			return numOfSamePhotos/min;
		}
	}
	/**
	 * Make a new Album object and add to HashSet albums if it is not already contained in the HashSet 
	 * @param albumName
	 * @return true if album is added, false if not
	 */
	public boolean createAlbum(String albumName)
	{
		Album newAlbum = new Album(albumName);
		if(!albums.contains(newAlbum))
		{
			albums.add(newAlbum);
			return true;
		}
		else
			return false;
	}

	/**
	 * Helper method
	 * @param albumName
	 * @return Album object with the name passed to parameter 
	 */
	private Album getAlbumByName(String albumName)
	{
		java.util.Iterator<Album> i = albums.iterator();
		Album currentAlbum = null;
		while(i.hasNext())
		{
			currentAlbum = i.next();
			if(currentAlbum.getName().equals(albumName))
			{
				break; 
			}
			currentAlbum = null;
		}
		return currentAlbum;
	}

	/**
	 * Removes an album if contained in HashSet albums, calls getAlbumByName method
	 * @param albumName
	 * @return true if successfully removed, otherwise false
	 */
	public boolean removeAlbum(String albumName)
	{
		if(albums.contains(getAlbumByName(albumName)))
		{
			return albums.remove(getAlbumByName(albumName));
		}
		else
			return false;
	}

	/**
	 * Add a photo to an album if the photo is contained in PhotoLibrary's photo list & is not already in the album
	 * @param p
	 * @param albumName
	 * @return true if Photograph p was added to Album object with the name albumName, false if photo not added
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName)
	{
		if(photos.contains(p))
		{
			Album albumToEdit = getAlbumByName(albumName);
			if(albumToEdit != null)
				return albumToEdit.addPhoto(p);
			else
				return false;
		}
		else
			return false;
	}

	/**
	 * Remove Photograph p from the Album object with the name albumName
	 * @param p
	 * @param albumName
	 * @return true if photo is removed, false if not removed
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName)
	{
		Album albumToEdit = getAlbumByName(albumName);
		return albumToEdit.removePhoto(p);
	}
}
