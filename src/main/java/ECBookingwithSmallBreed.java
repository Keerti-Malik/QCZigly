import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ECBookingwithSmallBreed {

	WebDriver driver;

	@Test()
	public void experiencecentrebooking() throws Exception {
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
		bookEC();
	}

	public void login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.findElement(By.id("social_login_email")).sendKeys("9759436633");
		driver.findElement(By.xpath("//div[@id='bnt-auth-mobile']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(3000);
		// click on detect location
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='detect_location']"))).click();

	}

	public void bookEC() throws Exception {
		Thread.sleep(2000);
		// Select Pet
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='manage-pets']/li/div[3]/button"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

			list.get(0).click();
			break;
		}
		Thread.sleep(2000);
		// select plan
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");

		List<WebElement> list1 = driver
				.findElements(By.xpath("//div[@class='plans-grid']/div/div/div[6]/button[@id='plan-select-defined']"));
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
			list1.get(0).click();
			break;
		}

		// select timeslot
		js.executeScript("window.scrollTo(0,100)");
		// select date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"grooming-calendar-slot\"]/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[3]/td[4]/div/div[1]")))
				.click();
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

		// click on paylater
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"groomer-service\"]/fieldset[5]/div/div/div/div/div[2]/div[2]/div[6]/fieldset[2]/label")))
				.click();
		// click on Make Payment
		driver.findElement(By.xpath("//*[@id=\"groomer-service\"]/fieldset[5]/div/div/div/div/div[2]/div[2]/button"))
				.click();

	}
}
