package legendarius.finalproject.vsh;

/** http://stackoverflow.com/questions/14421694/taking-pictures-with-camera-on-android-programmatically */
/** Above link will help with file directories and image storage */

public class CamController {
	public static final int PICTURE_TAKING_CODE = 47;
	public static int count = 0;
	
	public static void incrementScavengerImageIndex() {
		count++;
	}
}
