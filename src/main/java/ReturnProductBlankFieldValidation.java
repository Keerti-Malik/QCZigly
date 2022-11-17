import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReturnProductBlankFieldValidation {
	WebDriver driver;

	@BeforeTest()
	public void login() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		Login.login(driver);
	}
	@Test()
	public void Validation() throws InterruptedException 
	{
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
			  //click on return button
				   WebElement we1=driver.findElement(By.xpath("//div[@class='order-details-items ordered']/div/div[4]"));
				    String s= we1.getText();
				    if(s.equals("RETURN")) {	
				    we1.click();
				    }
				    //click on submit button
				    driver.findElement(By.xpath("//button[@class='action primary order-return-reason']/span")).click();
				    WebElement message=driver.findElement(By.xpath("//div[@class='mage-error']"));
				   // String message="This is a required field.";
				    if(message.getText().contains("This is a required field.")) {
				    	System.out.println("Reason to Return"+ message.getText());
				    }
	
	}
}
