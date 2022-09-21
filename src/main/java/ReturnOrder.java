import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReturnOrder {
	
	WebDriver driver;
	
	@BeforeTest()
	public void login() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		Login.login(driver);
	}
	@Test
	 public void navigateToYourOrder() throws Exception 
	{
		//go to on profile logo
		driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/ul/li[2]")).click();
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
	    //select fedback start
	    driver.findElement(By.xpath("//*[@id=\"Feedback_5_label\"]")).click();
	    //write inside order summary
	    driver.findElement(By.id("summary_field")).sendKeys("Good product");
	    //write review
	    driver.findElement(By.id("review_field")).sendKeys("Good Quality Product");
	    Thread.sleep(1000);
	    //click on Send Review button
	    driver.findElement(By.xpath("//div[@class='review-form-actions']/button")).click();
	   WebElement we= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/div"));
	  System.out.println(we.getText());
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	    //click on return button
	   WebElement we1=driver.findElement(By.xpath("//div[@class='order-details-items ordered']/div/div[4]"));
	    String s= we1.getText();
	    if(s.equals("RETURN")) {	
	    we1.click();
	    //System.out.println(we.getText());
	    //Select reason for return
	    Select reason= new Select(driver.findElement(By.id("return")));
	    reason.selectByIndex(3);
	    //add return comment
	    driver.findElement(By.id("returns")).sendKeys("I want to return this order.");
	    //click on submit
	    driver.findElement(By.xpath("//button[@class='action primary order-return-reason']/span")).click();
	    //print submssion message
	   WebElement webe= driver.findElement(By.xpath("//div[@class='messages']/div/div"));
	  System.out.println(webe.getText());
	    }
	}
}
