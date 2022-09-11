package com.excelr.seleniumlearning.t12_dataFromProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class OpenRequiredBrowser {

	public static String getPropertyValue(String filename, String key) {
		FileInputStream dataFile;
		try {
			dataFile = new FileInputStream("testdata\\" + filename + ".properties");

			Properties p = new Properties();

			p.load(dataFile);

			return p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		String user_browser = getPropertyValue("mytestdata", "browsername");
		String url = getPropertyValue("mytestdata", "url");

		WebDriver driver = BrowserFactory.getBrowser("local", user_browser);
		driver.get(url);
	}
}
