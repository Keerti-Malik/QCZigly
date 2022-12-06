package EC_grooming;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPetGroomingSubmenu {

	WebDriver driver;

	@Test
	public void verifyPetgroomingsubmenu() throws InterruptedException {
    driver=OpenWebsite.openwebsite(driver);
    //click on petGrooming
	List<WebElement> header= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li"));
	header.get(0).click();
	//verify menu available or not
	List<WebElement> submenu= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/div/ul/li"));
	String submenu_name1=submenu.get(0).getText();	
	String submenu_name2=submenu.get(2).getText();
	String ActualText= submenu_name1;
	  String ExpectedText= "AT HOME";
	  Assert.assertEquals(ExpectedText, ActualText);
	  String ActualText2= submenu_name2;
	  String ExpectedText2= "AT EXPERIENCE CENTER";
	  Assert.assertEquals(ExpectedText2, ActualText2);
	}
}
