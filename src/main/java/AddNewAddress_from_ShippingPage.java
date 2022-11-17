import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddNewAddress_from_ShippingPage {

	@Test(invocationCount=1)
	public void NewAddress() throws InterruptedException
	// public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		searchByKey(driver, "M-Pets Twist Ball Toy 11 cm - yellow");
		// click on Add to Cart
		 Thread.sleep(2000);
		 js.executeScript("window.scrollTo(0,150)");
		driver.findElement(By.id("st-3051-atc")).click();
		Thread.sleep(2000);
		// click on cart logo
		driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[2]/div[2]/div[2]/a/img")).click();
		Thread.sleep(2000);
		// click on checkout
		driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
		try {
			driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
					.click();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
					.click();
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='chk-contct']/div[2]/a")).click();
		Thread.sleep(1000);
		Login.afterlogin(driver);
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,170)");
		Thread.sleep(2000);
		//click on New Address
		driver.findElement(By.xpath("//div[@class='new-address-popup']/button")).click();
		driver.findElement(By.name("street[0]")).sendKeys("Testing123");
		Select reigon = new Select(driver.findElement(By.name("region_id")));
		reigon.selectByVisibleText("Delhi");
		WebElement city=driver.findElement(By.name("city"));
		city.sendKeys("Delhi");
		WebElement zip=driver.findElement(By.name("postcode"));
		zip.clear();
		zip.sendKeys("110007");
		driver.findElement(By.xpath("//div[@class='amtheme-address-toolbar']/button[2]")).click();
		// click on Place Order
				Thread.sleep(2000);
				driver.findElement(By.id("shipping-method-buttons-container")).click();
				driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div[1]/button")).click();
				Thread.sleep(2000);
				
				js.executeScript("window.scrollTo(0,400)");
				WebElement button = driver
						.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label"));
				button.click();
				Thread.sleep(2000);
				// click on CashOnDelivery button
				driver.findElement(
						By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button")).click();
				// Click on pay
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[2]/div/div[3]/a[1]"))).click();
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
