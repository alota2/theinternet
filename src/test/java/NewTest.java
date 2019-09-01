import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("test comment");
	  
	  String baseUrl = "https://www.weightwatchers.com/us/";
	  System.setProperty("webdriver.chrome.driver","/home/lesly/Downloads/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		 driver.get(baseUrl);
	     driver.manage().window().maximize();
	     String expectedHomePageTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";
	     String homePageTitle = driver.getTitle();
	     
	     //assertTrue(homePageTitle.equals(expectedHomePageTitle));
	     
	     assertEquals(homePageTitle , expectedHomePageTitle);
	     
	     System.out.println("home page title is " + homePageTitle);
	     
	    
  }
}
