package core;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class WebDriverTasks {
	
	public static WebDriver driver;
		
	public static void startWebDriver(String browser) throws MalformedURLException {
		
		
		//String baseUrl = "https://the-internet.herokuapp.com/";
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
		
		
	}
	
	public static void goToURL(String url) {
		driver.get(url);
		
	}
	
	public static void maximizeWindow() {
	
		driver.manage().window().maximize();
		
	}
	
	public static void closeWindow() {
		
		driver.close();
		
	}
	
public static void quitWebDriver() {
		
		driver.quit();
		
	}
	

  

}
