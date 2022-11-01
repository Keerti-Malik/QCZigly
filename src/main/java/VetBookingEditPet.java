import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VetBookingEditPet {

	WebDriver driver =null;
	
	@Test
	public void vetBooking() throws InterruptedException, Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		//wait=new WebDriverWait(driver,30);
		Login.login(driver);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//click on Vet Consultation
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/a"));
	    for(int i=0; i<list.size();i++) 
	    {System.out.println(list.get(i).getText());
	    if (list.get(i).getText().contains("VET CONSULTATION")) {
	    	
	    		list.get(i).click();
		   	break;
	    }
	   }
	    //click on video appointment
		driver.findElement(By.xpath("//li[@class='parent']/div[@class='child-menu']/ul/li[2]")).click();
		//edit Pet
		Thread.sleep(2000);
		List<WebElement> edit=driver.findElements(By.xpath("//div[@class='pet-actions']/a[1]"));
		edit.get(0).click();
		Thread.sleep(2000);
		//js.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//div[@class='add-photo']")).click();
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.setAutoDelay(4000);
		StringSelection ss2 = new StringSelection("E:\\a2.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// click on ADD PET button
				driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action submit primary save-new-pet']")).click();
		Thread.sleep(2000);
		
	}
}
