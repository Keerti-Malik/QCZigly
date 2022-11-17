import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WriteReview_OnOrder {
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
	    //click on view order details
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/ul/li[1]/div[2]/table/tbody/tr[1]/td[5]/div/p[1]/a")).click(); 
	   //click on write review
	    driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[3]/dl/dd/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("amreview-toform")).click();
	    //select feedback start
	    driver.findElement(By.xpath("//*[@id=\"Feedback_1_label\"]")).click();
	    //write inside order summary
	    driver.findElement(By.id("summary_field")).sendKeys("ok");
	    //write review
	    WebElement upload=driver.findElement(By.id("review_field"));
	    upload.sendKeys("ok");
	    Thread.sleep(2000);
	    WebElement chooseFile = driver.findElement(By.xpath("//*[@id='review-form']/fieldset/div[4]/div/input"));
	    js.executeScript("arguments[0].click();", chooseFile);
		Robot rb = new Robot();
		rb.setAutoDelay(4000);
		StringSelection ss = new StringSelection("E:\\a1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	    //click on Send Review button
		 WebElement send = driver.findElement(By.xpath("//div[@class='review-form-actions']/button"));
		    js.executeScript("arguments[0].click();",send);
	   WebElement we= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/div"));
	  System.out.println(we.getText());

	}
}
