import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchFunctionality {

	WebDriver driver;
	@BeforeTest()
	public void login() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://preprod.zigly.com");
		 driver.manage().window().maximize();
	}
	@Test(priority=0)
	public void search_from_search_box() throws Exception 
	{
		    WebElement search= driver.findElement(By.id("search"));
		    search.sendKeys("abc");
		    search.sendKeys(Keys.ENTER);
		    
		   WebElement message= driver.findElement(By.xpath("//div[@class='st-no-results-msg']"));
		   if(message.equals("Sorry, we couldn't find any results") ) 
		   {
			   System.out.println(message.getText());
		   }
		   
		    
		     
             		    
	}
	@Test(priority=1)
	public void search() throws Exception 
	{
		    WebElement search= driver.findElement(By.id("search"));
		    search.sendKeys("cat");
		    Thread.sleep(2000);
		    List<WebElement> selectitem= driver.findElements(By.xpath("//div[@class='st-column-70 st-right-panel']/div/div/div/div/div/div"));
		   for(int i=0; i<selectitem.size(); i++)
		   {
			   Thread.sleep(2000);
			   selectitem.get(0).click();
			   break;
		   }
             		    
	}
	@Test(priority=2)
	public void search_by_below_given_options() throws Exception 
	{
		    WebElement search= driver.findElement(By.id("search"));
		    search.click();
		   List<WebElement> selectitem= driver.findElements(By.xpath("//ul[@class='st-trending-list']/li"));
		   for(int i=0; i<selectitem.size(); i++)
		   {
			   selectitem.get(1).click();
			   break;
		   }
             		    
	}
}
