package EC_grooming;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAddNewPetOption_Avaialble {

	WebDriver driver;
	@Test
	public void AddNewPetOption() throws InterruptedException {
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
			//verify Add new pet available or not
		String ActualText=driver.findElement(By.xpath("//li[@class='pet-listing']/div/a")).getText();
		  String ExpectedText= "Add New Pet";
		  Assert.assertEquals(ExpectedText, ActualText);
	}
}
