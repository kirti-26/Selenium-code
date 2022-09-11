package com.excelr.seleniumlearning.t01_openbrowser;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.edge.EdgeDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver driver = null;
	
	//WebDriver is class name. User will pass browser name.
	public static WebDriver getAnyBrowser(String browserName) {
		
		//when framework allows any type of child, you definitely need to go for upcasting
		//upcasting is - parent is type & child is object
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\geckodriver-v0.31.0-win64.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\edgedriver_win64_v1264_62.exe");
			driver = new EdgeDriver();
	}
	
		return driver;
	}
		
}
