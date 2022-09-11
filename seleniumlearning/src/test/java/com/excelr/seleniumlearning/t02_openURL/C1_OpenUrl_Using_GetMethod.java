package com.excelr.seleniumlearning.t02_openURL;

import org.openqa.selenium.chrome.ChromeDriver;

public class C1_OpenUrl_Using_GetMethod {

	public static void main(String[] args) {
	
		System.out.println("");
		
		System.setProperty("webdriver.chrome.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://fb.com");		//mention complete URL in get() method
		
		try {
			Thread.sleep(5000);		 
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();	
		driver.quit();	
	
	}
}


