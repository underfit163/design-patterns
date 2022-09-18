package singleton;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties properties = Singleton.getInstance();
            System.out.println(properties.getProperty("prop1"));
            System.out.println(properties.getProperty("prop2"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
