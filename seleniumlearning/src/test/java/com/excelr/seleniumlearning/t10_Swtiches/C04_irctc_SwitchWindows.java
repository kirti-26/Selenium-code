package com.excelr.seleniumlearning.t10_Swtiches;

import java.time.Duration; import java.util.ArrayList; import java.util.List; import java.util.Set;
import org.openqa.selenium.By;import org.openqa.selenium.WebElement;import org.openqa.selenium.chrome.ChromeDriver;

public class C04_irctc_SwitchWindows {
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://www.irctc.co.in/nget/train-search");

		//open windows number will be displayed	
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("total windows - "+allWindows.size());
		System.out.println("page title -"+driver.getTitle());
		
		String xpath_ok = "//button[text()='OK']";
		WebElement ok = driver.findElement(By.xpath(xpath_ok));
		ok.click();
		
		String xpath_flight = "//li[@class='menu-list header-icon-menu']/a[normalize-space()='FLIGHTS']";
		WebElement flight = driver.findElement(By.xpath(xpath_flight));
		flight.click();
		
		//earlier there was a set of windows - now set is converted to list/array, because list/array has index
		//to display the open window size, you need to write the code again, or it will display the earlier result
		List<String> allWindowsList = new ArrayList<>(driver.getWindowHandles());
		System.out.println("All windows post flight click - "+allWindowsList.size());
		
		driver.switchTo().window(allWindowsList.get(1));
		System.out.println("index 1 window - "+driver.getTitle());
		driver.close();				//will close only window-1, browser is still running
		
		//even if one window is closed, result will be displayed as 2
		//if code is written again, then result will be displayed as 1
		Set<String> openWindows = driver.getWindowHandles();
		System.out.println("windows after closing window 1 - "+openWindows.size());
		
		driver.switchTo().window(allWindowsList.get(0));
		System.out.println("index 0 window - "+driver.getTitle());
		driver.close();				//will close window-0, browser is still running
							
		//even if both windows are closed, result will be displayed as 2
		//if code is written again, then result will be displayed as 0
		//Set<String> openWindowsList = driver.getWindowHandles();
		//System.out.println("All windows post flight click - "+openWindowsList.size());  
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
