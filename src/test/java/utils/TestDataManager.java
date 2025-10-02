package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataManager {
    
    private static Properties properties;
    
    static {
        loadTestData();
    }
    
    private static void loadTestData() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/testdata.properties");
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data properties file", e);
        }
    }
    
    public static String getValidUsername() {
        return properties.getProperty("valid.username");
    }
    
    public static String getValidPassword() {
        return properties.getProperty("valid.password");
    }
    
    public static String getInvalidUsername() {
        return properties.getProperty("invalid.username");
    }
    
    public static String getInvalidPassword() {
        return properties.getProperty("invalid.password");
    }
    
    public static String getEmptyUsername() {
        return properties.getProperty("empty.username");
    }
    
    public static String getEmptyPassword() {
        return properties.getProperty("empty.password");
    }
    
    public static String getSpecialCharUsername() {
        return properties.getProperty("special.char.username");
    }
    
    public static String getSpecialCharPassword() {
        return properties.getProperty("special.char.password");
    }
}
