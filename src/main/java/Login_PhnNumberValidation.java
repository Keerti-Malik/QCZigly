import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_PhnNumberValidation {
	
		@Test(priority=0)
		//check with entering less than 10 digit mobile number
			public static void phone_number_validation_1() throws Exception {
				
				
					System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
					WebDriver driver= new ChromeDriver();
					String baseUrl = "https://preprod.zigly.com/";
					driver.get(baseUrl);
					Thread.sleep(2000);
					driver.manage().window().maximize();
					driver.findElement(By.xpath("//div[@class='header content']//ul/li[2]")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("97596");
					
					driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
					WebElement messageerror=driver.findElement(By.id("social_login_email-error"));
					messageerror.getText();
					System.out.println(messageerror.getText());
					driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
					driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
					driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
					driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
					driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		}
		@Test(priority=1)
		//check with entering more than 10 digit mobile number
		public static void phone_number_validation_2() throws Exception {
			
			
				System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				String baseUrl = "https://preprod.zigly.com/";
				driver.get(baseUrl);
				Thread.sleep(2000);
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//div[@class='header content']//ul/li[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("975943663323268683463");
				
				driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
				driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
				driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
				driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
				driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
				Thread.sleep(2000);
				WebElement messageerror=driver.findElement(By.xpath("//div[@class='block-content']/div/div"));
				messageerror.getText();
				System.out.println(messageerror.getText());
	}
}
