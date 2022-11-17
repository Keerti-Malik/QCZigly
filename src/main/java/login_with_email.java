import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login_with_email {

	@Test()
	public static void loginwithemail() throws Exception {
		
		
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			String baseUrl = "https://preprod.zigly.com/";
			driver.get(baseUrl);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//div[@class='header content']//ul/li[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='block-content']/div[3]")).click();
			driver.findElement(By.id("social_login_email")).sendKeys("keerti.malik@zigly.com");
			
			driver.findElement(By.xpath("//div[@class='action login primary']/span")).click();
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
