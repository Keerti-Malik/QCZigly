import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShopByConcern {
	
 
	@Test
	public void clickonshopbyconcerncategory() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qc.zigly.com/");
		Thread.sleep(2000);
		//clickbyconcern(driver);
		clickByBrand(driver);
		}
	
	private void clickbyconcern(WebDriver driver) throws InterruptedException {
		int indexItem = 122;
		for (int i = 0; i <=3; i++) {
			driver.findElement(By.xpath("//div[@class='page-nav-section']//div[2]/div/div/nav/ul")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//ul[contains(@class,'level0 submenu amtheme-menu-flex')]/li[3]/a[1]/span[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("ui-id-"+indexItem)).click();
			indexItem++;
			driver.navigate().back();
			Thread.sleep(2000);
		}
	}
	private void clickByBrand(WebDriver driver) throws InterruptedException {
		int indexItem = 126;
		for (int j = 0; j <=18; j++) {
			driver.findElement(By.xpath("//div[@class='page-nav-section']//div[2]/div/div/nav/ul")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//ul[@class='level0 submenu amtheme-menu-flex ui-menu ui-widget ui-widget-content ui-corner-all']/li[4]/a/span[2]")).click();
			Thread.sleep(2000);
			try {
			driver.findElement(By.id("ui-id-"+indexItem)).click();
			indexItem++;
			}
			catch(Exception e) {
				e.printStackTrace();
				Thread.sleep(1000);
				driver.findElement(By.id("ui-id-"+indexItem)).click();
				indexItem++;
			}
			driver.navigate().back();
			Thread.sleep(2000);
		}
	}
}
