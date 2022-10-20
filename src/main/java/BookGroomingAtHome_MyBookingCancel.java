import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BookGroomingAtHome_MyBookingCancel {
	WebDriver driver = null;
	JavascriptExecutor js = null;

	@Test(invocationCount = 1)
	public void navigatetourl() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			js = (JavascriptExecutor) driver;
			String baseUrl = "https://preprod.zigly.com/";
			driver.get(baseUrl);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Login.login(driver);
			//click on profile logo
			driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[2]/ul/li[2]")).click();
			//select Your Order
			List<WebElement> profilelist= driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
		    for(int i=0; i<profilelist.size();i++) 
		    {
		    if (profilelist.get(i).getText().contains("Your Orders")) {
		    		profilelist.get(i).click();
			   	break;
		    }   	
		    }
		    Thread.sleep(3000);
		    //select particular order to cancel  
		    List<WebElement> orderlist= driver.findElements(By.xpath("//div[@class='owl-item active']/li/div[2]/div[2]/a[2]"));
		    for(int j=0; j<orderlist.size();j++) {
		    	orderlist.get(0).click();
		    	//*[@id="owl-upcoming"]/div[1]/div/div[1]/li/div[2]/div[2]/a[2]
		    }
		    
		    Thread.sleep(2000);//*[@id="html-body"]/div[5]/aside[3]/div[2]/footer/button[2]
		    //click on Ok button
		    driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).sendKeys(Keys.ENTER);
			
	}

}
