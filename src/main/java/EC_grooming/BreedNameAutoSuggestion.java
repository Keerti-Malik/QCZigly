package EC_grooming;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BreedNameAutoSuggestion {

	
	WebDriver driver;
	@Test(priority=1)
	public void breednamesuggestion() throws InterruptedException {
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
			//enter breed name
			driver.findElement(By.xpath("//*[@id=\"breedname\"]")).sendKeys("la");
			Thread.sleep(2000);
			List<WebElement> breed=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
			for(int i=0; i<=breed.size(); i++) {
				System.out.println(breed.get(0).getText());
				breed.get(0).click();
				break;
			}
	}
	@Test(priority=2)
	public void breednamesuggestion2() throws InterruptedException {
	
			//enter breed name
			WebElement text=driver.findElement(By.xpath("//*[@id=\"breedname\"]"));
					text.clear();
			text.sendKeys("xyz");
			Thread.sleep(2000);
			List<WebElement> breed=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
			for(int i=0; i<=breed.size(); i++) {
				String Actualname=breed.get(0).getText();
				String Expectedname= "Other";
				  Assert.assertEquals(Expectedname, Actualname);
				breed.get(0).click();
				break;
			}
	}
}
