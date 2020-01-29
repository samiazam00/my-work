/**
 * 
 */

/**
 * @author sammy
 *
 */
public class SomeTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);
        Photograph b = new Photograph("mypic45.jpg", "Grand Canyon", "2016-09-11", 2);
        Photograph c = new Photograph("water.jpg", "Rafting", "2016-05-11", 5);
        Photograph d = new Photograph("water2.jpg", "Rafting 2", "2016-09-30", 1);
        a.takePhoto(b);
        a.takePhoto(c);
        a.takePhoto(d);
		System.out.println(a.getPhotosBetween("2016-05-12", "2017-01-01").size());
		
		Album a1 = new Album("NameExists");
		System.out.println(a.addPhotoToAlbum(b, "NameExists"));
		
		System.out.println(a.addPhotoToAlbum(c, "DOESNOTExist"));

	}

}
