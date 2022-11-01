import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
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

public class BookGroomingAtHome_Reschedule {
	WebDriver driver = null;
	JavascriptExecutor js = null;

	@Test(invocationCount = 1)
	public void reschedulebooking() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Login.login(driver);
		Thread.sleep(2000);
		// click on profile logo
		driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[2]/ul/li[2]")).click();
		// select Your Order
		List<WebElement> profilelist = driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
		for (int i = 0; i < profilelist.size(); i++) {
			if (profilelist.get(i).getText().contains("Your Orders")) {
				profilelist.get(i).click();
				break;
			}
		}

		// select particular order to reschedule
		List<WebElement> orderlist = driver
				.findElements(By.xpath("//li[@class='upcoming-booking-list']/div/a"));
		Thread.sleep(1000);
		for (int k = 0; k < orderlist.size(); k++) {
			orderlist.get(0).click();
			break;
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,300)");
		// click on reschedule
		driver.findElement(By.xpath("//div[@class='booking-action']/a[1]")).click();
		Thread.sleep(1000);
		// click on location
		driver.findElement(By.xpath("//div[@class='cityscreen']/div/button/span")).click();
		// click on detect location
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='location-modal']/div/span[3]/div")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("autosearch"))).sendKeys("201301");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath(
				"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
		list.get(0).click();
		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0,200)");
		// select current date
		// driver.findElement(By.xpath("//div[@class='fc-daygrid-body
		// fc-daygrid-body-unbalanced ']/table/tbody/tr[4]/td[@class='fc-daygrid-day
		// fc-day fc-day-fri fc-day-today ']")).click();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		Thread.sleep(2000);

		// select timeslot
		driver.findElement(By.xpath("//div[@id='grooming-timeslot']/ol/li[4]")).click();
		js.executeScript("window.scrollTo(150,0)");
		Thread.sleep(2000);
		// click on save button
		driver.findElement(By.xpath("//div[@class='actions']/div/a[@id='submit-schedule']")).click();

	}
}
