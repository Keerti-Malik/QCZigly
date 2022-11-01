import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddDetailsatPlaceOrder {
	@Test()
	public void addnewaddress() throws Exception {

		int phn = 37;
		int email = 16;
		//int street = 1;
		for (int i = 0; i <= 0; i++)
		{
			
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://preprod.zigly.com/shop/for-cats.html");
				driver.manage().window().maximize();
				// JavascriptExecutor js= (JavascriptExecutor)driver;
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				Thread.sleep(3000);
				// click on product-Add to cart
				List<WebElement> product=driver.findElements(By.xpath(
						"//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li[1]/div/div[3]/div/div/form/button"));
				for(int j=0; j<product.size(); j++) {
					product.get(0).click();
				}

				Thread.sleep(2000);
				// click on cart logo//*[@id="html-body"]/div[5]/header/div[2]/div[2]/div[2]/a/img
				driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[5]/header/div[2]/div[2]/div[2]/a/img")).click();
				Thread.sleep(3000);
				// click on checkout
				driver.findElement(By.xpath("//a[@class='action secondary checkout']")).click();
				Thread.sleep(3000);
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
						.sendKeys("9759436632" + phn);
				phn++;
				Thread.sleep(2000);
				// Enter name
				WebElement we1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[4]/main/div[2]/div/div[4]/div[3]/ol/li[1]/div/div[3]/form/div[3]/div[1]/div/input")));
				we1.clear();
				we1.sendKeys("KM");
				// Thread.sleep(2000);
				// enter street
				WebElement we2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[4]/main/div[2]/div/div[4]/div[3]/ol/li[1]/div/div[3]/form/div[3]/fieldset/div/div[1]/div/input")));
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
				we.sendKeys("keerti.malik" + email + "@zigly.com");
				email++;
				// click on Palce Order
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
				Thread.sleep(4000);
				JavascriptExecutor js=(JavascriptExecutor) driver;
			     js.executeScript("window.scrollTo(0,400)");
			     //click on cash delivery
			     WebElement button= driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label"));
			     button.click();
			     Thread.sleep(4000);
			     //click on CashOnDelivery button
			     driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button")).click();
			     //Thread.sleep(2000);
			     //Click on pay
			    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[2]/div/div[3]/a[1]"))).click();
			    
			     /*// click on pay with razor
				// pay//div[@class='payment-group']/div[2]/div[2]/div[4]/div/button
				driver.findElement(By.xpath("//div[@class='payment-group']/div[2]/div[2]/div[4]/div/button")).click();
				// driver.findElement(By.xpath("//button[@class='action primary
				// checkout']")).click();
				Thread.sleep(4000);
				 
				// move to payment page
				driver.switchTo().frame(0);
				Thread.sleep(3000);
				// click on netbanking
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='methods-block']/div/button[3]/div/div/div[@class='svelte-zafzgj']")))
						.click();
				Thread.sleep(3000);
				// select bank
				driver.findElement(By.id("bank-item-UTIB")).click();
				Thread.sleep(2000);
				String parentHandle = driver.getWindowHandle();
				System.out.println("Parent Window" + parentHandle);
				// click on pay amount
				driver.findElement(By.id("footer")).click();
				Thread.sleep(4000);
				Set<String> handles = driver.getWindowHandles();
				for (String handle : handles) {
					// System.out.println(handle);
					if (!handle.equals(parentHandle)) {
						driver.switchTo().window(handle);
						String a = driver.getTitle();
						System.out.print(a);
						driver.findElement(By.xpath("/html/body/form/button[1]")).click();

					}
				}
*/
			} 
		}

	}

