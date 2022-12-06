import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddDetailsatPlaceOrder_DEVD {
	@Test()
	public void addnewaddress() throws Exception {

		int phn = 65;
		int email = 8;
		for (int i = 0; i <= 4; i++)
		{
			
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://devd.zigly.com/shop/for-cats.html");
				driver.manage().window().maximize();
				JavascriptExecutor js= (JavascriptExecutor)driver;
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				Thread.sleep(3000);
				// click on first cat food image
				try {
					List<WebElement> catItem = driver
							.findElements(By.xpath("//div[@id='amasty-shopby-product-list']/div/ol/li/div/div/a/span"));
					for (int j = 0; j < catItem.size(); j++) {

						catItem.get(0).click();
		                   break;
					}
				} catch (StaleElementReferenceException ex) {
					System.out.println(ex.toString());
				}
				Thread.sleep(2000);
				// click on quick buy
				driver.findElement(By.xpath("//div[@class='sparsh-buynow-view']/button")).click();
				
				// click on Place Order
				try {
					driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
							.click();
				} catch (Exception e) {
					Thread.sleep(3000);
					driver.findElement(By.xpath("//ul[@class='checkout methods items checkout-methods-items']/li/a[1]"))
							.click();
				}
				Thread.sleep(4000);
				// enter mobile no.
				driver.findElement(By.xpath("//div[@class='control customrequired']/input[@name='mobilenumber']"))
						.sendKeys("77594366" + phn);
				phn++;
				Thread.sleep(2000);
				// Enter name
				WebElement we1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[3]/main/div[2]/div/div[4]/div[3]/ol/li[1]/div/div[3]/form/div[3]/div[1]/div/input")));
				we1.clear();
				we1.sendKeys("KM");
				// Thread.sleep(2000);
				// enter street
				WebElement we2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[3]/main/div[2]/div/div[4]/div[3]/ol/li[1]/div/div[3]/form/div[3]/fieldset/div/div[1]/div/input")));
				Thread.sleep(1000);
				// we2.clear();
				we2.sendKeys("xyz1");
				
				Thread.sleep(1000);
				// Select State
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/div/div/span"))).click();

				driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/div/div/ul/li[11]")).click();
				// Thread.sleep(2000);
				// Enter city
				WebElement we3 = driver.findElement(By.xpath("//div[@class='control']/input[@name='city']"));
				// we3.clear();
				we3.sendKeys("Delhi");
				// Enter Pincode
				driver.findElement(By.xpath("//div[@class='control']/input[@name='postcode']")).sendKeys("110071");
				// Thread.sleep(2000);
				// enter email
				WebElement we = driver
						.findElement(By.xpath("//div[@class='control _with-tooltip']/input[@name='username']"));
				we.clear();
				we.sendKeys("keerti.malik02" + email + "@zigly.com");
				email++;
				// click on Palce Order
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
				Thread.sleep(4000);
				
			     js.executeScript("window.scrollTo(0,400)");
			   /*  //click on cash delivery
			     WebElement button= driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label"));
			     button.click();
			     Thread.sleep(4000);
			     //click on CashOnDelivery button
			     driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button")).click();
			     */
			  // click on pay with razor pay
					driver.findElement(
							By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
					Thread.sleep(4000);
					//move to payment page
				     driver.switchTo().frame(0);
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

	
	}

