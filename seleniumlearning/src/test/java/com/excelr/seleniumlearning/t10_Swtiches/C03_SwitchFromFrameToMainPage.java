package com.excelr.seleniumlearning.t10_Swtiches;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class C03_SwitchFromFrameToMainPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

	// Switch to frame
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ZERO.plusSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));

	//click on 'Try it' button
		WebElement try_it_button = driver.findElement(By.xpath("//button[(text()='Try it')]"));
		try_it_button.click();

	// switch to alert - Explicit wait way
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ZERO.plusSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.alertIsPresent()).accept();

	// text validation 
		WebElement text = driver.findElement(By.xpath("//p[text()='You pressed OK!']"));
		Assert.isTrue(text.isDisplayed(), "Text is not available"); 
		System.out.println("Text Validation completed");

	// switch to main frame/ window from alert
		//driver.switchTo().defaultContent();				//way 1
		//driver.switchTo().parentFrame();					//way 2
		String mainwindowhandle = driver.getWindowHandle();		//way 3
		driver.switchTo().window(mainwindowhandle);				
		
		WebElement run = driver.findElement(By.xpath("//button[@id='runbtn']"));
		run.click();
		System.out.println("Run button is clicked");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver_win32_0_5060_134.exe /T");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
