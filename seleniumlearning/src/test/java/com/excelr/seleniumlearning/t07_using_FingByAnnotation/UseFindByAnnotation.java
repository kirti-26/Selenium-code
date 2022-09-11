package com.excelr.seleniumlearning.t07_using_FingByAnnotation;

import java.time.Duration; import java.util.List; import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How; import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UseFindByAnnotation {

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Create New Account']")
	private WebElement createnewacc;

	@FindBy(how = How.ID, using = "day")
	private WebElement dayDrop;

	@FindBy(how = How.CSS, using = "select[id='month']>option")
	private List<WebElement> monthDrop;

	@FindBy(css = "select[id='year']>option")
	private List<WebElement> yearDrop;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Kirti\\ExcelR_OnlineCLasses\\Tools\\BrowserExes\\chromedriver_win32_0_5060_134.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://fb.com");

		// UseFindByAnnotation ufba = new UseFindByAnnotation();
		// above statement will create an object but it can't be used.
		// in selenium, to use the elements created using FindByAnnotation, we need to
		// use initialize all the elements using PageFactroy class - as shown below

		UseFindByAnnotation ufba = PageFactory.initElements(driver, UseFindByAnnotation.class);

		ufba.createnewacc.click();

		// using select
		Select daySelect = new Select(ufba.dayDrop);
		daySelect.selectByIndex(25);

		// using for loop
		for (WebElement eachMonth : ufba.monthDrop) {
			if (eachMonth.getText().equalsIgnoreCase("Aug")) {
				eachMonth.click();
				break;
			}
		}

		ufba.yearDrop.parallelStream().filter(eachYear -> eachYear.getText().equals("1989")).findFirst().get().click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
