import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ClickOnAllSHOPProduct {

	@Test
	public void loginpage() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://qc.zigly.com/");
		Thread.sleep(2000);
		clickonDog(driver);
		clickonCat(driver);
		}
	
	private void clickonDog(WebDriver driver) throws InterruptedException {
		int indexItem = 26;
		for(int i=0; i<=63; i++ ) {
		    driver.findElement(By.xpath("//div[@class='page-nav-section']//div[2]/div/div/nav/ul")).click();
			Thread.sleep(2000);
			
				List<WebElement> list1= driver.findElements(By.xpath("//ul[contains(@class,'level2 submenu ui-menu ui-widget ui-widget-content')]/li/a[@id='ui-id-"+indexItem+"']"));
		    	System.out.println(list1.get(0).getText());
		    	list1.get(0).click();
		    	driver.navigate().back();
		    	indexItem++;
		
		}
	}
	private void clickonCat(WebDriver driver) throws InterruptedException {
		int indexItem = 98;
		for(int i=0; i<=23; i++ ) 
		{
			//click on SHOP
		    driver.findElement(By.xpath("//div[@class='page-nav-section']//div[2]/div/div/nav/ul")).click();
		    Thread.sleep(2000);
			//Click on CAT on leftsidebar
		    List<WebElement> Petname=driver.findElements(By.xpath("//ul[contains(@class,'level0 submenu amtheme-menu-flex')]/li/a"));
		    for (int k = 0; k< Petname.size(); k++) {
				if (Petname.get(k).getText().contains("CATS")) {
					Actions action = new Actions(driver);
			        action.moveToElement(Petname.get(k)).perform();
					break;
				}
			}
			
	        Thread.sleep(1000);
			//click on all cat items
				List<WebElement> list1= driver.findElements(By.xpath("//ul[contains(@class,'level2 submenu ui-menu ui-widget ui-widget-content')]/li/a[@id='ui-id-"+indexItem+"']"));
		    	System.out.println(list1.get(0).getText());
		    	Thread.sleep(1000);
		    	list1.get(0).click();
		    	driver.navigate().back();
		    	indexItem++;
    
		}
	}

	
}
