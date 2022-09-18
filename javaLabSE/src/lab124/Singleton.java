package lab124;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Singleton {
    private static Singleton instance;
    private static Properties properties;

    private Singleton() {
        FileReader fileReader;
        try {
            properties = new Properties();
            fileReader = new FileReader("src/config.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public synchronized static Singleton getInstance() {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }

    public int getSingletonProperty()
    {
        return Integer.parseInt(properties.getProperty("SINGLETON_PROPERTY"));
    }

    public int getMainProperty()
    {
        return Integer.parseInt(properties.getProperty("MAIN_PROPERTY"));
    }

}
