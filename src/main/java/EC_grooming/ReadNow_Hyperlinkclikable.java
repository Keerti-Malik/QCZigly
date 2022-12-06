package EC_grooming;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReadNow_Hyperlinkclikable {

	WebDriver driver;

	@Test
	public void verifyHyperlinkclickable() throws InterruptedException {
		driver = OpenWebsite.openwebsite(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;	
		
		//click on Pet Grooming
		List<WebElement> header= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li"));
		header.get(0).click();
		//click on AtExperienceCenter
		List<WebElement> submenu= driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/div/ul/li"));
		submenu.get(2).click();
        try {
		List<WebElement> click_hyperlink = driver.findElements(By.xpath("//div[@class='health-images']/div/div[2]/a"));
		for (int i = 0; i <= 2; i++) {
			click_hyperlink.get(i).click();
			Thread.sleep(1000);
			driver.navigate().back();
			driver.navigate().refresh();
			js.executeScript("window.scrollTo(0,490)","");
			Thread.sleep(3000);
			
		
		}
        }catch(org.openqa.selenium.StaleElementReferenceException ex){
        	List<WebElement> click_hyperlink = driver.findElements(By.xpath("//div[@class='health-images']/div/div[2]/a"));
    		for (int i = 0; i <=2; i++) {
    			click_hyperlink.get(i).click();
    			Thread.sleep(1000);
    			driver.navigate().back();
    			driver.navigate().refresh();
    			js.executeScript("window.scrollTo(0,490)","");
    			Thread.sleep(3000);
    		   			
        }

        }
	}
}
