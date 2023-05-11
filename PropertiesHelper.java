package pub;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    public static String getValueFromPropertiesFile(String propertiesKey, String absolutePath) {
        Properties prop = new Properties();
        FileInputStream input = null;
        String value = null;

        try {
            // Load the properties file from the given absolute path
            input = new FileInputStream(absolutePath);
            prop.load(input);

            // Get the value of the specified key from the properties file
            value = prop.getProperty(propertiesKey);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Close the input stream
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return value;
    }
}