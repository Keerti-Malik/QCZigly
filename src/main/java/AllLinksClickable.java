import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllLinksClickable {

	private WebDriver driver;
	 JavascriptExecutor js ;
	
	@BeforeTest
	public void setup() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		  js = (JavascriptExecutor) driver;
		  String baseUrl = "https://qc.zigly.com/";
			driver.get(baseUrl);
			Thread.sleep(2000);
			driver.manage().window().maximize();
		  
	}
	
	@Test(priority=1)
	public void homePageLink() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//link1
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[1]")).click();
		String currenturl=driver.getCurrentUrl();
		String expectedurl="https://qc.zigly.com/shop/dogs.html";
		Assert.assertEquals(currenturl, expectedurl);
		System.out.println(currenturl);
		Thread.sleep(2000);
		driver.navigate().back();
		//link2
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[2]")).click();
		String currenturl1=driver.getCurrentUrl();
		String expectedurl1="https://qc.zigly.com/shop/for-cats.html";
		Assert.assertEquals(currenturl1, expectedurl1);
		System.out.println(currenturl1);
		Thread.sleep(2000);
		driver.navigate().back();
		//link3
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[3]")).click();
		String currenturl2=driver.getCurrentUrl();
		String expectedurl2="https://qc.zigly.com/services/pet-grooming/home";
		Assert.assertEquals(currenturl2, expectedurl2);
		System.out.println(currenturl2);
		Thread.sleep(2000);
		driver.navigate().back();
		//link4
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[4]")).click();
		String currenturl3=driver.getCurrentUrl();
		String expectedurl3="https://qc.zigly.com/online-vet-consultation";
		Assert.assertEquals(currenturl3, expectedurl3);
		System.out.println(currenturl3);
		Thread.sleep(2000);
		driver.navigate().back();
		//link5
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[5]")).click();
		String currenturl4=driver.getCurrentUrl();
		String expectedurl4="https://qc.zigly.com/blog.html";
		Assert.assertEquals(currenturl4, expectedurl4);
		System.out.println(currenturl4);
		Thread.sleep(2000);
		driver.navigate().back();
		//link6
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/div[6]")).click();
		String currenturl5=driver.getCurrentUrl();
		String expectedurl5="https://qc.zigly.com/experience-center";
		Assert.assertEquals(currenturl5, expectedurl5);
		System.out.println(currenturl5);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	@Test(priority=2)
	public void newlink() throws InterruptedException {
		
		//link7
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,150)");
	   driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[8]/div[2]/div[2]")).click();
	   String currenturl6=driver.getCurrentUrl();
		String expectedurl6="https://qc.zigly.com/shop/dogs/dog-food.html";
		Assert.assertEquals(currenturl6, expectedurl6);
		System.out.println(currenturl6);
		Thread.sleep(2000);
		driver.navigate().back();	
		//link8
		js.executeScript("window.scrollTo(0,150)");
		   driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[8]/div[2]/div[3]")).click();
		   String currenturl7=driver.getCurrentUrl();
			String expectedurl7="https://qc.zigly.com/shop/dogs/dog-treats.html";
			Assert.assertEquals(currenturl7, expectedurl7);
			System.out.println(currenturl7);
			Thread.sleep(2000);
			driver.navigate().back();
		 
			//link9
		js.executeScript("window.scrollTo(0,150)");
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[8]/div[2]/div[4]")).click();
	    String currenturl8=driver.getCurrentUrl();
		String expectedurl8="https://qc.zigly.com/shop/dogs/dog-toys.html";
		Assert.assertEquals(currenturl8, expectedurl8);
		System.out.println(currenturl8);
		Thread.sleep(2000);
		driver.navigate().back();
			//link10
		js.executeScript("window.scrollTo(0,150)");
	    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[8]/div[2]/div[5]")).click();
		String currenturl9=driver.getCurrentUrl();
	    String expectedurl9="https://qc.zigly.com/shop/dogs/bowls-feeders-and-food-mats.html";
	    Assert.assertEquals(currenturl9, expectedurl9);
		System.out.println(currenturl9);
		Thread.sleep(1000);		
		driver.navigate().back();	
		//link11
				js.executeScript("window.scrollTo(0,150)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[8]/div[2]/div[6]")).click();
				String currenturl10=driver.getCurrentUrl();
			    String expectedurl10="https://qc.zigly.com/shop/dogs/collars-harnesses-leashes.html";
			    Assert.assertEquals(currenturl10, expectedurl10);
				System.out.println(currenturl10);
				Thread.sleep(1000);		
				driver.navigate().back();
	   //link12
				js.executeScript("window.scrollTo(0,150)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[8]/div[2]/div[7]")).click();
				String currenturl11=driver.getCurrentUrl();
			    String expectedurl11="https://qc.zigly.com/beboji-collection";
			    Assert.assertEquals(currenturl11, expectedurl11);
				System.out.println(currenturl11);
				Thread.sleep(1000);		
				driver.navigate().back();
	//link13
				js.executeScript("window.scrollTo(0,150)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[9]/div/div[2]/div[1]")).click();
				String currenturl12=driver.getCurrentUrl();
			    String expectedurl12="https://qc.zigly.com/shop/dogs.html?z_breedsize=3065";
			    Assert.assertEquals(currenturl12, expectedurl12);
				System.out.println(currenturl12);
				Thread.sleep(1000);		
				driver.navigate().back();
	//link14
				js.executeScript("window.scrollTo(0,150)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[9]/div/div[2]/div[2]")).click();
				String currenturl13=driver.getCurrentUrl();
			    String expectedurl13="https://qc.zigly.com/shop/dogs.html?z_breedsize=3066";
			    Assert.assertEquals(currenturl13, expectedurl13);
				System.out.println(currenturl13);
				Thread.sleep(1000);		
				driver.navigate().back();
	//link15
				js.executeScript("window.scrollTo(0,150)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[9]/div/div[2]/div[3]")).click();
				String currenturl14=driver.getCurrentUrl();
			    String expectedurl14="https://qc.zigly.com/shop/dogs.html?z_breedsize=3067";
			    Assert.assertEquals(currenturl14, expectedurl14);
				System.out.println(currenturl14);
				Thread.sleep(1000);		
				driver.navigate().back();
	//link16
				js.executeScript("window.scrollTo(0,150)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[9]/div/div[2]/div[4]")).click();
				String currenturl15=driver.getCurrentUrl();
			    String expectedurl15="https://qc.zigly.com/shop/dogs.html?z_breedsize=3068";
			    Assert.assertEquals(currenturl15, expectedurl15);
				System.out.println(currenturl15);
				Thread.sleep(1000);		
				driver.navigate().back();
	//link added			
				js.executeScript("window.scrollTo(0,200)");//*[@id="maincontent"]/div[3]/div/div[10]/div/div/div[2]/a/picture/img
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[2]/a")).click();
				String currenturl152=driver.getCurrentUrl();
			    String expectedurl152="https://qc.zigly.com/searchtap/results?q=earthborn";
			    Assert.assertEquals(currenturl152, expectedurl152);
				System.out.println(currenturl152);
				Thread.sleep(1000);		
				driver.navigate().back();
	
		//link19
				js.executeScript("window.scrollTo(0,200)");//*[@id="maincontent"]/div[3]/div/div[10]/div/div/div[3]
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[3]")).click();
				String currenturl18=driver.getCurrentUrl();
			    String expectedurl18="https://qc.zigly.com/brand/royal-canin";
			    Assert.assertEquals(currenturl18, expectedurl18);
				System.out.println(currenturl18);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link20
				js.executeScript("window.scrollTo(0,200)");//*[@id="maincontent"]/div[3]/div/div[10]/div/div/div[4]
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[4]")).click();
				String currenturl19=driver.getCurrentUrl();
			    String expectedurl19="https://qc.zigly.com/brand/waudog";
			    Assert.assertEquals(currenturl19, expectedurl19);
				System.out.println(currenturl19);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link21
				js.executeScript("window.scrollTo(0,200)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[5]")).click();
				String currenturl20=driver.getCurrentUrl();
			    String expectedurl20="https://qc.zigly.com/beboji-collection";
			    Assert.assertEquals(currenturl20, expectedurl20);
				System.out.println(currenturl20);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link22
				js.executeScript("window.scrollTo(0,200)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[6]")).click();
				String currenturl21=driver.getCurrentUrl();
			    String expectedurl21="https://qc.zigly.com/brand/jerhigh";
			    Assert.assertEquals(currenturl21, expectedurl21);
				System.out.println(currenturl21);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link23
				js.executeScript("window.scrollTo(0,200)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[7]")).click();
				String currenturl22=driver.getCurrentUrl();
			    String expectedurl22="https://qc.zigly.com/brand/chip-chops";
			    Assert.assertEquals(currenturl22, expectedurl22);
				System.out.println(currenturl22);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link24
				js.executeScript("window.scrollTo(0,200)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[8]")).click();
				String currenturl23=driver.getCurrentUrl();
			    String expectedurl23="https://qc.zigly.com/brand/dogsee-chew";
			    Assert.assertEquals(currenturl23, expectedurl23);
				System.out.println(currenturl23);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link25
				js.executeScript("window.scrollTo(0,200)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[9]")).click();
				String currenturl24=driver.getCurrentUrl();
			    String expectedurl24="https://qc.zigly.com/brand/Bennys-Bowl";
			    Assert.assertEquals(currenturl24, expectedurl24);
				System.out.println(currenturl24);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link26
				js.executeScript("window.scrollTo(0,200)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[10]")).click();
				String currenturl25=driver.getCurrentUrl();
			    String expectedurl25="https://qc.zigly.com/brand/kong";
			    Assert.assertEquals(currenturl25, expectedurl25);
				System.out.println(currenturl25);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link added
				js.executeScript("window.scrollTo(0,200)");//*[@id="maincontent"]/div[3]/div/div[10]/div/div/div[11]
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[11]")).click();
				String currenturl153=driver.getCurrentUrl();
			    String expectedurl153="https://qc.zigly.com/brand/captain-zack";
			    Assert.assertEquals(currenturl153, expectedurl153);
				System.out.println(currenturl153);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link27
				js.executeScript("window.scrollTo(0,200)");
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[12]")).click();
				String currenturl26=driver.getCurrentUrl();
			    String expectedurl26="https://qc.zigly.com/brand/Orijen";
			    Assert.assertEquals(currenturl26, expectedurl26);
				System.out.println(currenturl26);
				Thread.sleep(1000);		
				driver.navigate().back();
		/*//link28
				js.executeScript("window.scrollTo(0,210)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[12]")).click();
				String currenturl27=driver.getCurrentUrl();
			    String expectedurl27="https://qa.zigly.com/brand/gigwi";
			    Assert.assertEquals(currenturl27, expectedurl27);
				System.out.println(currenturl27);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link29
				js.executeScript("window.scrollTo(0,210)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[13]")).click();
				String currenturl28=driver.getCurrentUrl();
			    String expectedurl28="https://qa.zigly.com/brand/trixie";
			    Assert.assertEquals(currenturl28, expectedurl28);
				System.out.println(currenturl28);
				Thread.sleep(1000);		
				driver.navigate().back();*/
	//link18
				js.executeScript("window.scrollTo(0,200)");//*[@id="maincontent"]/div[3]/div/div[10]/div/div/div[13]
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[10]/div/div/div[13]")).click();
				String currenturl17=driver.getCurrentUrl();
			    String expectedurl17="https://qc.zigly.com/brand/Pedigree";
			    Assert.assertEquals(currenturl17, expectedurl17);
				System.out.println(currenturl17);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link30
				js.executeScript("window.scrollTo(0,210)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"offers-card\"]/div[1]/div/div[4]/div/a")).click();
				String currenturl29=driver.getCurrentUrl();
			    String expectedurl29="https://qc.zigly.com/services/pet-grooming/home";
			    Assert.assertEquals(currenturl29, expectedurl29);
				System.out.println(currenturl29);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link31
				js.executeScript("window.scrollTo(0,210)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"offers-card\"]/div[1]/div/div[5]/div/a")).click();
				String currenturl30=driver.getCurrentUrl();
			    String expectedurl30="https://qc.zigly.com/online-vet-consultation";
			    Assert.assertEquals(currenturl30, expectedurl30);
				System.out.println(currenturl30);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link32
				js.executeScript("window.scrollTo(0,210)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"offers-card\"]/div[1]/div/div[6]/div/a")).click();
				String currenturl31=driver.getCurrentUrl();
			    String expectedurl31="https://qc.zigly.com/services/pet-grooming/experience";
			    Assert.assertEquals(currenturl31, expectedurl31);
				System.out.println(currenturl31);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link33
				js.executeScript("window.scrollTo(0,210)");
				Thread.sleep(1000);//*[@id="maincontent"]/div[3]/div/div[12]/div/div[4]/a[1]/button
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[12]/div/div[4]/a[1]")).click();
				String currenturl32=driver.getCurrentUrl();
			    String expectedurl32="https://qc.zigly.com/experience-center";
			    Assert.assertEquals(currenturl32, expectedurl32);
				System.out.println(currenturl32);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link34
				js.executeScript("window.scrollTo(0,250)");
				Thread.sleep(1000);//*[@id="maincontent"]/div[3]/div/div[13]/div/div[1]/div[2]/div[1]/div[1]
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[13]/div/div[1]/div[2]/div[1]/div[1]")).click();
				String currenturl33=driver.getCurrentUrl();
			    String expectedurl33="https://qc.zigly.com/blog/post/pet-parenting-101-stage-wise-guide-to-taking-care-of-the-pet-mom-to-be.html";
			    Assert.assertEquals(currenturl33, expectedurl33);
				System.out.println(currenturl33);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link35
				js.executeScript("window.scrollTo(0,250)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[13]/div/div[1]/div[2]/div[2]/div[1]")).click();
				String currenturl34=driver.getCurrentUrl();
			    String expectedurl34="https://qc.zigly.com/blog/post/how-do-you-tell-the-difference-between-ticks-fleas.html";
			    Assert.assertEquals(currenturl34, expectedurl34);
				System.out.println(currenturl34);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link36
				js.executeScript("window.scrollTo(0,250)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[13]/div/div[1]/div[2]/div[3]/div[1]")).click();
				String currenturl35=driver.getCurrentUrl();
			    String expectedurl35="https://qc.zigly.com/blog/post/what-to-expect-from-a-tick-and-flea-treatment-package.html";
			    Assert.assertEquals(currenturl35, expectedurl35);
				System.out.println(currenturl35);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link37
				js.executeScript("window.scrollTo(0,250)");
				Thread.sleep(1000);//*[@id="maincontent"]/div[3]/div/div[13]/div/div[2]
			    driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[13]/div/div[2]/a")).click();
				String currenturl36=driver.getCurrentUrl();
			    String expectedurl36="https://qc.zigly.com/blog.html";
			    Assert.assertEquals(currenturl36, expectedurl36);
				System.out.println(currenturl36);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link38--Quick Link
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[1]/div[2]")).click();
				String currenturl37=driver.getCurrentUrl();
			    String expectedurl37="https://qc.zigly.com/contact";
			    Assert.assertEquals(currenturl37, expectedurl37);
				System.out.println(currenturl37);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link39--Quick Link
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[1]/div[3]/a")).click();
				String currenturl38=driver.getCurrentUrl();
			    String expectedurl38="https://qc.zigly.com/knowledge-base/frequently-asked/";
			    Assert.assertEquals(currenturl38, expectedurl38);
				System.out.println(currenturl38);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link40--Services
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[2]/div[2]/a[1]")).click();
				String currenturl39=driver.getCurrentUrl();
			    String expectedurl39="https://qc.zigly.com/services/pet-grooming/home";
			    Assert.assertEquals(currenturl39, expectedurl39);
				System.out.println(currenturl39);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link41--Services
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[2]/div[2]/a[2]")).click();
				String currenturl40=driver.getCurrentUrl();
			    String expectedurl40="https://qc.zigly.com/online-vet-consultation";
			    Assert.assertEquals(currenturl40, expectedurl40);
				System.out.println(currenturl40);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link42--Services
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[2]/div[2]/a[3]")).click();
				String currenturl41=driver.getCurrentUrl();
			    String expectedurl41="https://qc.zigly.com/blog.html";
			    Assert.assertEquals(currenturl41, expectedurl41);
				System.out.println(currenturl41);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link43--Explore
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[3]/div[2]/a[1]")).click();
				String currenturl42=driver.getCurrentUrl();
			    String expectedurl42="https://qc.zigly.com/about-us";
			    Assert.assertEquals(currenturl42, expectedurl42);
				System.out.println(currenturl42);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link44--Explore
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[3]/div[2]/a[2]")).click();
				String currenturl43=driver.getCurrentUrl();
			    String expectedurl43="https://qc.zigly.com/experience-center";
			    Assert.assertEquals(currenturl43, expectedurl43);
				System.out.println(currenturl43);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link45--Explore
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[3]/div[2]/a[3]")).click();
				String currenturl44=driver.getCurrentUrl();
			    String expectedurl44="https://qc.zigly.com/blog.html";
			    Assert.assertEquals(currenturl44, expectedurl44);
				System.out.println(currenturl44);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link46--Explore
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[3]/div[2]/a[4]")).click();
				String currenturl45=driver.getCurrentUrl();
			    String expectedurl45="https://qc.zigly.com/in-the-news";
			    Assert.assertEquals(currenturl45, expectedurl45);
				System.out.println(currenturl45);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link47--Policies
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[4]/div[2]/a[1]")).click();
				String currenturl46=driver.getCurrentUrl();
			    String expectedurl46="https://qc.zigly.com/privacy-and-cookie-policy";
			    Assert.assertEquals(currenturl46, expectedurl46);
				System.out.println(currenturl46);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link48--Policies
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[4]/div[2]/a[2]")).click();
				String currenturl47=driver.getCurrentUrl();
			    String expectedurl47="https://qc.zigly.com/terms-of-use";
			    Assert.assertEquals(currenturl47, expectedurl47);
				System.out.println(currenturl47);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link49--Policies
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[4]/div[2]/a[3]")).click();
				String currenturl48=driver.getCurrentUrl();
			    String expectedurl48="https://qc.zigly.com/promotions-cashback-offers";
			    Assert.assertEquals(currenturl48, expectedurl48);
				System.out.println(currenturl48);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link50--Policies
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[4]/div[2]/a[4]")).click();
				String currenturl49=driver.getCurrentUrl();
			    String expectedurl49="https://qc.zigly.com/shipping-and-delivery-policy";
			    Assert.assertEquals(currenturl49, expectedurl49);
				System.out.println(currenturl49);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link51--Policies
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[4]/div[2]/a[5]")).click();
				String currenturl50=driver.getCurrentUrl();
			    String expectedurl50="https://qc.zigly.com/customer-grievances";
			    Assert.assertEquals(currenturl50, expectedurl50);
				System.out.println(currenturl50);
				Thread.sleep(1000);		
				driver.navigate().back();
				
		//link52--Policies
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[4]/div[2]/a[6]")).click();
				String currenturl51=driver.getCurrentUrl();
			    String expectedurl51="https://qc.zigly.com/cancellation-return-exchange-and-refund-policy";
			    Assert.assertEquals(currenturl51, expectedurl51);
				System.out.println(currenturl51);
				Thread.sleep(1000);		
				driver.navigate().back();
		//link53--Social Media Link-whatsapp
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[1]/div[5]/div[2]/p[2]")).click();
				Thread.sleep(1000);		
				driver.navigate().to("https://qc.zigly.com/");
		//link54--Social Media Link--linkedin
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[2]/ul/li[6]/a")).click();
				Thread.sleep(1000);		
				driver.navigate().to("https://qc.zigly.com/");
	    //link55--Social Media Link--facebook
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[2]/ul/li[1]/a")).click();
				Thread.sleep(1000);		
				driver.navigate().to("https://qc.zigly.com/");
	   //link56--Social Media Link--instagram
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[2]/ul/li[2]/a")).click();
				Thread.sleep(1000);		
				driver.navigate().to("https://qc.zigly.com/");
      //link57--Social Media Link--twitter
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[2]/ul/li[4]/a")).click();
				Thread.sleep(1000);		
				driver.navigate().to("https://qc.zigly.com/");
		//link58--Social Media Link--youtube
				js.executeScript("window.scrollTo(0,270)");
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/footer/div[3]/div/div/div/div[2]/ul/li[5]/a")).click();
				Thread.sleep(1000);		
				driver.navigate().to("https://qc.zigly.com/");
	}
	
	
}
