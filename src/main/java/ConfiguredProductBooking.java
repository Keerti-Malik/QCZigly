import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ConfiguredProductBooking
{

	@Test(invocationCount=1)
	public void searchItem() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        String baseUrl = "https://preprod.zigly.com/";
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        searchByKey(driver, "IAMS Proactive Health Adult Large Breed Dry Dog Food");
        js.executeScript("window.scrollTo(0,100)");
        Thread.sleep(2000);
        //click on searching product
        driver.findElement(By.id("st-297-atc")).click();
        Thread.sleep(4000);
        //click on product size
        driver.findElement(By.xpath("//div[@class='swatch-attribute-options clearfix']/div[1]")).click();
        //click on cart
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(2000);
        //click on cart
        driver.findElement(By.xpath("//div[@class='minicart-wrapper amtheme-header-icon']/a")).click();
        Thread.sleep(2000);
        //click on checkout
        driver.findElement(By.xpath("//div[@class='primary']")).click();
        Thread.sleep(2000);
        //click on place order
        driver.findElement(By.xpath("//a[@class='action primary checkout']")).click();
        Thread.sleep(3000);
        loginWithOtp(driver);
        /*Thread.sleep(2000);
        //click on place order
        try {
            WebElement button3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='primary']/button[1]")));
            button3.click();
            }catch(Exception e) {
            	System.out.print(e);
            	WebElement button3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='primary']/button[1]")));
                button3.click();
            }
        Thread.sleep(3000);
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
	     }*/
	}

	private void loginWithOtp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("mobile")).sendKeys("9759436633");
        driver.findElement(By.id("submitnumber")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp1']")).sendKeys("1");
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp2']")).sendKeys("2");
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp3']")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='otp-control']/input[@id='otp4']")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='primary']/button[@id='otpverify']")).click();
		
	}

	private void searchByKey(WebDriver driver, String searchKey) throws InterruptedException {
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

}
