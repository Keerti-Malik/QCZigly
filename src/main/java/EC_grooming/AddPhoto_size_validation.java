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

public class AddPhoto_size_validation {

	WebDriver driver;
	@Test(priority=1)
	public void photo_size_validation() throws InterruptedException, AWTException {
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
			Robot rb = new Robot();
			// click on add photo
			WebElement AddPhoto5mb = driver.findElement(By.xpath("//div[@class='add-photo']/div/label"));
			AddPhoto5mb.click();
			rb.setAutoDelay(5000);
			StringSelection ss = new StringSelection("E:\\pet_5mb.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rb.setAutoDelay(2000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			String msg=driver.findElement(By.xpath("//div[@class='mage-error']")).getText();
			System.out.println("Message if more than 5mb file selected:-"+msg);
			Thread.sleep(1000);
	}
}
