import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditProfile {
   WebDriver driver;
	@BeforeTest()
	public void login() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 String baseUrl = "https://preprod.zigly.com/";
			driver.get(baseUrl);
		 
		 Login.login(driver);
	}
	@Test(priority=1)
	 public void editprofile() throws Exception 
	{
	     //click on user logo
	     driver.findElement(By.xpath("//ul[@class='header-links']/li[2]")).click();
			//select manage profile
			List<WebElement> list= driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
		    for(int i=0; i<list.size();i++) 
		    {
		    if (list.get(i).getText().contains("Manage Profile")) {
		    		list.get(i).click();
			   	break;
		    }   	
		    }
		    //click on edit
		  driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div/div[1]/div/a[1]")).click();
		  //Below hide code is for edit email id, phn no.
		 WebElement we=driver.findElement(By.id("firstname"));
		  we.clear();
		  we.sendKeys("KM");
		 /* WebElement we1=driver.findElement(By.id("email"));
		  we1.clear();
		  we1.sendKeys("keerti.malik1@abc.com");
		  //click on email verify
		  driver.findElement(By.xpath("//div[@class='actions-toolbar email-verify']/div/button")).click();*/
		  WebElement we2= driver.findElement(By.id("phone-number"));
		  we2.clear();
		  we2.sendKeys("1234567891");
		  driver.findElement(By.xpath("//div[@class='column main']")).click();
		  //click on phone number verify
		  driver.findElement(By.xpath("//div[@class='actions-toolbar phone-verify']/div/button")).click();
		  driver.findElement(By.id("verify_otp")).sendKeys("1200");
		  driver.findElement(By.xpath("//button[@class='verify-otp']")).click();
		 // Thread.sleep(2000);
		 
		Robot rb = new Robot();
		 WebElement chooseFile = driver.findElement(By.xpath("//fieldset[@class='fieldset file-upload']/div/label/span"));
		chooseFile.click();
		rb.setAutoDelay(4000);
		StringSelection ss= new StringSelection("E:\\a1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,500)");
		driver.findElement(By.id("edit-customer-profile")).click();
		Thread.sleep(2000);
     
   }
	@Test(priority=2)
	public void deleteimage()
	{
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div/div[1]/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/fieldset[2]/div/div[2]/span/label")).click();
		driver.findElement(By.id("edit-customer-profile")).click();
	}
}

