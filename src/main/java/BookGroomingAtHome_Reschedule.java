import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookGroomingAtHome_Reschedule {
	WebDriver driver = null;
	JavascriptExecutor js = null;

	@Test(invocationCount = 1)
	public void navigatetourl() throws InterruptedException {
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
		    //select particular order to reschedule
		    List<WebElement> orderlist= driver.findElements(By.xpath("//div[@class='owl-stage']/div/li/div/a/img"));
		    for(int j=0; j<orderlist.size();j++) {
		    	orderlist.get(0).click();
		    }
		    //click on reschedule
		    driver.findElement(By.xpath("//div[@class='booking-action']/a[1]")).click();
		 // select current date
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
			Date today = Calendar.getInstance().getTime();
			 dateFormat.format(today);
			Thread.sleep(2000);
		    
		    //select timeslot
		    driver.findElement(By.xpath("//div[@id='grooming-timeslot']/ol/li[7]")).click();
		    //click on save button
		    driver.findElement(By.id("submit-schedule")).click();
			
	}
}
