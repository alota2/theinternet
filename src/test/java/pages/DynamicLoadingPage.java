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

public class DynamicLoadingPage extends WebDriverTasks {
	
static By dynamicLoadingHeaderLocator = By.tagName("h3");
static By example1ElementLocator = By.linkText("Example 1: Element on page that is hidden");
static By example2ElementLocator = By.linkText("Example 2: Element rendered after the fact");
static By textThatLoadsLaterLocator = By.cssSelector("#finish > h4");
static By startButtonLocator = By.cssSelector("#start > Button");

  public static String verifydynamicLoadingPageHeader() {
	  
	     String dynamicLoadingHeading = driver.findElement(dynamicLoadingHeaderLocator).getText().toString();
	     
	     String dynamicLoadingExpected = "Dynamically Loaded Page Elements";
	     
	     assertEquals(dynamicLoadingHeading , dynamicLoadingExpected);	          
	        
	    return dynamicLoadingHeading;
  }
  
  public static void clickOnExample1Link() {
	  driver.findElement(example1ElementLocator).click();
  }
  
  public static void clickOnExample2Link() {
	  driver.findElement(example2ElementLocator).click();
  }
  
  public static void clickOnStartButton() {
	  driver.findElement(startButtonLocator).click();
  }
  
  public static String waitForTextToAppear() {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textThatLoadsLaterLocator));
	   String elementThatLoadsLater = element.getText().toString();
	    
	    System.out.println("The value of the element that loads later is " + elementThatLoadsLater);
	    return elementThatLoadsLater;
  }
  
 
  

}
