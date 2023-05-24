package utils.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

    private static Properties properties;
    private static final String configurationFile = "token.properties";
    public static final String REPOSITORY_OWNER = getConfigurationProperty("REPOSITORY_OWNER");
    public static final String TOKEN = getConfigurationProperty("TOKEN");
    public static final String INVALID_TOKEN = getConfigurationProperty("INVALID_TOKEN");
    public static final String EXPIRED_TOKEN = getConfigurationProperty("EXPIRED_TOKEN");
    public static final String INSUFFICIENT_PERMISSIONS_TOKEN = getConfigurationProperty("INSUFFICIENT_PERMISSIONS_TOKEN");

    private static String getConfigurationProperty(String propertyName) {
        try {
            if (properties == null) {
                readConfiguration();
            }
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println("There is an error retrieving configuration properties!");
            return "";
        }
    }

    private static void readConfiguration() throws IOException {
        ClassLoader classLoader = Settings.class.getClassLoader();
        File file = new File(classLoader.getResource(configurationFile).getFile());
        Path filePath = Paths.get(file.getAbsolutePath());
        InputStream input = new FileInputStream(filePath.toString());

        properties = new Properties();
        properties.load(input);
    }
}
