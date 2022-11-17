import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ReviewPaymentPage_Add_Edit_Address {

	@Test()
	public void addnewaddress_shippingpage() throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String baseUrl = "https://preprod.zigly.com/";
		driver.get(baseUrl);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		Login.login(driver);
	    Thread.sleep(2000);
	    //click on Dog
	   WebElement selectproduct= driver.findElement(By.id("search"));
	   selectproduct.sendKeys("beboji Charlie Sheen Dog Shirt");
	   selectproduct.sendKeys(Keys.ENTER);
	  //Click on Addtocart button
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='st-inner-box']/div[4]/button")).click();
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
        js.executeScript("window.scrollTo(0,150)");
      //  Thread.sleep(3000);
        //click on Place Order
	       try {
	       driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
	       }
	       catch(Exception e) {
	    	   Thread.sleep(3000);
	    	   driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
	       }
	   	Thread.sleep(3000);
	    // select address
 			List<WebElement> addresses = driver.findElements(By.xpath("//div[@class='shipping-address-items']/div/div/button"));
		
			for (int j = 0; j < addresses.size(); j++) {
				//Thread.sleep(2000);
				addresses.get(2).click();
			
			}
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0,200)");
			Thread.sleep(1000);
			// click on place order
			driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
			js.executeScript("window.scrollTo(0,350)");
			Thread.sleep(2000);
			//Click on Edit inside billing address
			driver.findElement(By.xpath("//div[@class='billing-address-details']/button")).click();
			Thread.sleep(2000);
			Select billingaddress= new Select(driver.findElement(By.name("billing_address_id")));
			billingaddress.selectByIndex(1);
			js.executeScript("window.scrollTo(0,150)");
	       //click on Pay with razor pay
	       Thread.sleep(4000);
	       driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action action-update']")).click();
	     driver.findElement(By.xpath("//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button")).click();
	     Thread.sleep(4000);
		    //move to payment page
		     driver.switchTo().frame(1);
		     Thread.sleep(2000);
		     //select payment mode
		     driver.findElement(By.xpath("//div[@class='methods-block']/div/button[3]/div/div")).click();
		     //Thread.sleep(2000);
		     driver.findElement(By.xpath("//div[@id='bank-item-UTIB']")).click();
		     Thread.sleep(2000);
		    String parentHandle= driver.getWindowHandle();
		     System.out.println("Parent Window"+parentHandle);
		     js.executeScript("window.scrollTo(0,100)");
		     driver.findElement(By.xpath("//button[@id='redesign-v15-cta']")).click();
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
}
