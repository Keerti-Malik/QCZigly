import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ResendOTP {

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
		Thread.sleep(25000);
		// click on Resend OTP
		driver.findElement(By.xpath("//div[@class='actions-toolbar resendotpblock']/a/span")).click();
	}
}
