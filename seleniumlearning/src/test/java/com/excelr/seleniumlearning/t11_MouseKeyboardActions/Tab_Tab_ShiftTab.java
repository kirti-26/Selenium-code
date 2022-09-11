package com.excelr.seleniumlearning.t11_MouseKeyboardActions;

import java.time.Duration; import org.openqa.selenium.By;import org.openqa.selenium.Keys;import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.interactions.Actions;

public class Tab_Tab_ShiftTab {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://fb.com");
		
		String xpath_NewAcc = "//a[normalize-space()='Create New Account']";
		WebElement newAcc = driver.findElement(By.xpath(xpath_NewAcc));
		newAcc.click();
		
	//enter firstname and press TAB. It will go to lastname
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.clear();
		firstname.sendKeys("Java",Keys.TAB);			//TAB - to move forward		//TAB - firstname to lastname
		
	//perform action and again press TAB. IT will move to mobile number text box
		Actions a = new Actions(driver);				//all mouse and keyboard actions
		a.sendKeys(Keys.TAB).perform();					//TAB - lastname to mobile number
		a.sendKeys("0987654321").perform();				//actions need performance - thus, .perform();
		a.sendKeys(Keys.SHIFT, Keys.TAB).perform();		//ShiftTab - to move backward - mobile number to lastname
		a.sendKeys(Keys.SHIFT, Keys.TAB).perform();		//ShiftTab - to move backward - lastname to firstname
		firstname.clear();								//clear name entered in firstname
		firstname.sendKeys("Selenium",Keys.TAB);		//enter new name in firstname and press TAB to move to lastname
		a.sendKeys("ExcelR").perform();					//perform action on lastname
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
