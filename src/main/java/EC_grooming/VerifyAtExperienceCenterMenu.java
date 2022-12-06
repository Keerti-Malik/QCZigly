package EC_grooming;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAtExperienceCenterMenu {

	WebDriver driver;
	@Test
	public void verifyAtExperienceCenter() throws InterruptedException {
	driver=OpenWebsite.openwebsite(driver);
	//click on Pet Grooming
	List<WebElement> header= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li"));
	header.get(0).click();
	//click on AtExperienceCenter
	List<WebElement> submenu= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/div/ul/li"));
	submenu.get(2).click();	
	//verify menu available or not
	String ActualUrl= driver.getCurrentUrl();
	  String ExpectedUrl= "https://preprod.zigly.com/services/pet-grooming/experience";
	  Assert.assertEquals(ExpectedUrl, ActualUrl);
	}
}
