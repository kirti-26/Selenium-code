package com.excelr.seleniumlearning.t06_select_from_dropdown;

import java.time.Duration; import java.util.List; import org.openqa.selenium.By; import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; import org.openqa.selenium.support.ui.Select;

public class FB_NewAccount_DOB_using_ArrayList {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		// driver.manage().timeouts().implicitlyWait(120, TimeUnits.SECONDS);
		// //deprecated
		driver.get("https://fb.com");

		WebElement newAcc = driver.findElement(By.xpath("//a[normalize-space()='Create New Account']"));
		newAcc.click();

		// using ArrayList with Select and getText() in if loop
		WebElement dayDrop = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(dayDrop);
		List<WebElement> allDays = daySelect.getOptions();
		for (WebElement eachDay : allDays) {
			if (eachDay.getText().equals("26")) {
				eachDay.click();
				break;
			}
		}

		// using only ArrayList and getAttribute() in if loop
		List<WebElement> allMonths = driver.findElements(By.xpath("//select[normalize-space(@id)='month']/option"));
		for (WebElement eachMonth : allMonths) {
			if (eachMonth.getAttribute("value").equals("8")) {
				eachMonth.click();
				break;
			}
		}

		// enhanced code - takes more time to run as compared to other 5 types
		//findFirst() - will take first value if there are duplicate values
		// -> this is called lambda expression
		//for cssSelector, use > sign instead of / sign as in xpath
		driver.findElements(By.cssSelector("select[id='year']>option")).parallelStream()
				.filter(eachYear -> eachYear.getText().equalsIgnoreCase("1989")).findFirst().get().click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
