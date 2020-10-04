package risingWaters;

import java.io.InputStream;

/** Loads resources from files.
 * 
 * @version FINAL
 * @author Cindy Liu and Emily Hu
 * Due date: June 10th, 2019
 * Time Spent: 1 hour
 */
public abstract class ResourceLoader {

	/**
	 * Get the resource from the location
	 * @param  location The file location
	 * @return          The input stream containing the contents of the file at the specified location
	 */
	public static InputStream getResource(String location) {
		return ResourceLoader.class.getClassLoader().getResourceAsStream(location);
	}

	/**
	 * Get the location of the resource in the Jar file
	 * @param  location The relative location
	 * @return          The absolute location of the file
	 */
	public static String getResourceLocation(String location) {
		return ResourceLoader.class.getClassLoader().getResource(location).toExternalForm();
	}
}
