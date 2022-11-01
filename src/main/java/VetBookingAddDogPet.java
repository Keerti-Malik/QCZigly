import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VetBookingAddDogPet {

	WebDriver driver = null;

	@Test
	public void vetBooking() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		// wait=new WebDriverWait(driver,30);
		Login.login(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// click on Vet Consultation
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='page-nav-section']/div/ul/li/a"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("VET CONSULTATION")) {

				list.get(i).click();
				break;
			}
		}
		// click on insta consult
		driver.findElement(By.xpath("//li[@class='parent']/div[@class='child-menu']/ul/li[2]")).click();
		// Select Add Pet
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='add-pet']/a")).click();
		addNewPet();
		WebElement element = driver.findElement(By.xpath("//ul[@class='manage-pets']/li[2]/div/label"));
		js.executeScript("arguments[0].click();", element);
		// click on NEXT button
		driver.findElement(By.name("next")).click();
		// Select Concern
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='pain-points-control type']/div[2]/label")).click();
		// click on NEXT button
		driver.findElement(By.name("next")).click();
		// select current date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		Thread.sleep(2000);
		// Select slot
		driver.findElement(By.xpath("//div[@id='grooming-timeslot']/ol/li[5]")).click();
		js.executeScript("scroll(250, 0)"); // if the element is on top.
		// click on next
		driver.findElement(By.xpath("//*[@id=\"progressbar\"]/label[2]")).click();
		Thread.sleep(2000);
		// click on book appointment
		List<WebElement> vetlist=driver.findElements(By.xpath("//div[@class='action book-appointment']/button"));
		vetlist.get(1).click();
		Thread.sleep(2000);
		// click on pay now
		driver.findElement(By.xpath(
				"//*[@id=\"vet-consulting\"]/fieldset[5]/div[1]/div/div/div/div[2]/div[2]/div[9]/fieldset/label"))
				.click();
		Thread.sleep(1000);
		// click on checkbox
		driver.findElement(By.xpath("//div[@class='terms-and-conditions-checkbox']")).click();
		Thread.sleep(2000);
		// click on make payment
		driver.findElement(By.xpath("//button[@class='btn-payment-make']")).click();
		Thread.sleep(3000);
		//move to payment page
	     driver.switchTo().frame(1);
	     Thread.sleep(2000);
	     //select payment mode
	     driver.findElement(By.xpath("//div[@class='methods-block']/div/button[3]/div/div")).click();
	     //Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[@id='bank-item-UTIB']")).click();
	     Thread.sleep(2000);
	    String parentHandle= driver.getWindowHandle();
	     System.out.println("Parent Window"+parentHandle);
	     js.executeScript("window.scrollTo(0,100)");
	     driver.findElement(By.xpath("//button[@id='redesign-v15-cta']")).click();
	     Thread.sleep(4000);
	     Set<String> handles= driver.getWindowHandles();
	     for(String handle:handles) {
	    	 System.out.println(handle);
	    	 if(!handle.equals(parentHandle)) {
	    		 driver.switchTo().window(handle);
	    		 String a=driver.getTitle();
	    		 System.out.print(a);
	    		 driver.findElement(By.xpath("/html/body/form/button[1]")).click();	
	    	 }
		}
	}

	public void addNewPet() throws InterruptedException, Exception {
		// select type
		driver.findElement(By.xpath("//div[@class='breed-control type']/label[1]")).click();
		Thread.sleep(1000);
		// select gender
		driver.findElement(By.xpath("//div[@class='breed-control petgender']/label[2]")).click();
		Thread.sleep(1000);
		// Select breed
		WebElement breed=driver.findElement(By.xpath("//*[@id=\"breedname\"]"));
				breed.sendKeys("Great Dan");
				Thread.sleep(2000);
				List<WebElement> list = driver.findElements(By.xpath(
						"//ul[@id='ui-id-176']/li/a"));
				for(int j=0; j<list.size();j++) {
				list.get(j).getText();
				}
				list.get(0).click();
				Thread.sleep(2000);


		//*[@id="ui-id-187"]/li
		//driver.findElement(By.className("managepets-wrap")).click();
		//Thread.sleep(2000);
		//Select DOB
		driver.findElement(By.id("pet_dob")).click();
		//select year
		Select year=new Select(driver.findElement(By.className("ui-datepicker-year")));
		year.selectByValue("2009");
		//select month
		Select month=new Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByValue("3");
		//Select date
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[2]")).click();
		// enter name
		WebElement we = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		we.clear();
		we.sendKeys("Tuffy");
		Robot rb = new Robot();
		// click on dog image
		driver.findElement(By.xpath("//ul[@id='static-avatar']/li[3]/label/img")).click();
		// click on ADD PET
				driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[7]/div[2]/div/button")).click();

	}
}
