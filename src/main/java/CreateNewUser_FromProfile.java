import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewUser_FromProfile {

	 WebDriver driver;
		@BeforeTest()
		public void login() throws Exception
		{
			 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
			 driver=new ChromeDriver();
			 String baseUrl = "https://preprod.zigly.com/";
				driver.get(baseUrl);
				driver.manage().window().maximize();

		}
		@Test()
		 public void editprofile() throws Exception 
		{
			 JavascriptExecutor js= (JavascriptExecutor)driver;
		     //click on user logo and login with new number
		     driver.findElement(By.xpath("//ul[@class='header-links']/li[2]")).click();
		     driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436631");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
				driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
				driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
				driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
				driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
				Thread.sleep(3000);
				//now page redirect to signup page
				js.executeScript("window.scrollTo(0,150)");
				driver.findElement(By.xpath("/html/body/div[4]/main/div[3]/div/form/fieldset[1]/div/div/input")).sendKeys("Testing");
				driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("Testing@abc.com");
				driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(Keys.ENTER);
				
			    
			    
		}
}
