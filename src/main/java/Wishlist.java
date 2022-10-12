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
	     driver.findElement(By.xpath("//*[@id='amasty-shopby-product-list']/div[2]/ol/li[1]/div/div[1]/a/span/span/img")).click();
	     Thread.sleep(3000);
	     //click on heart icon
	     driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/a[1]")).click();
	     //click on user logo
	     driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/ul/li[2]")).click();
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
