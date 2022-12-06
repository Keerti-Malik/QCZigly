package EC_grooming;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnClickAddNewPet_RedirectToAddPetPage {

	WebDriver driver;
	@Test
	public void RedirectToAddNewPet() throws InterruptedException {
	driver=OpenWebsite.openwebsite(driver);
	//click on Pet Grooming
	List<WebElement> header= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li"));
	header.get(0).click();
	//click on AtExperienceCenter
	List<WebElement> submenu= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/div/ul/li"));
	submenu.get(2).click();	
	//click on Book Appointment
	driver.findElement(By.xpath("//div[@class='grooming-services']/div[3]/button/a")).click();
	Login.login(driver);
	// click on detect location
			driver.findElement(By.xpath("//div[@class='detect_location']")).click();
			Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor)driver;	
			js.executeScript("window.scrollTo(0,150)","");
			//click on add new pet
			driver.findElement(By.xpath("//li[@class='pet-listing']/div/a")).click();
			//verify user should redirect to add new pet page
		String ActualUrl=driver.getCurrentUrl();
		  String ExpectedUrl= "https://preprod.zigly.com/managepets/index/form/destination/grooming/service/center/";
		  Assert.assertEquals(ExpectedUrl, ActualUrl);
	}
}
