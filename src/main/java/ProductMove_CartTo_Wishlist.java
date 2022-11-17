import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProductMove_CartTo_Wishlist {

	@Test()
	public void moveto_wishlist() throws InterruptedException
	// public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Login.login(driver);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		searchByKey(driver, "GiGwi Shinning Friends Firefly With LED Light & Catnip Cat Toy");
		// click on Add to Cart
		 Thread.sleep(2000);
		 js.executeScript("window.scrollTo(0,150)");
		driver.findElement(By.xpath("//div[@class='st-action-button']")).click();
		Thread.sleep(2000);
		// click on cart logo
		driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[2]/div[2]/div[2]/a/img")).click();
		Thread.sleep(2000);
		//click on product which is inside cart
		List<WebElement> select= driver.findElements(By.xpath("//div[@class='product']/div[2]/strong/a"));
		for(int i=0; i<select.size();i++) {
		select.get(0).click();
		break;
	}
		//click on heart icon
	     driver.findElement(By.xpath("//div[@class=\"amtheme-product-wrap\"]/div/a[@class='action towishlist']")).click();
	     Thread.sleep(2000);
		    //Print Message after add product to cart
		
	        WebElement message=driver.findElement(By.xpath("//div[@class='message-success success message']"));
	        System.out.println("Message:-" +message.getText());
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
