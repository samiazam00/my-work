/**
 * @author Samreen Azam
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class PhotoLibraryTester {
	//Fields to use during testing:
	Photograph p;
	Photograph p2;
	Photograph p3;
	Album a;
	PhotoLibrary pl;
	PhotoLibrary pl2; 
	/**
	 * Initialize fields before any tests take place
	 */
	@Before
	public void initValues()
	{	
		p2 = new Photograph("file", "caption", "2019-05-17", 2);
		a = new Album("AlbumName");
		pl = new PhotoLibrary("Name",12);
		pl2 = new PhotoLibrary("Name2",15); 
		p3 = new Photograph("Cap", "FileName", 4);
	}

	@Test
	/**
	 * test if size of ArrayList returned by method is larger than size of original ArrayList photos of PhotoLibrary class
	 * 
	 */
	public void testGetPhotos()
	{
		assertFalse("Invalid photos found in ArrayList.", (pl.getPhotos(5).size() > pl.getPhotos().size()));
	}

	@Test
	/**
	 * ensures that method does not return a null ArrayList
	 */
	public void testGetPhotos2()
	{
		assertTrue("Null ArrayList returned", pl.getPhotos(6) != null);
	}

	@Test
	/**
	 * ensures that method does not return a null ArrayList
	 */
	public void testGetPhotosInMonth()
	{
		assertTrue("Null ArrayList returned", pl.getPhotosInMonth(6,2017) != null);
	}

	@Test
	/** Test if all photos within ArrayList are of the same year
	 */
	public void testGetPhotosInMonth2()
	{
		pl.getPhotos().add(p2);
		String yr = "2019";
		ArrayList<Photograph> yearPics = pl.getPhotosInMonth(5, 2019);
		for(int x = 0; x < yearPics.size(); x++)
		{
			assertTrue("The photos have not been taken within the same year.",(yearPics.get(x).getDateTaken().substring(0,4).equals(yr)));
		}
	}

	@Test
	/**
	 * Test if all photos within ArrayList are within the correct date range
	 */
	public void testGetPhotosBetween()
	{
		pl.getPhotos().add(p2);
		ArrayList<Photograph> picsBtw = pl.getPhotosBetween("2016-01-01", "2019-12-31");
		for(int x = 0; x < picsBtw.size(); x++)
		{
			assertFalse("Photos outside of desired range found.", ((picsBtw.get(x).getDateTaken().substring(0,4).compareTo("2016") > 0) && 
					(picsBtw.get(x).getDateTaken().substring(0,4).compareTo("2019") < 0) ));
		}
	}

	@Test
	/**
	 * ensures that method does not return a null ArrayList
	 */
	public void testGetPhotosBetween2()
	{
		pl2.getPhotos().add(p2);
		assertTrue("Dates are in incorrect order.", pl2.getPhotosBetween("2018-12-31", "2016-01-01") == null);
	}

	@Test
	/**
	 * Test whether a photo was erased successfully or not
	 */
	public void testRemovePhoto()
	{
		pl2.addPhoto(p3);
		pl2.removePhoto(p3);
		assertFalse("Photo was not removed", pl.hasPhoto(p3));
		assertEquals(pl.removePhoto(p), false);
	}

	@Test
	/**
	 * Checks if the photo that is sent as argument to erasePhotos method is null, which would cause it to return false
	 */
	public void testRemovePhoto2()
	{
		assertFalse("Photo is null and does not exist in library, so it cannot be erased.", p != null);
	}
	
	@Test
	/**
	 * Check if the compare method of Photograph class will sort the objects in order by the date
	 */
	public void testCompareTo()
	{
		Photograph pic1 = new Photograph("Name1", "ZZZZ", "2016-12-22", 3);
		Photograph pic2 = new Photograph("Name2", "AAAA", "2016-02-11", 7);
		Photograph pic3 = new Photograph("Name3", "ZZZZ", "2012-10-20", 8);
		
		PhotoLibrary lib = new PhotoLibrary("Name", 101010);
		lib.addPhoto(pic1);
		lib.addPhoto(pic2);
		lib.addPhoto(pic3);
		
		Collections.sort(lib.getPhotos());
		
		//Expected order: pic3, pic2, pic1
		assertTrue("Sorting failure.", lib.getPhotos().get(0).getDateTaken().equals("2012-10-20"));
		assertTrue("Sorting failure.", lib.getPhotos().get(1).getDateTaken().equals("2016-02-11"));
		assertTrue("Sorting failure.", lib.getPhotos().get(2).getDateTaken().equals("2016-12-22"));
	}
	
	@Test
	/**
	 * Checks if the compareTo method of CompareByCaption class will sort Photographs by their caption field
	 */
	public void testCaptionCompare()
	{
		Photograph pic1 = new Photograph("Name1", "ZZZZ", "2018-05-17", 8);
		Photograph pic2 = new Photograph("Name2", "AAAA", "2016-02-11", 7);
		Photograph pic3 = new Photograph("Name3", "ZZZZ", "2012-10-20", 3);
		
		PhotoLibrary lib = new PhotoLibrary("Name", 101010);
		lib.addPhoto(pic1);
		lib.addPhoto(pic2);
		lib.addPhoto(pic3);
		
		Collections.sort(lib.getPhotos(), new CompareByCaption()); //sorts the ArrayList based on CompareByCaption's implementation of a Comparator
		
		//Expected order: pic2, pic1, pic3
		assertEquals(lib.getPhotos().get(0).getCaption(), pic2.getCaption());
		assertEquals(lib.getPhotos().get(1).getCaption(), pic1.getCaption());
		assertEquals(lib.getPhotos().get(1).getRating(), 8);
		assertEquals(lib.getPhotos().get(2).getCaption(), pic3.getCaption());	
		assertEquals(lib.getPhotos().get(2).getRating(), 3);
	} 
	
	
	@Test
	/**
	 * Checks if the compareTo method of CompareByCaption class will sort Photographs by their caption field
	 */
	public void testCaptionCompare2()
	{
		Photograph pic1 = new Photograph("Lalala", "FileUno");
		Photograph pic2 = new Photograph("SleepIsNice", "FileDos");
		Photograph pic3 = new Photograph("Yeeeet", "FileTres");
		
		PhotoLibrary lib = new PhotoLibrary("LibraryName", 12345);
		lib.addPhoto(pic1);
		lib.addPhoto(pic2);
		lib.addPhoto(pic3);
		
		Collections.sort(lib.getPhotos(), new CompareByCaption()); //sorts the ArrayList based on CompareByCaption's implementation of a Comparator
		
		//Expected order: pic1, pic2, pic3
		assertEquals(lib.getPhotos().get(0).getCaption(), pic1.getCaption());
		assertEquals(lib.getPhotos().get(1).getCaption(), pic2.getCaption());
		assertEquals(lib.getPhotos().get(2).getCaption(), pic3.getCaption());	
	} 
	
	@Test
	/**
	 * Checks if the compareTo method of CompareByCaption class will sort Photographs by their rating (highest to lowest)
	 */
	public void testRatingCompare()
	{
		Photograph pic1 = new Photograph("Name1", "CCCC", "2018-05-17", 4);
		Photograph pic2 = new Photograph("Name2", "AAAA", "2016-02-11", 9);
		Photograph pic3 = new Photograph("Name3", "BBBB", "2012-10-20", 3);
		
		PhotoLibrary lib = new PhotoLibrary("Name", 101010);
		lib.addPhoto(pic1);
		lib.addPhoto(pic2);
		lib.addPhoto(pic3);
		
		Collections.sort(lib.getPhotos(), new CompareByRating()); //sorts the ArrayList based on CompareByCaption's implementation of a Comparator
		
		//Expected order: pic1, pic3, pic2
		assertEquals(lib.getPhotos().get(0).getRating(), 9);
		assertEquals(lib.getPhotos().get(1).getRating(), 4);
		assertEquals(lib.getPhotos().get(2).getRating(), 3);
	} 
	
	@Test
	/**
	 * Checks if the compareTo method of CompareByCaption class will look at the caption if all ratings are the same
	 */
	public void testRatingCompare2()
	{
		Photograph pic1 = new Photograph("Name1", "CCCC", "2018-05-17", 4);
		Photograph pic2 = new Photograph("Name2", "AAAA", "2016-02-11", 4 );
		Photograph pic3 = new Photograph("Name3", "BBBB", "2012-10-20", 4);
		
		PhotoLibrary lib = new PhotoLibrary("Name", 101010);
		lib.addPhoto(pic1);
		lib.addPhoto(pic2);
		lib.addPhoto(pic3);
		
		Collections.sort(lib.getPhotos(), new CompareByRating()); //sorts the ArrayList based on CompareByCaption's implementation of a Comparator
		
		//Expected order: pic2, pic3, pic1
		assertEquals(lib.getPhotos().get(0).getCaption(), pic2.getCaption());
		assertEquals(lib.getPhotos().get(1).getCaption(), pic3.getCaption());
		assertEquals(lib.getPhotos().get(2).getCaption(), pic1.getCaption());
	} 
		

	@Test
	/**
	 * Tests if 0.0 is returned when a photo feed has a size of 0
	 */
	public void testSimilarity()
	{

		assertFalse("Incorrect similarity score returned", pl2.similarity(pl,pl2) != 0);
	}

	@Test
	/**
	 * Tests if 1.0 is returned when two photo feeds are exactly the same
	 */
	public void testSimilarity2()
	{
		pl.getPhotos().add(p2);
		pl2.getPhotos().add(p2);
		assertFalse("Incorrect similarity score returned", pl2.similarity(pl,pl2) != 1.0);

	}
}
