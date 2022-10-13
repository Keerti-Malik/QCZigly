import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class Browsercode {
	WebDriver driver=null;
	@BeforeSuite
	public void demoBrowser(String browser){
	  if (browser.equalsIgnoreCase("Firefox")) {
	     driver = new FirefoxDriver();
	  }
	  else if (browser.equalsIgnoreCase("Chrome")) {
	     System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	  }
	  else {
	     System.out.println("invalid browser name");
	  }
	}

}

