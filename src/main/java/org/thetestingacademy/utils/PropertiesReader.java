package org.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String key) throws IOException {
        String prop_path = System.getProperty("user.dir")+"/src/resources/data.properties";
        Properties properties = new Properties();
        FileInputStream fp = new FileInputStream(prop_path);
        properties.load(fp);

        System.out.println(properties.getProperty(key));
        return properties.getProperty(key);
    }

}
