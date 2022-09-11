package com.excelr.seleniumlearning.t04_maximize_minimize_browser;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_Using_NavigateInterface_maximize_minimize {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://fb.com");
		
		//descriptive programming
		driver.manage().window().maximize();	//window will be maximized
		
			//detailed programming
		//Options o = driver.manage();
		//Window w = o.window();
		//w.maximize(); 
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().window().minimize();	//after 3 sec window will be minimized
		
		driver.quit();		//rtp 
	}
}
