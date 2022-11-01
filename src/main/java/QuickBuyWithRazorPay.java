
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class QuickBuyWithRazorPay {

	@Test()
	public void quickBuyWithRazorpay() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Login.login(driver);
		// click on cat image
		driver.findElement(By.xpath("//div[@class='static-cards']/div[2]/a[2]")).click();
		// click on add to cart
		driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li[1]/div/div[1]/a/span/span"))
				.click();
		Thread.sleep(2000);
		// click on above cart logo
		driver.findElement(By.xpath("//div[@class='sparsh-buynow-view']/button")).click();
		Thread.sleep(2000);
		// click on checkout
		driver.findElement(By.xpath("//a[@class='action primary checkout']")).click();
		Thread.sleep(4000);
		// select address
		driver.findElement(By.xpath("//*[@id=\"checkout-step-shipping\"]/div[1]/div/div/div[1]/div[1]/button")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		// click on Place Order
		Thread.sleep(4000);
		driver.findElement(By.id("shipping-method-buttons-container")).click();
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div[1]/button")).click();
		Thread.sleep(2000);
		// click on Razor Pay
		driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action primary checkout']"))
				.click();
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