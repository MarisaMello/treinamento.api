package br.com.etech.commons;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {

    public static String getPropertiesValue(String chave){
        Properties properties = new Properties();
        File file  = new File("src/main/java/br/com/etech/properties");

        try {
            properties.load(new FileInputStream(file.getAbsolutePath() + "/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(chave);
    }
}
