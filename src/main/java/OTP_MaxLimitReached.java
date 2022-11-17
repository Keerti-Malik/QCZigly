import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OTP_MaxLimitReached {
	@Test()

	public static void login_OTP_Limit() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='header content']//ul/li[2]")).click();
		Thread.sleep(2000);
		// enter mobile number
		driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436633");
		// click on Submit
		driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
		
		Thread.sleep(2000);
		// Now enter Wrong OTP
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("9");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("4");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(2000);
		WebElement message=driver.findElement(By.xpath("//div[@class='message-error error message']"));
		System.out.println(message.getText());
		
		// Now enter Wrong OTP
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("6");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(2000);
		WebElement message1=driver.findElement(By.xpath("//div[@class='message-error error message']"));
		System.out.println(message1.getText());
		
		// Now enter Wrong OTP
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("6");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("4");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(2000);
		WebElement message2=driver.findElement(By.xpath("//div[@class='message-error error message']"));
		System.out.println(message2.getText());
		
		// Now enter Wrong OTP
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("6");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("9");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(2000);
		WebElement message3=driver.findElement(By.xpath("//div[@class='message-error error message']"));
				System.out.println(message3.getText());
		
	}
}
