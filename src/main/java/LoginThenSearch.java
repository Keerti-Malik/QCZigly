import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//Search from default added item on search textbox
public class LoginThenSearch {
	
	@Test()
   public void productbookfromsearchtab() throws InterruptedException
   {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
       Login.login(driver);
       //click on search textbox
       driver.findElement(By.id("search")).click();
       Thread.sleep(2000);
       //select predefined item from search
       driver.findElement(By.xpath("//div[@id='st-trending-searches']/ul/li[4]")).click();
       //click on ADD TO CART button
       driver.findElement(By.xpath("//div[@class='actions-primary']")).click();
       Thread.sleep(5000);
       //Select size
       driver.findElement(By.xpath("//div[@class='swatch-option text']")).click();
       //Click on Add to Cart button
       driver.findElement(By.id("product-addtocart-button")).click();
       //click on above cart logo
       driver.findElement(By.xpath("//div[@class='minicart-wrapper amtheme-header-icon']/a")).click();
       Thread.sleep(2000);
       //remove item from cart
       driver.findElement(By.xpath("//div[@class='control amtheme-qty-box']/button[1]")).click();
       //click on checkout
       driver.findElement(By.xpath("//div[@class='primary']/a[1]")).click();
       Thread.sleep(2000);
       //click on place order
       driver.findElement(By.xpath("//a[@class='action primary checkout']")).click();
       Thread.sleep(3000);
       //click on PLACE button
       driver.findElement(By.xpath("//div[@class='primary']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button[@class='action primary checkout']")).click();
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

}
