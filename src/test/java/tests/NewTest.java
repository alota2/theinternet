package tests;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters({"browser", "url"})	
	public void startWebDriver(String browser, String url) throws MalformedURLException {
		String baseUrl = url;
		
		//String baseUrl = "https://the-internet.herokuapp.com/";
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		System.out.println("The url is " +baseUrl);
		
		String projectPath = System.getProperty("user.dir");

		if(browser.equalsIgnoreCase("localchrome")) {
			System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/browserdrivers/chromedriver");
			driver = new ChromeDriver();

		}
		
		if(browser.equalsIgnoreCase("localfirefox")) {
			System.setProperty("webdriver.gecko.driver",projectPath+"/src/test/resources/browserdrivers/geckodriver");
			driver = new FirefoxDriver();

		}
		
		if(browser.equalsIgnoreCase("localinternetexplorer")) {
			System.setProperty("webdriver.ie.driver",projectPath+"/src/test/resources/browserdrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		
		if(browser.equalsIgnoreCase("remotechrome")) {
			new DesiredCapabilities();
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		}
		
		if(browser.equalsIgnoreCase("remotefirefox")) {
			new DesiredCapabilities();
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		}
		
		if(browser.equalsIgnoreCase("remoteinternetexplorer")) {
			new DesiredCapabilities();
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		}
		
		
		driver.get(baseUrl);
	}
  
  @Test
  public void dynamicLoadingTest() {
	  System.out.println("test comment");
	  
	     driver.manage().window().maximize();
	     String expectedHomePageTitle = "The Internet";
	     String homePageTitle = driver.getTitle();
	     
	     //assertTrue(homePageTitle.equals(expectedHomePageTitle));
	     
	     assertEquals(homePageTitle , expectedHomePageTitle);
	     
	     System.out.println("home page title is " + homePageTitle);
	     
	     driver.findElement(By.linkText("Dynamic Loading")).click();
	   
	     String dynamicLoadingHeading = driver.findElement(By.tagName("h3")).getText().toString();
	     
	     String dynamicLoadingExpected = "Dynamically Loaded Page Elements";
	     
	     assertEquals(dynamicLoadingHeading , dynamicLoadingExpected);
	     
	     driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
	     
	     driver.findElement(By.id("start")).findElement(By.tagName("Button")).click();
	     
	     WebDriverWait wait = new WebDriverWait(driver, 10);
	     
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#finish > h4")));
	     
	    String elementThatLoadsLater =  driver.findElement(By.id("finish")).findElement(By.tagName("h4")).getText().toString();
	    
	    System.out.println(elementThatLoadsLater);
	     
	     //driver.findElement(By.tagName("Button")).click();
	     
	     
	       	    
  }
}
