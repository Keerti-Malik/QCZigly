import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Checkout_New_Address
{

	@Test()
	public void searchwithfilters() throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//JavascriptExecutor js= (JavascriptExecutor)driver;
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		Login.login(driver);
	    Thread.sleep(2000);
	    //click on Dog
	    driver.findElement(By.xpath("//div[@class='static-cards']/div[1]")).click();
	  //Click on Addtocart
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[contains(@class,'action tocart primary')]")).click();
	  //  Select Size
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='swatch-option text']"))).click();
	  Thread.sleep(2000);
	// Click on Add to Cart
	    driver.findElement(By.id("product-addtocart-button")).click(); 
	   Thread.sleep(3000);
	  //click on cart logo
        driver.findElement(By.xpath("//div[@class='minicart-wrapper amtheme-header-icon']/a")).click();
        Thread.sleep(2000);
      //click on checkout
        driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
        Thread.sleep(3000);
        //click on Place Order
	       try {
	       driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
	       }
	       catch(Exception e) {
	    	   Thread.sleep(3000);
	    	   driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
	       }
	       //click on New Address
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='new-address-popup']/button/span"))).click();
	       //Enter Street
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='control']/input[@name='street[0]']"))).sendKeys("Jasola-123");
	       //Enter city
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='control']/input[@name='city']"))).sendKeys("Delhi");
	       //Select State
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/div/div/span"))).click();
	       driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/div/div/ul/li[11]")).click();
	       //Enter Pincode
	       driver.findElement(By.xpath("//div[@class='control']/input[@name='postcode']")).sendKeys("110071");
	       //Click on Save Address
	       driver.findElement(By.xpath("//div[@class='amtheme-address-toolbar']/button[2]")).click();
	       //click on Palce Order
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
	       
	}
}
