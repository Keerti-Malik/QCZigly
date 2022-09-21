import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagentoWriteReview {

	WebDriver driver;

	@BeforeTest()
	public void login() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://qc.zigly.com/admin/admin/index/index/key/8eb97891d87c711a051991a9fc5183a2d064798ae927b9539364986540b1121b/");
		driver.manage().window().maximize();
	}

	@Test
	public void writereview() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("username")).sendKeys("qazigly");
		driver.findElement(By.id("login")).sendKeys("qazigly@123");
		driver.findElement(By.xpath("//div[@class='actions']/button")).click();
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0,300)");
		// click on marketing
		List<WebElement> sidebarlabel=driver.findElements(By.xpath("//nav[@class='admin__menu']/ul/li/a"));
		for(int j=0; j<sidebarlabel.size();j++) {
			if (sidebarlabel.get(j).getText().contains("MARKETING")) {
				sidebarlabel.get(j).click();
		   	break;
	    }   	
		}
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='nav']/li[10]/a"))).click();
		Thread.sleep(2000);
		// click on All Review
		driver.findElement(By.xpath("//li[@class='item-catalog-reviews-ratings-reviews-all    level-2']/a")).click();
		Thread.sleep(2000);

		for (int i = 0; i <= 1; i++) {
			// click on new review
			driver.navigate().refresh();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='page-actions-buttons']/button"))).click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Select list = new Select(driver.findElement(By.id("productGrid_page-limit")));
			list.selectByValue("200");
			Thread.sleep(2000);
			// click on ID
			try {
				List<WebElement> review = driver.findElements(By.xpath(
						"//table[@id='productGrid_table']/tbody/tr/td[@class=' col-id col-entity_id                                        ']"));
				Thread.sleep(2000);

				review.get(i).click();
			} catch (StaleElementReferenceException ex) {
				System.out.println(ex.toString());
			}

			try {
				Thread.sleep(2000);
				// click on visibility
				Select visibility = new Select(driver.findElement(By.id("select_stores")));
				visibility.selectByValue("1");
			} catch (Exception e) {
				Thread.sleep(2000);

				Select visibility = new Select(driver.findElement(By.id("select_stores")));
				visibility.selectByValue("1");
			}
			Thread.sleep(3000);
			
			js.executeScript("window.scrollTo(100,0)");
			// click on feedback star
			driver.findElement(By.xpath("//div[@class='admin__field-control']/label[1]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nickname"))).sendKeys("Test1");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))).sendKeys("Testing123");
			driver.findElement(By.xpath("//textarea[@id='detail']")).sendKeys("Good Product");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='page-actions-buttons']/button[@id='save_button']"))).click();
		}
	}
}
