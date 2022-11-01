import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class magento {


	WebDriver driver;
	@BeforeTest()
	public void login() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://preprod.zigly.com/admin/admin/index/index/key/8eb97891d87c711a051991a9fc5183a2d064798ae927b9539364986540b1121b/");
		 driver.manage().window().maximize();
	}
	@Test
	public void Sales_Order() throws Exception 
	{
		driver.findElement(By.id("username")).sendKeys("keerti");
		driver.findElement(By.id("login")).sendKeys("test@123");
		driver.findElement(By.xpath("//div[@class='actions']/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"menu-magento-sales-sales\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"menu-magento-sales-sales\"]/div/ul/li[1]/div/ul/li[1]/a")).click();
	}
}
