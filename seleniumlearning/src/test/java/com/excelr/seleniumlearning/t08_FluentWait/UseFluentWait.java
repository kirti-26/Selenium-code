package com.excelr.seleniumlearning.t08_FluentWait;

import java.time.Duration; import java.util.List; import org.openqa.selenium.By; 
import org.openqa.selenium.StaleElementReferenceException; import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import org.openqa.selenium.chrome.ChromeDriver; import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait; import org.openqa.selenium.support.ui.WebDriverWait;

public class UseFluentWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://fb.com");

		// for ex. 'Create New Account' button appears late on web page
		// in such case, FluentWait() is to be used
		//FLuentWait() - defines the maximum amount of time to wait for a condition and the frequency to check the condition

		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(30));	//wait for max 30 sec
		wait.pollingEvery(Duration.ofSeconds(5));	//frequency to check - keep checking every 5 sec
		wait.ignoring(StaleElementReferenceException.class);	//while checking ignore the element not found exception
		WebElement create_new_account = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Create New Account']")));
		//wait until expected condition is met - mention expected condition
		
		create_new_account.click();
		
		//in case if you fail to mention the Timeout duration, WebDriver will not wait
		//for such case, use child class of FluentWait class i.e. WebDriverWait
		//WebDriverWait takes 3 arguments simultaneously - 1) who shall wait i.e. driver 2) Duration 3) time
		
		FluentWait<WebDriver> child = new WebDriverWait(driver,Duration.ofSeconds(30));		//upcasting - child pointing to parent
		child.pollingEvery(Duration.ofSeconds(5));
		child.ignoring(StaleElementReferenceException.class);
		List<WebElement> dayDrop = child.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='day']/option")));
		for(WebElement day: dayDrop) {
			if(day.getText().equalsIgnoreCase("26")) {
				day.click();
				break;
			}
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

//WebDriverWait class has no extra methods, it has only constructors.
//all the methods are coming from parent class FluentWait
//all the methods of FluentWait are used by WebDriverWait - thus it is upcasting
