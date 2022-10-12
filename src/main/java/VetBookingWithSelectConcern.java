
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VetBookingWithSelectConcern {

	WebDriver driver =null;
	
	@Test
	public void vetBooking() throws InterruptedException, Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		//wait=new WebDriverWait(driver,30);
		Login.login(driver);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		//click on Vet Consultation
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/a"));
	    for(int i=0; i<list.size();i++) 
	    {System.out.println(list.get(i).getText());
	    if (list.get(i).getText().contains("VET CONSULTATION")) {
	    	
	    		list.get(i).click();
		   	break;
	    }
	   }
	    //click on insta consult
		driver.findElement(By.xpath("//li[@class='parent']/div[@class='child-menu']/ul/li[2]")).click();
		//Select Pet
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement element=driver.findElement(By.cssSelector("label:nth-child(3)")); 
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		//click on NEXT button
		driver.findElement(By.name("next")).click();
		//Select Concern
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".points:nth-child(5) > .pain_points-label")).click();
		//enter health issue
		driver.findElement(By.id("describe_problem")).sendKeys("Customer describe their issue in detail");
		//Select image
		WebElement AddPhoto2mb = driver.findElement(By.xpath("//div[@class='add-image-doc']/a"));
		AddPhoto2mb.click();
		Robot rb = new Robot();
		rb.setAutoDelay(4000);
		StringSelection ss2 = new StringSelection("E:\\Mandatory testcase.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//print error msg
		WebElement errormsg=driver.findElement(By.xpath("//div[@class='message-error error message groom']"));
		String print=errormsg.getText();
		System.out.println(print);
		
		js.executeScript("window.scrollTo(0,200)");
		//again add image
		WebElement AddImage = driver.findElement(By.xpath("//div[@class='add-image-doc']/a"));
		AddImage.click();
		rb.setAutoDelay(4000);
		StringSelection ss = new StringSelection("E:\\a1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(200,0)");
		//click on NEXT button
		driver.findElement(By.name("next")).click();
		//select current date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		Thread.sleep(2000);
		//Select slot
		driver.findElement(By.xpath("//div[@id='grooming-timeslot']/ol/li[5]")).click();
		js.executeScript("scroll(250, 0)"); // if the element is on top.
		//click on next 
		driver.findElement(By.xpath("//*[@id=\"progressbar\"]/label[2]")).click();
		Thread.sleep(2000);
		//click on book appointment
		driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div/div[2]/fieldset[4]/div/div[2]/div/div[1]/div[2]/div[3]/button")).click();
		Thread.sleep(2000);
		//click on pay now
		driver.findElement(By.xpath("//*[@id=\"vet-consulting\"]/fieldset[5]/div[1]/div/div/div/div[2]/div[2]/div[9]/fieldset/label")).click();
		Thread.sleep(1000);
		//click on checkbox
		driver.findElement(By.xpath("//div[@class='terms-and-conditions-checkbox']")).click();
		Thread.sleep(2000);
		//click on make payment
		driver.findElement(By.xpath("//button[@class='btn-payment-make']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0,100)");
		// click on netbanking
		driver.findElement(By.xpath("//div[@class='methods-block']/div/button[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='bank-item-UTIB']")).click();
		js.executeScript("window.scrollTo(0,100)");
		Thread.sleep(2000);
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Window" + parentHandle);
		Thread.sleep(3000);
		// click on pay amount
		driver.findElement(By.id("footer")).click();
		Thread.sleep(4000);
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			// System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				String a = driver.getTitle();
				System.out.print(a);
				driver.findElement(By.xpath("/html/body/form/button[1]")).click();

			}
		}
	}
}
