package com.excelr.seleniumlearning.t01_openbrowser;

import org.openqa.selenium.WebDriver;

public class C2_TestCase_Factory {
	
	public static void main(String[] args) {
		
		WebDriver driver = BrowserFactory.getAnyBrowser("firefox");
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();		//rtp - point to type side and execution from object side. Execution from chrome
	}

}
