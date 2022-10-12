import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class checkout_login_link {

	@Test(invocationCount=1)
	public void checkoutlogin() throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.get("https://qc.zigly.com/");
	    //click on home page 'DOG'
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='static-cards']/div[1]")).click();
	    //Click on Addtocart
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[contains(@class,'action tocart primary')]")).click();
	  //  Select Size
	    
	  List<WebElement> listitem= driver.findElements(By.xpath("//div[@class='swatch-attribute-options clearfix']/div"));
	  for(int k=0; k<listitem.size(); k++) {
		  System.out.println(listitem.get(k).getText());
		 if(listitem.get(k).getAttribute("disabled") == null || !"true".equalsIgnoreCase(listitem.get(k).getAttribute("disabled"))) {
       listitem.get(k).click();
	  }
	  }
	   // Click on Add to Cart
	    driver.findElement(By.id("product-addtocart-button")).click(); 
	   Thread.sleep(3000);
	    //click on cart logo
	    driver.findElement(By.xpath("//div[@class='minicart-wrapper amtheme-header-icon']/a")).click(); 
	    Thread.sleep(3000);   
	       //click on checkout
	       driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
	       //click on place order
	       Thread.sleep(3000);
	       try {
	       driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
	       }
	       catch(Exception e) {
	    	   Thread.sleep(3000);
	    	   driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]")).click();
	       }
	       Thread.sleep(2000);
	       //click on Login Link
	       driver.findElement(By.xpath("//*[@id=\"chk-contct\"]/div[2]/a")).click();
	       driver.findElement(By.xpath("//*[@id=\"social_login_email\"]")).sendKeys("9759436633");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"bnt-auth-mobile\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"login_pass_1\"]")).sendKeys("1");
			driver.findElement(By.xpath("//*[@id=\"login_pass_2\"]")).sendKeys("2");
			driver.findElement(By.xpath("//*[@id=\"login_pass_3\"]")).sendKeys("0");
			driver.findElement(By.xpath("//*[@id=\"login_pass_4\"]")).sendKeys("0");
			driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
			//driver.close();
			Thread.sleep(4000);
			// Select address
			List<WebElement> list=driver.findElements(By.xpath("//div[@class='field addresses']/div/div/div/div/button"));
			 for(int i=0; i<list.size();i++) {
				 System.out.println(list.get(i).getText());		 
			list.get(0).click();
			//break;
			 }
			// click on Place Order
			Thread.sleep(2000);
			driver.findElement(By.id("shipping-method-buttons-container")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
			Thread.sleep(3000);
			js.executeScript("scroll(0, 200)");
			// Make Payment
            //click on PAyment RazorPay
			driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action primary checkout']"))
			.click();
    		
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
		    		 String a=driver.getTitle();
		    		 System.out.print(a);
		    		 driver.findElement(By.xpath("/html/body/form/button[1]")).click();
		    		
		    	 }
		     }
   }
}
