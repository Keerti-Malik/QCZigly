import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MobileView {
	

	@Test(invocationCount = 10)
	public void searchwithfilters() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Login.login(driver);
		driver.manage().window().maximize();
		// click on SHOP from HomePage
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='page-nav-section']//div[2]/div/div/nav/ul")).click();
		Thread.sleep(4000);
		// Select dog item
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[contains(@class,'level2 submenu ui-menu ui-widget')]//li//a"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains("Chew Toys")) {
				list.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		// Select filter FoodType
		 driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]")).click();

		List<WebElement> list2 = driver.findElements(By.xpath("//ol[contains(@class,'items am-filter')]//form//li//a"));
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getText().contains("Simple")) {
				list2.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		// Select Filter Lifestage
		driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[1]")).click();
		List<WebElement> list3 = driver.findElements(By.xpath("//ol[contains(@class,'items am-filter')]//form//li//a"));
		for (int i = 0; i < list3.size(); i++) {
			if (list3.get(i).getText().contains("Puppy")) {
				list3.get(i).click();
				break;
			}
		}

		js.executeScript("window.scrollTo(0,500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class, 'action tocart primary -left')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'amtheme-icons-container')]")).click();
		Thread.sleep(2000);
		// click on checkout
		try {
			driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
		} catch (Exception e) {
			System.out.println(e);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
		}
		// click on place order
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//ul[contains(@class,'checkout methods items')]/li[1]")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[contains(@class,'checkout methods items')]/li[1]")).click();
		}
		Thread.sleep(3000);
		// Select address
		driver.findElement(By.xpath("//*[@id=\"checkout-step-shipping\"]/div[1]/div/div/div[1]/div[1]/button")).click();
		// click on Place Order
		Thread.sleep(2000);
		driver.findElement(By.id("shipping-method-buttons-container")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(3000);
		// click on discount block
		driver.findElement(By.id("block-discount-heading")).click();
		// cancel coupon
		Thread.sleep(2000);
		List<WebElement> we = driver.findElements(By.xpath("//form[@class='form form-discount']/div[2]/div/button"));
		// String s=we.getText();
		if (we.size() > 0 && we.get(0).getText().equalsIgnoreCase("CANCEL COUPON")) {
			we.get(0).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.id("discount-code")).sendKeys("ZiglyTest500");
		Thread.sleep(1000);
		// click on apply
		driver.findElement(By.xpath("//*[@id=\"discount-form\"]/div[2]/div/button")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(200,0)");
		// click on paymentwithRazorPay
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action
		// primary checkout']"))).click();
		WebElement l1 = driver
				.findElement(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action primary checkout']"));
		try {
			l1.click();
		} catch (Exception e) {
			Thread.sleep(2000);
			l1 = driver.findElement(
					By.xpath("//div[@class='actions-toolbar']/div/button[@class='action primary checkout']"));
			l1.click();
		}

		Thread.sleep(4000);
		//move to payment page
	     driver.switchTo().frame(1);
	     Thread.sleep(2000);
	     //select payment mode
	     driver.findElement(By.xpath("//div[@class='methods-block']/div/button[3]/div/div")).click();
	     //Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[@id='bank-item-UTIB']")).click();
	     Thread.sleep(2000);
	    String parentHandle= driver.getWindowHandle();
	     System.out.println("Parent Window"+parentHandle);
	     js.executeScript("window.scrollTo(0,100)");
	     driver.findElement(By.xpath("//button[@id='redesign-v15-cta']")).click();
	     Thread.sleep(4000);
	     Set<String> handles= driver.getWindowHandles();
	     for(String handle:handles) {
	    	 System.out.println(handle);
	    	 if(!handle.equals(parentHandle)) {
	    		 driver.switchTo().window(handle);
	    		 String a=driver.getTitle();
	    		 System.out.print(a);
	    		 driver.findElement(By.xpath("/html/body/form/button[1]")).click();	
	    	 }
		}

	}

	
}
