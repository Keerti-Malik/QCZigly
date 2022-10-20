
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	public static void beforelogin(WebDriver driver) throws InterruptedException {
		
		{
			
			driver.findElement(By.xpath("//div[@class='mobile-only']/li/a/img")).click();
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
	     }
	}
	public static void login(WebDriver driver) throws InterruptedException {
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);//*[@id="html-body"]/div[4]/header/div[2]/div[2]/div[3]/li
		driver.manage().window().maximize();
		WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[2]/ul/li[2]/a/img")));
	    passwordElement.click();
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
     }
	
  }
      public static void afterlogin(WebDriver driver) throws InterruptedException
      {
    	  driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436633");
          driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
          Thread.sleep(2000);//*[@id="login_pass_1"]
          driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
          driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
          driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
          driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
          driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
	  } 
}