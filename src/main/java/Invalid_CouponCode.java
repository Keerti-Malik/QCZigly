import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Invalid_CouponCode {

	@Test()
	public void InvalidCouponCode() throws InterruptedException
	// public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		searchByKey(driver, "M-Pets Twist Ball Toy 11 cm - yellow");
		// click on Add to Cart
		 Thread.sleep(2000);
		 js.executeScript("window.scrollTo(0,200)");
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='st-action-button']")).click();
		Thread.sleep(2000);
		// click on cart logo
		driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[2]/div[2]/div[2]/a/img")).click();
		Thread.sleep(2000);
		// click on checkout
		driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
		Thread.sleep(2000);
		// Add coupon code
				WebElement coupon = driver.findElement(By.id("coupon_code"));
				coupon.sendKeys("ZiglyTest100");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"discount-coupon-form\"]/div/div[2]/div/button")).click();
				Thread.sleep(2000);
				System.out.println("Message-"+driver.findElement(By.className("messages")).getText());
	}
	private static void searchByKey(WebDriver driver, String searchKey) throws InterruptedException {
		try {
			WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]"));
			element.sendKeys(searchKey);
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println(e);
			WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]"));
			element.sendKeys(searchKey);
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
		}
	}
}
