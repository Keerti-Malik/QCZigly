import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CartEmptyValidationAfterBooking {

	@Test
	public void emptyCartValidation() throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Login.login(driver);

			// click on cat
			try {
				List<WebElement> catImage = driver.findElements(By.xpath("//div[@class='static-cards']/div/a/img"));
				for (int i = 0; i < catImage.size(); i++) {
					catImage.get(1).click();
					break;
				}
			} catch (StaleElementReferenceException ex) {
				System.out.println(ex.toString());
			}
			Thread.sleep(2000);
			// click on first cat food image
			try {
				List<WebElement> catItem = driver
						.findElements(By.xpath("//div[@id='amasty-shopby-product-list']/div/ol/li/div/div/a/span"));
				for (int j = 0; j < catItem.size(); j++) {

					catItem.get(0).click();
	                   break;
				}
			} catch (StaleElementReferenceException ex) {
				System.out.println(ex.toString());
			}
			Thread.sleep(2000);
			// click on quick buy
			driver.findElement(By.xpath("//div[@class='sparsh-buynow-view']/button")).click();
			Thread.sleep(2000);
			// click on cart logo
			driver.findElement(By.xpath("//*[@class='checkout methods items checkout-methods-items']/li[1]")).click();
			Thread.sleep(2000);
			// select address
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"checkout-step-shipping\"]/div[1]/div/div/div[1]/div[1]/button"))).click();
			// click on Place Order
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div[1]/button")).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,400)");
			//select cash on delivery
			WebElement button = driver
					.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label"));
			button.click();
			Thread.sleep(2000);
			// click on Place Order
			driver.findElement(
					By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button")).click();
			Thread.sleep(2000);
			// click on cart logo
						driver.findElement(By.xpath("//div[@class='amtheme-icons-container']/div[2]/a")).click();
						//Thread.sleep(2000);
						WebElement cart=driver.findElement(By.xpath("//div[@class='cart-empty']/p[1]"));
						System.out.println(cart.getText());
	}
}
