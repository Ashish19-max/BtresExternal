package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
    
    private static Properties prop;
    
    // Static block to initialize the properties once
    static {
        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/TestData/config.properties");
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }
    
    // This method reads the data from property file
    public static String readPropertyFile(String value) throws IOException {
        return prop.getProperty(value);
    }
    
    // Get value by key
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}