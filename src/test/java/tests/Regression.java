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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.WebDriverTasks;
import pages.DynamicLoadingPage;
import pages.HomePage;

public class Regression {

	@BeforeMethod
	public void startWebDriver() throws MalformedURLException {

		//String baseUrl = "https://the-internet.herokuapp.com/";

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	
		WebDriverTasks.startWebDriver("localchrome");
		WebDriverTasks.goToURL("https://the-internet.herokuapp.com");
		WebDriverTasks.maximizeWindow();

	}
	
	/* 
	@BeforeMethod
	@Parameters({"browser", "url"})	
	public void startWebDriver(String browser, String url) throws MalformedURLException {

		//String baseUrl = "https://the-internet.herokuapp.com/";

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("The url is " +url);
		WebDriverTasks.startWebDriver(browser);
		WebDriverTasks.goToURL(url);
		WebDriverTasks.maximizeWindow();

	}
	 */

	@Test
	public void dynamicLoadingTestExample1() {
		HomePage.verifyHomePageTitle();
		HomePage.clickOnDynamicLoadingLink();
		DynamicLoadingPage.verifydynamicLoadingPageHeader();
		DynamicLoadingPage.clickOnExample1Link();
		DynamicLoadingPage.clickOnStartButton();
		DynamicLoadingPage.waitForTextToAppear();
	}

	@Test
	public void dynamicLoadingTestExample2() {
		HomePage.verifyHomePageTitle();
		HomePage.clickOnDynamicLoadingLink();
		DynamicLoadingPage.verifydynamicLoadingPageHeader();
		DynamicLoadingPage.clickOnExample2Link();
		DynamicLoadingPage.clickOnStartButton();
		DynamicLoadingPage.waitForTextToAppear();
	}
	
	@Test
	public void authenticationPage() {
		HomePage.verifyHomePageTitle();
		HomePage.clickOnAuthenticationPageLink();
	}

	@AfterMethod
	public void closeWebDriver() {
		WebDriverTasks.closeWindow();
		WebDriverTasks.quitWebDriver();
	}




}
