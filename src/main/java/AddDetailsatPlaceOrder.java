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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddDetailsatPlaceOrder {
	@Test()
	public void addnewaddress() throws Exception {

		int phn = 42;
		int email = 21;
		for (int i = 0; i <= 5; i++)
		{
			
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://preprod.zigly.com/shop/for-cats.html");
				driver.manage().window().maximize();
				JavascriptExecutor js= (JavascriptExecutor)driver;
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				Thread.sleep(3000);
				
				searchByKey(driver, "IAMS Proactive Health Adult Large Breed Dry Dog Food");
		        js.executeScript("window.scrollTo(0,100)");
		        Thread.sleep(2000);
		        //click on searching product
		        driver.findElement(By.id("st-297-atc")).click();
		        Thread.sleep(4000);
		        //click on product size
		        driver.findElement(By.xpath("//div[@class='swatch-attribute-options clearfix']/div[1]")).click();
		        //click on Add to cart
		        driver.findElement(By.id("product-addtocart-button")).click();
		        Thread.sleep(3000);
				 js.executeScript("window.scrollTo(0,250)");
				//click on cart logo
			        driver.findElement(By.xpath("//div[@class='minicart-wrapper amtheme-header-icon']/a")).click();
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
						.sendKeys("77594366" + phn);
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
				we.sendKeys("keerti.malik02" + email + "@zigly.com");
				email++;
				// click on Palce Order
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
				Thread.sleep(4000);
				
			     js.executeScript("window.scrollTo(0,400)");
			     //click on cash delivery
			     WebElement button= driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label"));
			     button.click();
			     Thread.sleep(4000);
			     //click on CashOnDelivery button
			     driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button")).click();
			     
			} 
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

