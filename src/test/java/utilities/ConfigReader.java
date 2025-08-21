package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    public static void loadProperties(String fileName) {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("❌ Sorry, unable to find " + fileName + " in resources folder");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("❌ Failed to load " + fileName + ": " + ex.getMessage(), ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}



    /**
     * Get property by key
     * @param key property key
     * @return value
     */
  

    /**
     * Get property with default value
     * @param key property key
     * @param defaultValue value to return if key is missing
     * @return property value or defaultValue
     */
   

