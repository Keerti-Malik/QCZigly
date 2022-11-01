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
						"//div[@class='products wrapper grid products-grid']/ol/li/div/div/a"));
				for(int j=0; j<product.size(); j++) {
					product.get(0).click();
					break;
				}
			     //Select Size
				 List<WebElement> size= driver.findElements(By.xpath("//div[@class='swatch-option text']"));
				 if (size.size() > 0 && size.get(0).getText().equalsIgnoreCase("L")) {
					 size.get(0).click();
						Thread.sleep(2000);
				 }
				// Click on Add to Cart
				    driver.findElement(By.id("product-addtocart-button")).click();
				    Thread.sleep(2000);
				    driver.navigate().back();
				    List<WebElement> productlist=driver.findElements(By.xpath(
							"//div[@class='products wrapper grid products-grid']/ol/li/div/div/a"));
					for(int k=0; k<productlist.size(); k++) {
						productlist.get(1).click();
						break;
					}
					// Click on Add to Cart
					    driver.findElement(By.id("product-addtocart-button")).click();
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
