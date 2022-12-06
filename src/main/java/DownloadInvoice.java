import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadInvoice {

WebDriver driver;
	
	@BeforeTest()
	public void login() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		Login.login(driver);
	}
	@Test
	 public void writeReview() throws Exception 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//go to on profile logo
		driver.findElement(By.xpath("//ul[@class='header-links']/li[2]")).click();
		//select your orders
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
	    for(int i=0; i<list.size();i++) 
	    {
	    if (list.get(i).getText().contains("Your Orders")) {
	    		list.get(i).click();
		   	break;
	    }   	
	    }
	    //click on product purchase
	    driver.findElement(By.className("order-purchase")).click();
	    //click on Download Invoice
        List<WebElement> invoice=driver.findElements(By.xpath("//div[@class='product-options']/p[2]/a"));
        invoice.get(0).click();
	}
}
