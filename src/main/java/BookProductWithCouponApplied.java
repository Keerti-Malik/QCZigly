import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//Flow--- Select Product->Apply Filter-> apply coupon code-> place order with razorpay

public class BookProductWithCouponApplied {
	@Test()
	public void searchwithfilters() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Login.login(driver);
		// click on home page 'DOG'
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='static-cards']/div[1]")).click();
		// filter category
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ol[contains(@class,'items am-filter')]//form//li//a"));
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("DOG TREATS")) {
				list.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
		// filter food type
		driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[1]")).click();
		List<WebElement> list2 = driver.findElements(By.xpath("//ol[contains(@class,'items am-filter')]//form//li//a"));
		// System.out.println(list2.size());
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getText().contains("Veg")) {
				list2.get(i).click();
				break;
			}
		}
		// Filter price
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[1]")).click();
		Thread.sleep(2000);
		WebElement slider = driver.findElement(By.xpath("//div[contains(@class, \"am-slider ui-slider\")]/a[1]"));
		Actions action1 = new Actions(driver);
		action1.dragAndDropBy(slider, 60, 0).clickAndHold().perform();

		js.executeScript("window.scrollTo(0,300)");
		Thread.sleep(3000);
		// click on cart logo
		driver.findElement(By.xpath("//div[@class='minicart-wrapper amtheme-header-icon']/a")).click();
		Thread.sleep(2000);
		// click on checkout
		driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
		// cancle coupon code
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@id=\"discount-coupon-form\"]/div/div[2]/div/button")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//*[@id=\"discount-coupon-form\"]/div/div[2]/div/button")).click();
		}
		// Add coupon code
		WebElement coupon = driver.findElement(By.id("coupon_code"));
		coupon.sendKeys("ZiglyTest100");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"discount-coupon-form\"]/div/div[2]/div/button")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.className("messages")).getText());
		// click on place order
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
					.click();
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
					.click();
		}
		Thread.sleep(4000);
		// Select address
		List<WebElement> address = driver
				.findElements(By.xpath("//div[@class='shipping-address-items']/div/div/button"));
		for (int i = 0; i < address.size(); i++) {
			address.get(0).click();
		}
		// click on PLACE button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
		Thread.sleep(3000);
		// click on pay with razor pay
		driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action primary checkout']"))
				.click();
		Thread.sleep(4000);
		// move to payment page
		driver.switchTo().frame(0);
		// click on netbanking
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='methods-block']/div/button[3]/div"))).click();
		
		// select bank
		driver.findElement(By.id("bank-item-UTIB")).click();
		Thread.sleep(2000);
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Window" + parentHandle);
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