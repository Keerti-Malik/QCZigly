import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//COD with Cancel Order
public class QuickbuyWithCOD_CancleOrder {

	@Test()
	public void quickBuywithCOD() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Login.login(driver);
		// click on cat [Use below hide code if stale exception comes]
		// driver.findElement(By.cssSelector(".pet-card:nth-child(2) img")).click();
		// click on cat food
		// driver.findElement(By.cssSelector(".item:nth-child(1) > .product-item-info
		// .product-image-photo")).click();

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
		driver.findElement(By.id("shipping-method-buttons-container")).click();
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div[1]/button")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,400)");
		WebElement button = driver
				.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label"));
		button.click();
		Thread.sleep(2000);
		// click on CashOnDelivery button
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button")).click();
		// Click on pay
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[2]/div/div[3]/a[1]"))).click();
		Thread.sleep(2000);
		// click on cancel button
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[1]/div[4]/button")).click();
		Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='reason']")));
		objSelect.selectByIndex(2);
		driver.findElement(By.xpath("//button[@class='action primary order-cancel-reason']/span")).click();
	}
}
