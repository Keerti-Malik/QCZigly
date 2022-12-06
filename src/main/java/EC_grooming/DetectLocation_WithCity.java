package EC_grooming;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DetectLocation_WithCity {

	WebDriver driver;

	@Test()
	public void detectLocation_City() throws InterruptedException, AWTException {
		driver = OpenWebsite.openwebsite(driver);
		// click on Pet Grooming
		List<WebElement> header = driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li"));
		header.get(0).click();
		// click on AtExperienceCenter
		List<WebElement> submenu = driver
				.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/div/ul/li"));
		submenu.get(2).click();
		// click on Book Appointment
		driver.findElement(By.xpath("//div[@class='grooming-services']/div[3]/button/a")).click();
		Login.login(driver);
		// click on detect location-Select city
		driver.findElement(By.xpath("//div[@class='detect_location']")).click();
	}
}
