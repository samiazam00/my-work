/**
 * @author Samreen Azam
 * Homework #4
 */
import java.util.Comparator;
public class CompareByRating implements Comparator<Photograph>
{
	/**
	 * @param p1
	 * @param p2
	 * @return int value based on the rating or caption to determine how to sort the Photograph objects
	 */
	@Override
	public int compare(Photograph p1, Photograph p2) { //highest rated photo is first
		if(p1.getRating() > p2.getRating()) 
			return -1;
		else if(p1.getRating() < p2.getRating())
			return 1;
		else 		//ratings are equal to each other
		{
			if(p1.getCaption().compareTo(p2.getCaption())  < 0)
				return -1;
			else if(p1.getCaption().compareTo(p2.getCaption())  > 0)
				return 1;
			else
				return 0;
		}
			
	}

}