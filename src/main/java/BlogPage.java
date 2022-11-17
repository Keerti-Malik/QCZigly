import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BlogPage 
{
	@Test()
	public void blogpage() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 driver.get("https://preprod.zigly.com/");
		 driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
	    //click on Blog icon
	    List<WebElement> list= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/a"));
	    for(int i=0; i<list.size();i++) 
	    {//System.out.println(list.get(i).getText());
	    if (list.get(i).getText().contains("BLOG")) {
	    	
	    		list.get(i).click();
		   	break;
	    }
	   }
	    for (int i = 1; i <= 7; i++) 
	    {
	    	//click on all image per page
	    for (int j = 1; j<=12; j++)
	      {
	    	List<WebElement> list1= driver.findElements(By.xpath("//*[@id=\"mpblog-list-container\"]/div[1]/div["+j+"]/div/div[1]/a/img"));
	    	list1.get(0).click();
	    	driver.navigate().back();
	      }
	    // click on the next page
	    js.executeScript("window.scrollTo(0,40)");
	    Thread.sleep(3000);
	     driver.findElement(By.xpath("//nav[@class='pages']/a[@title='Next']")).click();
		}
	}  		
	}
