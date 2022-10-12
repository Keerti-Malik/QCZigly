
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ProductBooking {

@Test()
   public void run() throws InterruptedException
   // public static void main(String[] args) throws InterruptedException 
	{      
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        String baseUrl = "https://preprod.zigly.com/";
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        searchByKey(driver, "M-Pets Twist Ball Toy 11 cm - yellow");
        //click on Add to Cart
        driver.findElement(By.id("st-3051-atc")).click();
        Thread.sleep(2000);
        //click on cart logo
        driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/div[2]/div[2]/a/img")).click();
        Thread.sleep(2000);
        //click on checkout
        driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
        try {
 	       driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
 	       }
 	       catch(Exception e) {
 	    	   Thread.sleep(2000);
 	    	   driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
 	       }

        Thread.sleep(2000);
        loginWithOtp(driver);
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0,200)");
        Thread.sleep(2000);
        try {
        WebElement button3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='primary']/button")));
        button3.click();
        }catch(Exception e) {
        	System.out.print(e);
        	WebElement button3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='primary']/button")));
            button3.click();
        }
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0,200)");
        driver.findElement(By.xpath("//div[@class='primary']/button[@class='action primary checkout']")).click();
          
      Thread.sleep(4000);
	    //move to payment page
	     driver.switchTo().frame(0);
	     driver.findElement(By.xpath("//div[@class='methods-block']/div/button[3]")).click();
	     //Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[@class='netb-bank item radio-item svelte-wp9tn'][1]")).click();
	     Thread.sleep(2000);
	    String parentHandle= driver.getWindowHandle();
	     System.out.println("Parent Window"+parentHandle);
	     driver.findElement(By.id("footer")).click();
	     Thread.sleep(4000);
	     Set<String> handles= driver.getWindowHandles();
	     for(String handle:handles) {
	    	 System.out.println(handle);
	    	 if(!handle.equals(parentHandle)) {
	    		 driver.switchTo().window(handle);
	    		 String a=driver.getTitle();
	    		 System.out.print(a);
	    		 driver.findElement(By.xpath("/html/body/form/button[1]")).click();
	    		
	    	 }
	     }
    }
    
	private static void searchByKey(WebDriver driver, String searchKey) throws InterruptedException {
		try {
		WebElement element= driver.findElement(By.xpath("//*[@id=\"search\"]"));
        element.sendKeys(searchKey);
        Thread.sleep(2000);
        element.sendKeys(Keys.ENTER);
		}
		catch(Exception e)
		{
			System.out.println(e);
			WebElement element= driver.findElement(By.xpath("//*[@id=\"search\"]"));
	        element.sendKeys(searchKey);
	        Thread.sleep(2000);
	        element.sendKeys(Keys.ENTER);
		}
	}

	private static void loginWithOtp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("mobile")).sendKeys("9759436633");
        driver.findElement(By.xpath("//button[@id='submitnumber']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp1']")).sendKeys("1");
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp2']")).sendKeys("2");
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp3']")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp4']")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='primary']/button[@id='otpverify']")).click();
	}

}