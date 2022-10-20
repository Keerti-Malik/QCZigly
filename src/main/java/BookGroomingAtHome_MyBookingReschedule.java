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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookGroomingAtHome_MyBookingReschedule {
	WebDriver driver = null;
	JavascriptExecutor js = null;

	@Test(invocationCount = 1)
	public void navigatetourl() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js = (JavascriptExecutor) driver;
			String baseUrl = "https://preprod.zigly.com/";
			driver.get(baseUrl);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id='optInText']")).click();
			Thread.sleep(2000);
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
		    Thread.sleep(2000);
		    //select particular order to reschedule//div[@class='owl-item active']/li/div[2]/div[2]/a[2]
		    List<WebElement> orderlist= driver.findElements(By.xpath("//div[@class='owl-item active']/li/div[2]/div[2]/a[1]"));
		    for(int j=0; j<orderlist.size();j++) {//div[@class='owl-stage']/div/li/div/a/img
		    	orderlist.get(0).click();
		    }
		    Thread.sleep(2000);
		    //click on reschedule
		    driver.findElement(By.xpath("//div[@class='booking-action']/a[1]")).click();
		 // click on detect location
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.findElement(By.xpath("//div[@class='primary location-tooltip-show']/button")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"location-modal\"]/div/span[3]/div")))
					.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("autosearch"))).sendKeys("122001");
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath(
					"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
			list.get(0).click();
			Thread.sleep(3000);
		
			js.executeScript("window.scrollTo(0,100)");
			Thread.sleep(2000);
			/*try {
			driver.findElement(By.xpath("//*[@id=\"grooming-calendar-slot\"]/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[2]/td[3]/div")).click();
			}
			catch(Exception e) {
				System.out.println(e);
			}*/
			// select current date
			try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date today = Calendar.getInstance().getTime();
			 String date=dateFormat.format(today);
			 System.out.println(date);
			 System.out.println(today);			 
			Thread.sleep(2000);	
			}
			catch(Exception e)
			{
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();
				 String date=dateFormat.format(today);
				 System.out.println(date);
				 System.out.println(today);			 
				Thread.sleep(2000);	
			}
		    //select timeslot
		    driver.findElement(By.xpath("//div[@id='grooming-timeslot']/ol/li[10]")).click();
		    //click on save button
		    driver.findElement(By.id("submit-schedule")).click();
			
	}
}
