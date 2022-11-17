import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Manageprofile_AddPet_Address {
	@Test
	public void manageProfile() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Login.login(driver);
		// click on profile logo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='header-links']/li[2]")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-options']/ul/li/a"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains("Manage Profile")) {
				list.get(i).click();
				break;
			}
		}

		// click on add pet
		driver.findElement(By.xpath("//div[@class='amtheme-heading']/a")).click();
		addPet(driver);
		System.out.println("New Pet Added sucessfully");
		addAddress(driver);
		System.out.println("New Address Added sucessfully");
	}

	public void addPet(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[1]/div/div/div/label[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[2]/div/div/div/label[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"breedname\"]")).sendKeys("Bengal Ca");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/ul[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"age_year\"]")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\"age_month\"]")).sendKeys("7");
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Suffy");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[7]/div[2]/div/button")).click();

	}

	// Add Address
	public void addAddress(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div/button")).click();
		driver.findElement(By.xpath("//div[@class='control']/input[@id='street_1']")).sendKeys("79/1 -A royal");
		driver.findElement(By.id("city")).sendKeys("Panaji");
		Thread.sleep(2000);
		Select region = new Select(driver.findElement(By.id("region_id")));
		region.selectByVisibleText("Goa");
		driver.findElement(By.id("zip")).sendKeys("403001");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		Thread.sleep(2000);
	}
}
