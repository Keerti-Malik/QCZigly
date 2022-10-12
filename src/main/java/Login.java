
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public static void beforelogin(WebDriver driver) throws InterruptedException {
		
		{
			
			driver.findElement(By.xpath("//div[@class='mobile-only']/li/a/img")).click();
			driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436633");
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
		
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();//*[@id="html-body"]/div[4]/header/div[2]/div[2]/div[3]/li/a/img
		driver.findElement(By.xpath("//*[@id='moe-dontallow_button']")).click();
		driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[5]/header/div[2]/div[2]/div[3]/li/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436633");
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
    	  driver.findElement(By.xpath("//div[@class='control customrequired']/input[2]")).sendKeys("9759436633");
          driver.findElement(By.xpath("//button[@id='submitnumber']")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp1']")).sendKeys("1");
          driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp2']")).sendKeys("2");
          driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp3']")).sendKeys("0");
          driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp4']")).sendKeys("0");
          driver.findElement(By.xpath("//div[@class='primary']/button[@id='otpverify']")).click();
	  } 
}