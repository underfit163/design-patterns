package singleton;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Singleton {
    private static Properties properties;

    private Singleton() {
    }

    public synchronized static Properties getInstance() throws IOException {
        if (properties == null) {
            properties = new Properties();
            properties.load(new FileReader("src/singleton/config.properties"));
        }
        return properties;
    }
}
