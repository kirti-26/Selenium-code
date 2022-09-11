package com.excelr.seleniumlearning.t02_openURL;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class C3_Using_NavigateInterface_ToMethod2 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		
		try {
			driver.navigate().to(new URL("https://fb.com") );
			//at times we have networking related code in which there is an URL
			//here try catch is auto generated block to remove error. We inserted Thread.sleep()
		
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.close();		//rtp 
	}

}
