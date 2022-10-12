import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRemoveProduct {

	WebDriver driver;
	@BeforeTest()
	public void login() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://preprod.zigly.com/shop/for-cats.html");
		 driver.manage().window().maximize();
	}
	@Test
	public void add_remove_item() throws Exception 
	{
		        //click on product
				List<WebElement> product=driver.findElements(By.xpath(
						"//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li[1]/div/div[3]/div/div/form/button"));
				for(int j=0; j<product.size(); j++) {
					product.get(0).click();
				}
				//click on cart logo
			        driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/div[2]/div[2]/a/img")).click();
			        Thread.sleep(2000);          
			        //add item using + 
			        driver.findElement(By.xpath("//div[@class='details-qty qty']/div/button[2]")).click();
			        Thread.sleep(2000);
			        //remove item using -
			        driver.findElement(By.xpath("//div[@class='details-qty qty']/div/button[1]")).click();
			        //click on checkout
			        driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
			        Thread.sleep(2000);
			        //add item after checkout
			        driver.findElement(By.xpath("//div[@class='control amtheme-qty-box custom-qty']/div[2]")).click();
			        Thread.sleep(2000);
			        //remove item aftercheckout//*[@id="empty_cart_button"]
			        driver.findElement(By.xpath("//div[@class='control amtheme-qty-box custom-qty']/div[1]")).click();
             		    
	}
}
