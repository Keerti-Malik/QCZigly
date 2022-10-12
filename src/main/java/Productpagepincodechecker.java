import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Productpagepincodechecker {

	WebDriver driver;

	@BeforeTest()
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://prepord.zigly.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void pincodecheck() throws Exception {
		// click on dog image
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[1]")).click();
		// click on product
		driver.findElement(By.xpath("//div[@class='product-photo-wrapper']/a/span/span/img")).click();
		int index = 110000;
		for (int i = index; i <= index + 6; i++) {
			WebElement we1 = driver.findElement(By.id("check-zipcode"));
			we1.clear();
			we1.sendKeys(i + "");
			driver.findElement(By.id("check-pincode")).click();
			Thread.sleep(2000);
			String response = driver.findElement(By.xpath("//*[@id=\"deliverydays_msg\"]")).getText();
			if (response != null && response.length() > 0) 
			{
				System.out.println(i + " - " + response);
			}
			else {
				WebElement we = driver.findElement(By.xpath("//div[@id='pincode_checker_msg_wrapper']"));
				System.out.println(i + " - " + we.getText());
				
			}
		}
	}
}
