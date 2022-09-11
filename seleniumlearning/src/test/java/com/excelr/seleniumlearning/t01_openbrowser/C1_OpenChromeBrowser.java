package com.excelr.seleniumlearning.t01_openbrowser;

import org.openqa.selenium.chrome.ChromeDriver;

public class C1_OpenChromeBrowser {

	public static void main(String[] args) {
	
		System.out.println("");
		
		//make ready or prepare to check whether our machine has chrome browser installed or not
		//System.setproperty("keyOfParticularBrowser","fullPathTill_exefilename")
		//key is by default given by Selenium - refer Selenium documentation
		System.setProperty("webdriver.chrome.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		try {
			Thread.sleep(5000);		//time in milliseconds 
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();	//will close the current session, but won't delete chromedriver.exe from task manager
		driver.quit();	//will close multiple browsers and will also close taskdriver.exe from task manager
	
	}
}


