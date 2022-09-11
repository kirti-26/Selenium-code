package com.excelr.seleniumlearning.t05_locate_find_do_action;

import java.time.Duration; import org.openqa.selenium.By; import org.openqa.selenium.WebElement; import org.openqa.selenium.chrome.ChromeDriver;

public class EnterText_fb_UserID_Textbox {
	
	public static void main(String[] args) {
		
		// 1 - open chrome
		System.setProperty("webdriver.chrome.driver","D:\\\\Kirti\\\\ExcelR_OnlineCLasses\\\\Tools\\\\BrowserExes\\\\chromedriver_win32_0_5060_134.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		// 2 - maximize the window
		driver.manage().window().maximize();
		
		// 3 - set timeout()
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		//implicitWait() - it is the timeout used in selenium
		//used to specify the time for which the driver shall wait if the element is not available immediately
		//if the element is not available, WebDriver will wait for the specified time duration
		//it won't wait for the specified time duration if the element is available soon
		
		// 4 - enter url
		driver.get("https://fb.com");
		
		// 5.1 - observe html page
				
		// 5.2 - locate element using 8 techniques
		By loateUserID = By.id("email");		//By - By is a classname used to locate element
		
		// 5.3 - use selenium code to find the element
		WebElement userId = driver.findElement(loateUserID); //findElement() - method to find element
		
		//WebElement userId = driver.findElement(By.id("email"));
		
		//step 5.2 and 5.3 can be combined but performing separate steps is better
		//5.2 - locate element - inspect element section
		// 5.3 - use selenium code to find element - EOA section (End of Availability)
		// 5.4 - perform some action on the element
		userId.sendKeys("EXCELR");		//sendKeys() - method to type into an element
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		userId.clear();		//clears the text entered in the text box
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
