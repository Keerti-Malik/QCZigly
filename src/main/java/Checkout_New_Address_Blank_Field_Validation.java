import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkout_New_Address_Blank_Field_Validation {
	WebDriver driver;

	@BeforeTest()
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);

		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	@Test()
	public void searchwithfilters() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// click on Dog
		WebElement selectproduct = driver.findElement(By.id("search"));
		selectproduct.sendKeys("beboji Charlie Sheen Dog Shirt");
		selectproduct.sendKeys(Keys.ENTER);
		// Click on Addtocart
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='st-inner-box']/div[4]/button")).click();
		// Select Size
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='swatch-option text']"))).click();
		Thread.sleep(2000);
		// Click on Add to Cart
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);
		// click on cart logo
		driver.findElement(By.xpath("//div[@class='minicart-wrapper amtheme-header-icon']/a")).click();
		Thread.sleep(2000);
		// click on checkout
		driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
		Thread.sleep(3000);
		// click on Place Order
		try {
			driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
					.click();
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
					.click();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,150)");
		Thread.sleep(3000);
		// Enter Pin code
		driver.findElement(By.xpath("//div[@class='control']/input[@name='postcode']")).sendKeys("110071");
		// Enter city
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='control']/input[@name='city']")))
				.sendKeys("");
		Thread.sleep(4000);
		// click on place order
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
		// phn msg validation
		String phnmsg = driver.findElement(By.xpath("//div[@class='mage-error'][@id='mobile-error'][1]")).getText();
		if (phnmsg != null && phnmsg.length() > 0) {
			System.out.println(" Mobile field - " + phnmsg);
		}

		Thread.sleep(3000);
		// Enter phn no.
		driver.findElement(By.name("mobilenumber")).sendKeys("9456230991");
		// click on place order
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
		// first name validation
		String namemsg = driver.findElement(By.xpath("//div[@class='field-error']")).getText();
		if (namemsg != null && namemsg.length() > 0) {
			System.out.println(" Firstname - " + namemsg);
		}
		String street = driver.findElement(By.xpath("//div[@class='field-error']")).getText();
		if (street != null && street.length() > 0) {
			System.out.println(" Street - " + street);
		}
		String region = driver.findElement(By.xpath("//div[@class='field-error']")).getText();
		if (region != null && region.length() > 0) {
			System.out.println(" Region - " + region);
		}
		String city = driver.findElement(By.xpath("//div[@class='field-error']")).getText();
		if (city != null && city.length() > 0) {
			System.out.println(" City - " + city);
		}
		String email = driver.findElement(By.xpath("//div[@class='field-error']")).getText();
		if (email != null && email.length() > 0) {
			System.out.println(" Email - " + email);
		}
	}

}
