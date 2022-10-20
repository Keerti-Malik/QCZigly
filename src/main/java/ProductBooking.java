
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProductBooking {

	@Test()
	public void run() throws InterruptedException
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
		// Thread.sleep(2000);
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
		driver.findElement(By.xpath("//*[@id=\"chk-contct\"]/div[2]/a")).click();
		Login.afterlogin(driver);
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,100)");
		Thread.sleep(2000);
		// select address
		List<WebElement> addresses = driver
				.findElements(By.xpath("//div[@class='shipping-address-items']/div/div/button"));
		for (int j = 0; j < addresses.size(); j++) {
			addresses.get(0).click();
		}
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,200)");
		// click on place order
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(2000);
		// click on pay with razor pay
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
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