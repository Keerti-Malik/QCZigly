import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Detect_Location_WithoutLogin {

	@Test()
	public static void loginwithemail() throws Exception {
		
		
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			String baseUrl = "https://preprod.zigly.com/";
			driver.get(baseUrl);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			// click on location using Pincode
			driver.findElement(By.xpath("//div[@class='cityscreen']/div/button/span")).click();
			// click on detect location
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='location-modal']/div/span[3]/div")))
					.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("autosearch"))).sendKeys("201301");
			Thread.sleep(2000);
			List<WebElement> list = driver.findElements(By.xpath(
					"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
			list.get(0).click();
			// click on location using city name
						driver.findElement(By.xpath("//div[@class='cityscreen']/div/button/span")).click();
						// click on detect location
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='location-modal']/div/span[3]/div")))
								.click();
						Thread.sleep(2000);
						wait.until(ExpectedConditions.elementToBeClickable(By.id("autosearch"))).sendKeys("noida");
						Thread.sleep(2000);
						List<WebElement> list1 = driver.findElements(By.xpath(
								"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
						list1.get(0).click();
	}
}
