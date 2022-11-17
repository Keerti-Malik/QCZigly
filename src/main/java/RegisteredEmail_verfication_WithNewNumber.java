
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisteredEmail_verfication_WithNewNumber {
	WebDriver driver;

	@BeforeTest()
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='header content']//ul/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436631");

		driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(3000);
	}

	@Test()
	public void login_with_new_number_on_same_email() throws Exception {

		driver.findElement(By.xpath("/html/body/div[4]/main/div[3]/div/form/fieldset[1]/div/div/input"))
				.sendKeys("Keerti");
		// enter email
		WebElement we1 = driver.findElement(By.id("email_address"));
		we1.sendKeys("keerti.malik@zigly.com");
		we1.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		// click on email verify
		driver.findElement(By.xpath("//div[@class='actions-toolbar email-verify']/div/button")).click();
		Thread.sleep(2000);
		WebElement msg = driver.findElement(By.id("errormsg"));
		System.out.println("Message:-"+ msg.getText());

	}
}
