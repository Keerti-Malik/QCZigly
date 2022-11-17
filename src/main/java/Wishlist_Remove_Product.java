import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wishlist_Remove_Product {

	WebDriver driver=null;

	@BeforeTest()
	public void login() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 Login.login(driver);
	}
	@Test
	 public void AddItemFromWishlist_To_Cart() throws Exception 
	{
		//click on user logo
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//ul[@class='header-links']/li[2]")).click();
	     Thread.sleep(3000);
			//select your orders
			List<WebElement> list= driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
		    for(int i=0; i<list.size();i++)
		    {
		    if (list.get(i).getText().contains("Wishlist")) {
		    		list.get(i).click();
			   	break;
		    }   	
		    }
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollTo(0,80)");
		    Thread.sleep(2000);
		    //click on product on blank space to view add to cart option
		    driver.findElement(By.xpath("//div[@class='box-tocart']/fieldset")).click();
		   
		    js.executeScript("window.scrollTo(0,50)");
		    Thread.sleep(2000);
		    //click on close button
		    driver.findElement(By.xpath("//div[@class='product-item-inner']/div[3]/fieldset/div[2]/div[1]/a")).click();
		    Thread.sleep(2000);
		    //Print Message after add product to cart
		
	        WebElement message=driver.findElement(By.xpath("//div[@class='message-success success message']"));
	        System.out.println("Message:-" +message.getText());
	}
}
