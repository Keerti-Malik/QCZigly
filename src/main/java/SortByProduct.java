import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SortByProduct {
 
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
	 public void sortitem() throws Exception 
	{
		//click on dog image
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[1]")).click();
		//click on product
		for(int i=0; i<=4; i++) 
	   {
	    driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[1]/div/div[3]/div[2]/span")).click();
	    Thread.sleep(2000);
	   List<WebElement> sort= driver.findElements(By.xpath("//*[@id='amasty-shopby-product-list']/div[1]/div/div[3]/div[2]/ul/li"));
	    System.out.println(sort.get(i).getText());
	    sort.get(i).click();
	 //   JavascriptExecutor js= (JavascriptExecutor)driver;
		//   js.executeScript("window.scrollTo(0,150)");
		    Thread.sleep(3000);
	   }
		
		
	}
  }
