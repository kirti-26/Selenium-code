package com.excelr.seleniumlearning.t10_Swtiches;

import java.time.Duration; import org.openqa.selenium.By; import org.openqa.selenium.NoSuchElementException; 
import org.openqa.selenium.WebElement; import org.openqa.selenium.chrome.ChromeDriver; import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions; import org.openqa.selenium.support.ui.WebDriverWait;

public class C02_SwitchToAlert {

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
				
	// switch to alert - Normal way
		//Alert a = driver.switchTo().alert();
		//System.out.println("ALert is - "+a.getText());
		//a.accept();												//click OK
		//a.dismiss();											// click cancel
		
	//switch to alert - Explicit wait way
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ZERO.plusSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		WebElement text = driver.findElement(By.xpath("//p[text()='You pressed OK!']"));
		Assert.isTrue(text.isDisplayed(), "Text is not available");  			//assert will validate the expected condition
		System.out.println("Text Validation completed");						//assert is true means text is available
																	//if assert is false, it will display - "text is not available"
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
