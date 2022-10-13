import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookGroomingAtHome_CancelBooking {

	WebDriver driver = null;
	JavascriptExecutor js = null;

	@Test(invocationCount = 1)
	public void cancelbooking() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js = (JavascriptExecutor) driver;
			String baseUrl = "https://qc.zigly.com/";
			driver.get(baseUrl);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Login.login(driver);
			//click on profile logo
			driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/ul/li[2]")).click();
			//select Your Order
			List<WebElement> profilelist= driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
		    for(int i=0; i<profilelist.size();i++) 
		    {
		    if (profilelist.get(i).getText().contains("Your Orders")) {
		    		profilelist.get(i).click();
			   	break;
		    }   	
		    }
		    Thread.sleep(2000);
		    //select particular order to cancel
		    try {
		    List<WebElement> orderlist= driver.findElements(By.xpath("//div[@class='owl-stage']/div/li/div/a/img"));
		    for(int j=0; j<orderlist.size();j++) {
		    	orderlist.get(0).click();
		    	Thread.sleep(2000);
		    }
		    }
		    catch(Exception e)
		    {
		    	System.out.println(e);
		    }
		    Thread.sleep(000);
		    JavascriptExecutor js=(JavascriptExecutor) driver;
		     js.executeScript("window.scrollTo(0,300)");
		    //click on cancel order inside mybooking
		    driver.findElement(By.xpath("//div[@class='booking-action']/a[2]")).click();
		    Thread.sleep(2000);
		    //click on Ok button
		    driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).click();
			
	}

}
