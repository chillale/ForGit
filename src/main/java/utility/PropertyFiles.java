package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFiles {
	public String readDataFromProperty(String key) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./Data/Common.properties");
		Properties prop = new Properties();
		prop.load(fileInputStream);
		return prop.getProperty(key);
	}
}
