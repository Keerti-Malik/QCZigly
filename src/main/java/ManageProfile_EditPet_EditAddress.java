import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ManageProfile_EditPet_EditAddress {
	@Test
	public void manageProfile() throws InterruptedException, AWTException {
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

		// click on edit pet button
		

		//editPet(driver);
		System.out.println("New Pet Added sucessfully");
		editAddress(driver);
		System.out.println("New Address Added sucessfully");
	}

	public void editPet(WebDriver driver) throws InterruptedException, AWTException {
		List<WebElement> petlist = driver.findElements(By.xpath(
				"//div[@class='amtheme-addresses-block -dashboard-addresses']/div/div/div[2]/a[@class='action edit']"));
		for (int j = 0; j < petlist.size(); j++) {

			petlist.get(1).click();
			break;
		}
		driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[1]/div/div/div/label[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[2]/div/div/div/label[2]")).click();
		WebElement breed = driver.findElement(By.xpath("//*[@id=\"breedname\"]"));
		breed.clear();
		Thread.sleep(1000);
		breed.sendKeys("Englis");
		Thread.sleep(1000);
		breed.sendKeys("h");
		Thread.sleep(3000);
		//select name from breed list
		driver.findElement(By.xpath("/html/body/ul[2]/li")).click();
		WebElement year = driver.findElement(By.xpath("//*[@id=\"age_year\"]"));
		year.clear();
		year.sendKeys("0");
		WebElement month = driver.findElement(By.xpath("//*[@id=\"age_month\"]"));
		month.clear();
		month.sendKeys("2");
		WebElement name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		name.clear();
		name.sendKeys("DogFemale");
		Robot rb = new Robot();
		WebElement chooseFile = driver.findElement(By.xpath("//div[@class='add-photo']/div"));
		chooseFile.click();
		rb.setAutoDelay(4000);
		StringSelection ss = new StringSelection("E:\\a2.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[7]/div[2]/div/button")).click();

	}

	// Add Address
	public void editAddress(WebDriver driver) throws InterruptedException {

		List<WebElement> petlist = driver.findElements(By.xpath(
				"//div[@class='additional-addresses history']/div/div/div[3]/a[@class='action edit']"));
		for (int k = 0; k < petlist.size(); k++) {

			petlist.get(1).click();
			break;
		}
		WebElement street=driver.findElement(By.xpath("//div[@class='control']/input[@id='street_1']"));
		street.clear();
		street.sendKeys("32/7 Royal Road");
		WebElement city=driver.findElement(By.id("city"));
		city.clear();
		city.sendKeys("Delhi");
		Thread.sleep(2000);
		Select reigon = new Select(driver.findElement(By.id("region_id")));
		reigon.selectByVisibleText("Delhi");
		WebElement zip=driver.findElement(By.id("zip"));
		zip.clear();
		zip.sendKeys("110007");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		Thread.sleep(2000);
	}
}
