/**
* wird durch den Maven Build verändert.
 **/
package	de.ekert.mavendemo.app;

public class BuildInfo {
	private static final String VERSION = "2023-06-21-16-08-18";
	private static final String VERSIONBUILDER = "thomase";

	public static String getVersion(){
		return VERSION;
	}

	public static String getBuilder(){
		return VERSIONBUILDER;
	}
}
