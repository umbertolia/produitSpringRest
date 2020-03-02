package hdn.example.catservice.utils;

public class Utilitaire {

	public static boolean isUnixOs() {
		String OS = System.getProperty("os.name").toLowerCase();
		System.out.println("OS = " + OS);

		// Get the temporary directory and print it.
		getTempDir();
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}
	
	public static String getTempDir() {

		String property = "java.io.tmpdir";
		return System.getProperty(property);
	}

}
