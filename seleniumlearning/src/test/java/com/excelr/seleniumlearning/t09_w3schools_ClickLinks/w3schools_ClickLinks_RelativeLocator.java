package com.excelr.seleniumlearning.t09_w3schools_ClickLinks;

import java.time.Duration; import java.util.LinkedHashSet;import java.util.List;import org.openqa.selenium.WebElement;import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.locators.RelativeLocator;import org.openqa.selenium.By;

public class w3schools_ClickLinks_RelativeLocator {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://www.w3schools.com/sql/default.asp");

		// below code is drafted using new feature of selenium 4 - RelativeLocator
		// code does not show any error, but it is not getting executed
		List<WebElement> allSQL_Links = driver.findElements(RelativeLocator.with(By.xpath
				("a[contains(text(),'SQL']")).below(By.xpath("//h2[text()='Tutorial']")).above
				(By.xpath("//h2[text()='Database']")));

		System.out.println("size - " + allSQL_Links.size());

		for (int index = 0; index < allSQL_Links.size(); index++) {
			allSQL_Links.get(index).click();
			System.out.println(index + " - " + driver.getTitle());
			allSQL_Links = driver.findElements(RelativeLocator.with(By.xpath("a[contains(text(),'SQL']"))
					.below(By.xpath("//h2[text()='Tutorial']")).above(By.xpath("//h2[text()='Database']")));
		}

		// above code can be replaced using HashSet to remove duplicate values
		LinkedHashSet<WebElement> all_Links = new LinkedHashSet<>(driver.findElements
				(RelativeLocator.with(By.xpath("a[contains(text(),'SQL']")).below(By.xpath
						("//h2[text()='Tutorial']")).above(By.xpath("//h2[text()='Database']"))));
		
		int i=0;
		for(WebElement eachLink: all_Links) {
			eachLink.click();
			System.out.println(i++ +" - "+driver.getTitle());
			all_Links = new LinkedHashSet<>(driver.findElements(RelativeLocator.with(By.xpath
					("a[contains(text(),'SQL']")).below(By.xpath("//h2[text()='Tutorial']")).above
					(By.xpath("//h2[text()='Database']"))));
		}
		
		try {
			Thread.sleep(5000);
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