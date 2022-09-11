package com.excelr.seleniumlearning.t09_w3schools_ClickLinks;
import java.awt.Robot; import java.awt.event.KeyEvent; import java.time.Duration; import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuitWindow_JavaCode {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://fb.com");

		try {								//Robot class is used in java to close window
			Robot r = new Robot();			//keyPress() is a method to press key
			r.keyPress(KeyEvent.VK_ALT); 	//Keyevent - indicates that keystroke has occurred
			Thread.sleep(500);				//wait for 5 milliseconds for next keystroke
			r.keyPress(KeyEvent.VK_F4); 	//ALT + F4 - closes the window
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_ALT);	//release key once it is pressed
			r.keyRelease(KeyEvent.VK_F4);
			
			//path from command prompt to kill the process and delete .exe file from task manager
			//runtime() is a class & exec() is a method to quit window in java
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}