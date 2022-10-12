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
	public void vetBooking() throws InterruptedException
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
	    //click on insta consult
		driver.findElement(By.xpath("//li[@class='parent']/div[@class='child-menu']/ul/li[2]")).click();
		//edit Pet
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//ul[@class='manage-pets']/li[5]/div/label")); 
		js.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//div[@class='pet-actions']/a[@class='action edit']")).click();
		driver.findElement(By.xpath("//div[@class='upload-custom-image']/span/span")).click();
		Thread.sleep(1000);
		// click on ADD PET button
				driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[7]/div[2]/div/button")).click();
		Thread.sleep(2000);
		
	}
}
