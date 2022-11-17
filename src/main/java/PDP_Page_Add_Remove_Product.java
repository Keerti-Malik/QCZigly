import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PDP_Page_Add_Remove_Product {

	 WebDriver driver;
		@BeforeTest()
		public void login() throws Exception
		{
			 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
			 driver=new ChromeDriver();
			 String baseUrl = "https://preprod.zigly.com/";
				driver.get(baseUrl);
				driver.manage().window().maximize();
				Thread.sleep(2000);

		}
		@Test()
		 public void add_removeProduct() throws Exception 
		{
			//search product
			WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]"));
			element.sendKeys("M-Pets Twist Ball Toy 11 cm - yellow");
			element.sendKeys(Keys.ENTER);
			//click on product
			driver.findElement(By.xpath("//div[@class='st-link st-image-wrapper']")).click();
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath("//div[@class='control amtheme-qty-box']/div[2]")); 
			act.doubleClick(ele).perform();
			Thread.sleep(2000);
			WebElement ele2 = driver.findElement(By.xpath("//div[@class='control amtheme-qty-box']/div[1]")); 
			act.doubleClick(ele2).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
		}
}
