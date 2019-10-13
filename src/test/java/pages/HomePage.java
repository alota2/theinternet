package pages;
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

import core.WebDriverTasks;

public class HomePage extends WebDriverTasks {
	
static By DynamicLoadingLocator = By.linkText("Dynamic Loading");
static By authenticationPageLocator = By.linkText("Basic Auth");

public static void clickOnAuthenticationPageLink() {
	  driver.findElement(authenticationPageLocator).click();
}

  public static void clickOnDynamicLoadingLink() {
	  driver.findElement(DynamicLoadingLocator).click();
  }
  
  public static String verifyHomePageTitle() {
	  String expectedHomePageTitle = "The Internet";
	     String homePageTitle = driver.getTitle();
	     
	     //assertTrue(homePageTitle.equals(expectedHomePageTitle));
	     
	     assertEquals(homePageTitle , expectedHomePageTitle);
	     
	     System.out.println("home page title is " + homePageTitle);
	     
	     return homePageTitle;
  }
}
