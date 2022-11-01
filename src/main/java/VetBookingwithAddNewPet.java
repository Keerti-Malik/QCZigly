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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VetBookingwithAddNewPet {

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
		WebElement element = driver.findElement(By.xpath("//ul[@class='manage-pets']/li[5]/div/label"));
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
		
	}

	public void addNewPet() throws InterruptedException, Exception {
		// select type
		driver.findElement(By.xpath("//div[@class='breed-control type']/label[2]")).click();
		Thread.sleep(1000);
		// select gender
		driver.findElement(By.xpath("//div[@class='breed-control petgender']/label[1]")).click();
		Thread.sleep(1000);
		// Select breed
		driver.findElement(By.xpath("//*[@id=\"breedname\"]")).sendKeys("Siamese Cat");
		Thread.sleep(3000);
		// add age
		driver.findElement(By.xpath("/html/body/ul[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"age_year\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"age_month\"]")).sendKeys("1");
		// enter name
		WebElement we = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		we.clear();
		we.sendKeys("Luffy");
		Robot rb = new Robot();
		// click on add photo
		WebElement AddPhoto5mb = driver.findElement(By.xpath("//div[@class='add-photo']/div/label"));
		AddPhoto5mb.click();
		rb.setAutoDelay(5000);
		StringSelection ss = new StringSelection("E:\\SampleJPGImage_5mbmb.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(2000);
		//print msg if file size more than 5 MB
		WebElement print= driver.findElement(By.className("mage-error"));
			String msg=	print.getText();
		System.out.println(msg);
		//again Select picture and add
		WebElement AddPhoto2mb = driver.findElement(By.xpath("//div[@class='add-photo']/div/label"));
		AddPhoto2mb.click();
		rb.setAutoDelay(4000);
		StringSelection ss2 = new StringSelection("E:\\a1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
		rb.setAutoDelay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		// click on ADD PET
				driver.findElement(By.xpath("//*[@id=\"managepet-form\"]/fieldset[7]/div[2]/div/button")).click();

	}
}
