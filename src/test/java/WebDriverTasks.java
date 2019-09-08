import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class WebDriverTasks {
	
	WebDriver driver;
	
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
  

}
