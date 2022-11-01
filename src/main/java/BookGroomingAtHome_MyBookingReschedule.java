import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookGroomingAtHome_MyBookingReschedule {
	WebDriver driver = null;
	JavascriptExecutor js = null;

	@Test(invocationCount = 1)
	public void navigatetourl() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='optInText']")).click();
		Thread.sleep(2000);
		Login.login(driver);
		// click on profile logo
		driver.findElement(By.xpath("//ul[@class='header-links']/li[2]")).click();
		// select Your Order
		List<WebElement> profilelist = driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
		for (int i = 0; i < profilelist.size(); i++) {
			if (profilelist.get(i).getText().contains("Your Orders")) {
				profilelist.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		// select particular order to reschedule
		List<WebElement> orderlist = driver
				.findElements(By.xpath("//div[@class='owl-item active']/li/div[2]/div[2]/a[1]"));
		for (int j = 0; j < orderlist.size(); j++) {// div[@class='owl-stage']/div/li/div/a/img
			orderlist.get(0).click();
			break;
		}
		Thread.sleep(3000);
		// click on location
		driver.findElement(By.xpath("//div[@class='cityscreen']/div/button/span")).click();
		// click on select city
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"location-modal\"]/div/span[3]/div")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("autosearch"))).sendKeys("201301");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath(
				"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
		list.get(0).click();
		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0,300)");
		Thread.sleep(2000);
		// select current date
		try {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate= formatter.format(date);
			System.out.println(strDate);
			Thread.sleep(2000);
		} catch (Exception e) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate= formatter.format(date);
			System.out.println(strDate);
			Thread.sleep(3000);
		}
		// select timeslot
		driver.findElement(By.xpath("//*[@id=\"grooming-timeslot\"]/ol/li[6]")).click();
		// click on save button
		js.executeScript("window.scrollTo(100,0)");
		driver.findElement(By.xpath("//div[@class='actions']/div/a[@id='submit-schedule']")).click();

	}
}
