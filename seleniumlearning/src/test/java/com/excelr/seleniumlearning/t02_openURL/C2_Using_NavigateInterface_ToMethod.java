package com.excelr.seleniumlearning.t02_openURL;

import org.openqa.selenium.chrome.ChromeDriver;

public class C2_Using_NavigateInterface_ToMethod {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://fb.com");		//navigation - to internally calls get() method
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();		//rtp 
	}

}
