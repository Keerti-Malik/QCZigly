import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveCartItem {
	WebDriver driver;
	@BeforeTest()
	public void login() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://preprod.zigly.com/");
		 driver.manage().window().maximize();
	}
	@Test
	public void removeitem() throws Exception 
	{
		//click on dog image
				driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[1]")).click();
		        //click on product
				List<WebElement> product=driver.findElements(By.xpath(
						"//div[@class='products wrapper grid products-grid']/ol/li/div/div[3]/div"));
				for(int j=0; j<4; j++) {
					product.get(j).click();
				}
			     Thread.sleep(2000);
			
			     //click on cart logo
					    driver.findElement(By.xpath("//a[@class='action showcart']")).click();
			        Thread.sleep(2000);          
			        //delete item from cart
			        driver.findElement(By.xpath("//div[@class='product-item-details']/div/a[@class='action delete']")).click();
			        Thread.sleep(2000);
			        //click on popup
			       driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).click();
			        Thread.sleep(2000);
			        
			        //click on checkout
			        driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
			        //clear all item
                   driver.findElement(By.xpath("//div[@class='cart main actions']/div[2]/button")).click();	
                 WebElement we=  driver.findElement(By.className("cart-empty"));
                System.out.println(we.getText());
	}
}
