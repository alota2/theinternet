import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	
  @Parameters({"url"})	
  @Test
  public void f(String url) {
	  System.out.println("test comment");
	  
	  //String baseUrl = "https://the-internet.herokuapp.com/";
	  String baseUrl = url;
	  
	  System.out.println("The url is " +baseUrl);
	  
	  System.setProperty("webdriver.chrome.driver","/home/lesly/Downloads/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 driver.get(baseUrl);
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
