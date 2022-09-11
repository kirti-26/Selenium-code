package com.excelr.seleniumlearning.t09_w3schools_ClickLinks;

import java.time.Duration;import org.openqa.selenium.support.FindBy;import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement; import org.openqa.selenium.chrome.ChromeDriver;import java.util.List; 

public class ClickLinks_FindBy {

	@FindBy(xpath="//h2[contains(text(),'Database')]//preceding-sibling::a[contains(text(),'SQL')]")
	private List<WebElement> allSQL;
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://www.w3schools.com/sql/default.asp");

		ClickLinks_FindBy by = PageFactory.initElements(driver, ClickLinks_FindBy.class);
		
		System.out.println("total links - "+by.allSQL.size());
				
		for (int index=0; index<by.allSQL.size(); index++) {
			by.allSQL.get(index).click();
			System.out.println(index +"-"+driver.getTitle());
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