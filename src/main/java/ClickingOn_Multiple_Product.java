import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickingOn_Multiple_Product {

	 WebDriver driver;
		@BeforeTest()
		public void login() throws Exception
		{
			 System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
			 driver=new ChromeDriver();
			 String baseUrl = "https://preprod.zigly.com/";
				driver.get(baseUrl);
				driver.manage().window().maximize();
				Thread.sleep(2000);

		}
		@Test()
		 public void PDP_PLP_PageSelection() throws Exception 
		{			
				//click on Cat 
			driver.findElement(By.xpath("//div[@class='static-cards']/div[2]")).click();
			//select product
			List<WebElement>product=driver.findElements(By.xpath("//ol[@class='products list items product-items -col-xl-3 -col-sm-1 -amtheme-buttons-hover  -amtheme-swatches-hover']/li/div/div[1]"));
			for(int j=0; j<product.size(); j++) {
			Thread.sleep(1000);
			 product=driver.findElements(By.xpath("//ol[@class='products list items product-items -col-xl-3 -col-sm-1 -amtheme-buttons-hover  -amtheme-swatches-hover']/li/div/div[1]"));
				product.get(j).click();
				Thread.sleep(1000);
				driver.navigate().back();
		
			}
			
			
		}
}

