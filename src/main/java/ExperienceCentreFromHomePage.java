import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExperienceCentreFromHomePage 
{
	WebDriver driver;
	
	
	@Test()
	public void Home_experiencecentre() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://preprod.zigly.com/experience-center");
		//click on all directions
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div[2]/div[2]/div[1]/p[6]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div[2]/div[2]/div[1]/p[10]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div[2]/div[2]/div[1]/p[14]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div[2]/div[2]/div[1]/p[18]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div[2]/div[1]/a")).click();
		try{
	    driver.switchTo().window("https://qa.zigly.com/customer/account/login/");
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	    login();
	    bookEC();
	}

    public void login() throws InterruptedException {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.findElement(By.id("social_login_email")).sendKeys("9759436633");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='bnt-auth-mobile']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
		Thread.sleep(2000);
		// click on detect location
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='detect_location']"))).click();
		
	}
    public void bookEC() throws Exception
    {
    	//Select Pet
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='manage-pets']/li/div[3]/button"))).click();
    	// select plan
    		WebElement txt2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='plan-content']/div[6]/button")));
    		txt2.click();
    	// select timeslot
    		JavascriptExecutor js= (JavascriptExecutor) driver;
    		js.executeScript("window.scrollTo(0,100)");
    		//select date
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grooming-calendar-slot\"]/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[3]/td[4]/div/div[1]"))).click();
    		//Select time
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grooming-timeslot\"]/ol/li[15]"))).click();
    		//click on next
    		driver.findElement(By.xpath("//*[@id=\"time-proceed-73\"]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//*[@id=\"groomer-service\"]/fieldset[4]/div[1]/ul/li")).click();
 
    	// select address
    	
    		driver.findElement(By.xpath("//div[@class='action-address']/button[1]")).click();
    		Thread.sleep(2000);
    		
    	// Make Payment

    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='booking-payment']/button"))).click();
    		
    		//move to payment page
		     driver.switchTo().frame(0);
		   //  click on netbanking
		     wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='methods-block']/div/button[3]/div")))
						.click();
		     driver.findElement(By.id("bank-item-UTIB")).click();
		     Thread.sleep(2000);
		    String parentHandle= driver.getWindowHandle();
		     System.out.println("Parent Window"+parentHandle);
		     //click on pay amount
		     driver.findElement(By.id("footer")).click();
		     Thread.sleep(4000);
		     Set<String> handles= driver.getWindowHandles();
		     for(String handle:handles) 
		     {
		    	 //System.out.println(handle);
		    	 if(!handle.equals(parentHandle)) 
		    	 {
		    		 driver.switchTo().window(handle);
		    		 Thread.sleep(1000);
		    		 String a=driver.getTitle();
		    		 System.out.print(a);
		    		 driver.findElement(By.xpath("/html/body/form/button[1]")).click();
		    		
		    	 }
		     }
		    

    }
}
