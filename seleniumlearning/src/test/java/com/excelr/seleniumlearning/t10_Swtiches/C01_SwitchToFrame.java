package com.excelr.seleniumlearning.t10_Swtiches;

import java.time.Duration; import org.openqa.selenium.By; import org.openqa.selenium.NoSuchElementException; 
import org.openqa.selenium.WebElement; import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.support.ui.ExpectedConditions; import org.openqa.selenium.support.ui.WebDriverWait;

public class C01_SwitchToFrame {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

	//Normal Way - 3 ways
		
		//WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));	// 1) frame is treated as WebElement
		//driver.switchTo().frame(frameElement);
		
		//driver.switchTo().frame("iframeResult");					// 2) by using frame id or name
		
		//driver.switchTo().frame(1);								// 3) by using frame index
		
	//Explicit wait way - 4 ways
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ZERO.plusSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));		// 4) by using locator
		
		//WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));		// 5) frame as WebElement
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));				// 6) by frame id or name
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));								// 7) by frame index
		
		WebElement try_it_button = driver.findElement(By.xpath("//button[(text()='Try it')]"));
		try_it_button.click();
		
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
