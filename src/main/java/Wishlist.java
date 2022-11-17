import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wishlist {

WebDriver driver;
	
	@BeforeTest()
	public void login() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 Login.login(driver);
	}
	@Test
	 public void additemtowishlist() throws Exception 
	{
		//click on dog image
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[1]")).click();
        //click on product
		driver.findElement(By.xpath("//ol[@class='products list items product-items -col-xl-3 -col-sm-1 -amtheme-buttons-hover  -amtheme-swatches-hover']/li/div/div[1]")).click();
	     Thread.sleep(4000);
	     //click on heart icon
	     driver.findElement(By.xpath("//div[@class=\"amtheme-product-wrap\"]/div/a[@class='action towishlist']")).click();
	     Thread.sleep(1000);
	     WebElement message=driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div"));
	     System.out.println("Message:-" +message.getText());
	     //click on user logo
	     Thread.sleep(2000);
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
   }
}
