package EC_grooming;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Redirect_to_SelectPet_AfterAddPet {

	WebDriver driver;
	@Test()
	public void redirectlink_to_selectPet_after_addpet() throws InterruptedException, AWTException {
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
			// select type
			driver.findElement(By.xpath("//div[@class='breed-control type']/label[2]")).click();
			Thread.sleep(1000);
			// select gender
			driver.findElement(By.xpath("//div[@class='breed-control petgender']/label[1]")).click();
			Thread.sleep(1000);
			// Select breed
			driver.findElement(By.xpath("//*[@id=\"breedname\"]")).sendKeys("Siamese");
			Thread.sleep(2000);
			List<WebElement> breed=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
			for(int i=0; i<=breed.size(); i++) {
				System.out.println(breed.get(0).getText());
				breed.get(0).click();
				break;
			}
			Thread.sleep(2000);
			// add age
			driver.findElement(By.xpath("//*[@id=\"age_year\"]")).sendKeys("1");
			driver.findElement(By.xpath("//*[@id=\"age_month\"]")).sendKeys("1");
			// enter name
			WebElement we = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			we.clear();
			we.sendKeys("Luffy");
			Robot rb = new Robot();
			
			// click on add photo
			WebElement AddPhoto5mb = driver.findElement(By.xpath("//div[@class='add-photo']/div/label"));
			AddPhoto5mb.click();
			rb.setAutoDelay(5000);
			StringSelection ss = new StringSelection("E:\\photo4.jpeg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rb.setAutoDelay(2000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			
			//click on add pet button
			driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button/span")).click();
			Thread.sleep(2000);
			//verify page should redirect to select pet page
			String text=driver.findElement(By.xpath("//li[@class='pet-listing']/div/a")).getText();
			if(text.equalsIgnoreCase("Add New Pet"))
			{
				System.out.println(text);
			}
			driver.close();
	}
}
