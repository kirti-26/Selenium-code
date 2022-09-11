package com.excelr.seleniumlearning.t11_MouseKeyboardActions;

import java.awt.Robot;import java.awt.Toolkit;import java.awt.datatransfer.StringSelection;import java.awt.event.KeyEvent;
import java.time.Duration;import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;import org.openqa.selenium.interactions.Actions;

public class Mouse_RightClick_3DownArrows {
	
	public static void setClipBoardData(String string) {
		
		//StringSelection is a class that can be used to copy and paste operations
		
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		//getSystemClipboard() -enables data transfer between java programs and native applications which use native clipboard facilities
		//setContents() - sets the current content of the clipboard to the specified transferable object
	}
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://fb.com");
		
		Actions a = new Actions(driver);
		
		Action right_click = a.contextClick().build();			//right click - way 1 - line 1
		right_click.perform();									//right click - way 1 - line 2
		
		//a.contextClick().perform();							//right click - way 2
		
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);			
			
			System.out.println("File copied");
			setClipBoardData("D:\\Kirti\\ExcelR_OnlineCLasses\\Notes\\t11_MouseRightClick_SaveFile\\demo.html");
						
			//key strokes for CTRL, V and ENTER keys
			Robot p = new Robot();
			
			p.keyPress(KeyEvent.VK_CONTROL);
			p.keyPress(KeyEvent.VK_V);
			
			p.keyRelease(KeyEvent.VK_CONTROL);
			p.keyRelease(KeyEvent.VK_V);
			//Thread.sleep(3000);
			
			p.keyPress(KeyEvent.VK_ENTER);
			p.keyRelease(KeyEvent.VK_ENTER);
			//Thread.sleep(3000);
			
			System.out.println("File Saved");
		
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//driver.quit();			
		//quit is cancelled as the page is heavy and taking time to save
		//however, chrome was getting closed before saving the file
	}
}
