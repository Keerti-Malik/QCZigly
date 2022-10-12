import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
			driver.findElement(By.xpath("//*[@id='moe-dontallow_button']")).click();
			driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[5]/header/div[2]/div[2]/div[3]/li/a/img")).click();
			try {//*[@id="html-body"]/div[5]/header/div[2]/div[2]/div[3]/li/a
			driver.findElement(By.xpath("/html/body/div[5]/header/div[2]/div[2]/div[3]/li/a")).click();
			Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			Login.beforelogin(driver);
			//click on profile logo
			//*[@id="html-body"]/div[4]/header/div[2]/div[2]/div[3]/li/a/img
			
			driver.findElement(By.xpath("//div[@class='mobile-only']/li/a/img")).click();
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
		    List<WebElement> orderlist= driver.findElements(By.xpath("//div[@class='owl-stage']/div/li/div[2]/div[2]/a[2]/span"));
		    for(int j=0; j<orderlist.size();j++) {
		    	orderlist.get(0).click();
		    	
		    }
		    Thread.sleep(2000);
		    //click on Ok button
		    driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).click();
			
	}

}
