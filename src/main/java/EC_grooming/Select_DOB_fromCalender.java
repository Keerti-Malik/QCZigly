package EC_grooming;

import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Select_DOB_fromCalender {

	WebDriver driver;

	@Test()
	public void DOB_select_from_calender() throws InterruptedException, AWTException {
		driver = OpenWebsite.openwebsite(driver);
		// click on Pet Grooming
		List<WebElement> header = driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li"));
		header.get(0).click();
		// click on AtExperienceCenter
		List<WebElement> submenu = driver
				.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/div/ul/li"));
		submenu.get(2).click();
		// click on Book Appointment
		driver.findElement(By.xpath("//div[@class='grooming-services']/div[3]/button/a")).click();
		Login.login(driver);
		// click on detect location
		driver.findElement(By.xpath("//div[@class='detect_location']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,150)", "");
		// click on add new pet
		driver.findElement(By.xpath("//li[@class='pet-listing']/div/a")).click();
		// select type
		driver.findElement(By.xpath("//div[@class='breed-control type']/label[2]")).click();
		Thread.sleep(1000);
		// select gender
		driver.findElement(By.xpath("//div[@class='breed-control petgender']/label[1]")).click();
		Thread.sleep(1000);
		// Select breed
		driver.findElement(By.xpath("//*[@id=\"breedname\"]")).sendKeys("Siamese");
		Thread.sleep(2000);
		List<WebElement> breed = driver.findElements(By.xpath(
				"//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
		for (int i = 0; i <= breed.size(); i++) {
			System.out.println(breed.get(0).getText());
			breed.get(0).click();
			break;
		}
		Thread.sleep(2000);
		// add age
		// click on DOB(option)
		driver.findElement(By.name("pet_dob")).click();
		// select calender date-month
		driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		// select date
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[3]/a")).click();
		// enter name
		WebElement we = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		we.clear();
		we.sendKeys("Luffy");
		// click on add pet button
		driver.findElement(By.xpath("//div[@class='actions-toolbar']/div/button/span")).click();
		Thread.sleep(2000);
	}
}
