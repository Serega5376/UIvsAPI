package com.company.firstTestWebServices;

import java.io.IOException;
import java.util.Properties;

public class Utils {
	private static final String PROPERTIES_FILE = "test.properties";

	public static Properties readProperties() {
		Properties properties = new Properties();
		try {
			properties.load(Utils.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException e) {
			throw new RuntimeException("Cannot read properties", e);
		}
		return properties;
	}
}
