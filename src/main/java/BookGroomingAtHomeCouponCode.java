import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class BookGroomingAtHomeCouponCode {
	WebDriver driver = null;
	JavascriptExecutor js = null;

	@Test(invocationCount = 1)
	public void navigatetourl() throws InterruptedException {
		try {

			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js = (JavascriptExecutor) driver;
			String baseUrl = "https://qc.zigly.com/";
			driver.get(baseUrl);
			Thread.sleep(2000);
			driver.manage().window().maximize();

			driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[3]/div[1]/ul/li[1]/a")).click();
			WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[3]/div[1]/ul/li[1]/div/ul/li[1]")));
			button.click();
			js.executeScript("window.scrollTo(0,90)");
			driver.findElement(By.xpath("//div[@class='steps-appoinment  btn-book-tab']")).click();

			Thread.sleep(3000);
			login();
			selectPet();
			selectPlan();
			selectTimeSlot();
			selectAddress();
			selectCouponcode();
			makePayment();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void login() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.id("social_login_email")).sendKeys("9759436633");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='bnt-auth-mobile']")).click();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(3000);
		// click on detect location
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

	// Select Pet
	public void selectPet() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='manage-pets']/li/div[3]/button[1]")))
				.click();
		Thread.sleep(2000);
	}

	// select plan
	public void selectPlan() {
		List<WebElement> list1 = driver
				.findElements(By.xpath("//div[@class='plans-grid']/div/div/div[6]/button[@id='plan-select-defined']"));
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
			list1.get(0).click();
			break;
		}
	}

	// select timeslot
	public void selectTimeSlot() throws InterruptedException {
		js.executeScript("window.scrollTo(0,100)");
		// select current date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		Thread.sleep(2000);
		// Select time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grooming-timeslot\"]/ol/li[1]")))
				.click();// *[@id="grooming-timeslot"]/ol/li[3]
		driver.findElement(By.xpath("//*[@id=\"time-proceed-73\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"groomer-service\"]/fieldset[4]/div[1]/ul/li")).click();
	}

	// select address
	public void selectAddress() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='action-address']/button[1]")).click();
		Thread.sleep(2000);
	}

	// add coupon code
	public void selectCouponcode() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.className("coupon-input"))).sendKeys("ZiglyTest500");
		driver.findElement(By.id("apply-coupon")).click();
		Thread.sleep(2000);
	}
	// Make Payment
		public void makePayment() throws InterruptedException {
			driver.findElement(By.xpath(
					"//*[@id=\"groomer-service\"]/fieldset[5]/div/div/div/div/div[2]/div[2]/div[6]/fieldset[2]/label"))
					.click();
			driver.findElement(By.xpath("//*[@id=\"groomer-service\"]/fieldset[5]/div/div/div/div/div[2]/div[2]/button"))
					.click();
		}
	
}
