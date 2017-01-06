package notepad.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pradeep on 6/1/17.
 */
public enum PropertyConfigurator {

    INSTANCE;

    private Properties properties;

    public boolean init() {
        boolean isPropertyFileLoaded = false;
        properties = new Properties();
        try (InputStream is = ClassLoader.getSystemResourceAsStream("application.properties")) {
            properties.load(is);
            isPropertyFileLoaded = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isPropertyFileLoaded;
    }

    public String getValueOf(String key) {
        return properties.getProperty(key);
    }
}
