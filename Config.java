package cura.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class Config {

	public static Properties p;
	public static String USER_DIR = System.getProperty("user.dir");
	public static String image;
	public static File sourceFile;
	
	public static final String HTML_RESULT_PATH = USER_DIR + "\\htmlReports\\";
	public static final String IMAGES_PATH = USER_DIR + "\\screenshots\\";
	
	public static final int PAGE_LOAD_WAIT = Integer.parseInt(getProp("pageLoadTimeout"));
	public static final int IMPLICITY_WAIT = Integer.parseInt(getProp("implicityTimeout"));
	public static final int EXPLICITY_WAIT = Integer.parseInt(getProp("explicityTimeout"));

	public static final String BROWSER = getProp("browserType");
	public static final String URL = getProp("appURL");
	
	public static final String CHROME_DRIVER_PATH = USER_DIR + getProp("chromeDriverPath");
	public static final String FIREFOX_DRIVER_PATH = USER_DIR + getProp("firefoxDriverPath");
	public static final String IE_DRIVER_PATH = USER_DIR + getProp("IEDriverPath");
	public static final String EDGE_DRIVER_PATH = USER_DIR + getProp("edgeDriverPath");
	public static final String OPERA_DRIVER_PATH = USER_DIR + getProp("operaDriverPath");
	
	public static final String TESTDATA_PATH = getProp("testDataPath");

	public static String getProp(String key) {
		try {
			p = new Properties();
			FileInputStream inFile = new FileInputStream(USER_DIR + "//com//cura//config//config.properties");
			p.load(inFile);
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return p.getProperty(key);
	}

}
