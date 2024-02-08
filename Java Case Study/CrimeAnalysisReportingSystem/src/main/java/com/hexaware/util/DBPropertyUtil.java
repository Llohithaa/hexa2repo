package com.hexaware.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	public static String getPropertyString(String fileName) {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(fileName)) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String connectionString = "jdbc:mysql://" +
                properties.getProperty("db.hostname") +
                ":" + properties.getProperty("db.port") +
                "/" + properties.getProperty("db.name") +
                "?user=" + properties.getProperty("db.username") +
                "&password=" + properties.getProperty("db.password");

        return connectionString;
    }
}
