package com.excelr.seleniumlearning.t06_select_from_dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FB_NewAccount_DOB_using_SelectClassMethods {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	// driver.manage().timeouts().implicitlyWait(120, TimeUnits.SECONDS);	//deprecated
		driver.get("https://fb.com");
		
		WebElement newAcc = driver.findElement(By.xpath("//a[normalize-space()='Create New Account']"));
		newAcc.click(); 
		
		By locateFname = By.name("firstname");
		WebElement fname = driver.findElement(locateFname);
		fname.sendKeys("Kirti");
		
		By locateLname = By.name("lastname");
		WebElement Lname = driver.findElement(locateLname);
		Lname.sendKeys("Patil");
		
		WebElement dayDrop = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(dayDrop);
		daySelect.selectByIndex(25);	//index 25 means 26th value. index starts from 0
		
		WebElement monthDrop = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(monthDrop);
		monthSelect.selectByValue("8");		//value text to be taken from UI inspect element
		
		WebElement yearDrop = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(yearDrop);
		yearSelect.selectByVisibleText("1989");		//visible text to be taken from UI inspect element
		
		try {
		Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
