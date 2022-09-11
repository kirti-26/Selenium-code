package com.excelr.seleniumlearning.t12_dataFromProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	private static WebDriver driver = null;

	public static WebDriver getBrowser(String type, String browsername) {
		if (type.equalsIgnoreCase("local")) {
			if (browsername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}

		// selenium grid concept
		else if (type.equalsIgnoreCase("remote")) {
			if (browsername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--start-maximize");
				try {
					driver = new RemoteWebDriver(new URL("other machine ip address"), co);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} else if (browsername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions fo = new FirefoxOptions();
				try {
					driver = new RemoteWebDriver(new URL("other machine ip address"), fo);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} else if (browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				EdgeOptions eo = new EdgeOptions();
				try {
					driver = new RemoteWebDriver(new URL("other machine ip address"), eo);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		return driver;
	}

	public static void closeAllBrowser() {
		driver.quit();
	}

	public static void closeCurrentWindow() {
		driver.close();
	}
}
