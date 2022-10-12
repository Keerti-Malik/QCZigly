import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Grooming_EC_Wallet {
	WebDriver driver;

	@Test()
	public void Home_experiencecentre() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://preprod.zigly.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[3]/div[1]/ul/li[1]/a")).click();
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[3]/div[1]/ul/li[1]/div/ul/li[3]/a")));
		button.click();
		driver.findElement(By.xpath("//div[@class='steps-appoinment   btn-book-tab']/button")).click();
		login();
		bookingEC();
	}

	public void login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.findElement(By.id("social_login_email")).sendKeys("9759436633");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='bnt-auth-mobile']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(2000);
		// click on detect location
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"location-modal\"]/div/span[3]/div")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("autosearch"))).sendKeys("201301");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath(
				"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
		list.get(0).click();
		Thread.sleep(2000);
	}

	public void bookingEC() throws Exception {
		// Select Pet
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='manage-pets']/li/div[3]/button")))
				.click();
		Thread.sleep(2000);
		// select plan
		List<WebElement> list1 = driver
				.findElements(By.xpath("//div[@class='plans-grid']/div/div/div[6]/button[@id='plan-select-defined']"));
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
			list1.get(0).click();
			break;
		}
		// select timeslot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,100)");
		// select current date
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
				Date today = Calendar.getInstance().getTime();
				String date = dateFormat.format(today);
				Thread.sleep(2000);
		// Select time
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grooming-timeslot\"]/ol/li[15]")))
				.click();
		// click on next
		driver.findElement(By.xpath("//*[@id=\"time-proceed-73\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"groomer-service\"]/fieldset[4]/div[1]/ul/li")).click();

		// select address

		driver.findElement(By.xpath("//div[@class='action-address']/button[1]")).click();
		Thread.sleep(2000);

		// click on wallet
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='wallet selection']/fieldset/label")))
				.click();
		Thread.sleep(2000);
		// click on Make Payment
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='booking-payment']/button"))).click();
		Thread.sleep(2000);
		// move to payment page
		driver.switchTo().frame(1);
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0,100)");
		// click on netbanking
		driver.findElement(By.xpath("//div[@class='methods-block']/div/button[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='bank-item-UTIB']")).click();
		js.executeScript("window.scrollTo(0,100)");
		Thread.sleep(2000);
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Window" + parentHandle);
		Thread.sleep(3000);
		// click on pay amount
		driver.findElement(By.id("footer")).click();
		Thread.sleep(4000);
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			// System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				String a = driver.getTitle();
				System.out.print(a);
				driver.findElement(By.xpath("/html/body/form/button[1]")).click();

			}
		}

	}
}
