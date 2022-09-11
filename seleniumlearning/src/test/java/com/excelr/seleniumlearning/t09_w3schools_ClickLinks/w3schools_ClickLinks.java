package com.excelr.seleniumlearning.t09_w3schools_ClickLinks;

import java.time.Duration; import java.util.List; import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement; import org.openqa.selenium.chrome.ChromeDriver;

public class w3schools_ClickLinks {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://www.w3schools.com/sql/default.asp");

		List<WebElement> allSQLlinks = driver.findElements
				(By.xpath("//h2[contains(text(),'Database')]//preceding-sibling::a[contains(text(),'SQL')]"));
		
		System.out.println("total size - "+allSQLlinks.size());
				
		for (int index=0; index<allSQLlinks.size(); index++) {
			allSQLlinks.get(index).click();
			System.out.println(index +"-"+driver.getTitle());
			allSQLlinks = driver.findElements
					(By.xpath("//h2[contains(text(),'Database')]//preceding-sibling::a[contains(text(),'SQL')]"));
		}
		try {	
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver_win32_0_5060_134.exe /T");
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}