import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_OTPBlankField {

	@Test(invocationCount = 1)

	public static void login() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='header content']//ul/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436633");
		driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		String msg = driver.findElement(By.id("social_login_pass-error")).getText();
		if (msg != null && msg.length() > 0) {
			System.out.println(" OTP - " + msg);
		}
	}
}
