package com.excelr.seleniumlearning.t03_refresh_forward_backward;

import org.openqa.selenium.chrome.ChromeDriver;

public class C2_Using_NavigateInterface_forward_backward_refresh {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://fb.com");		//navigation - to internally calls get() method
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.navigate().to("https://gmail.com");
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.navigate().back(); 		//will wait for 3 sec and go back to fb.com
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.navigate().forward(); 		//will wait for 3 sec and will be forwarded again to gmail
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.navigate().refresh();		//will wait for 3 sec; refresh the window and close
		
		driver.close();		//rtp 
	}

}
