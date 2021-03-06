package by.htp.testreport.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import by.htp.testreport.pageobject.MainPage;

@Listeners({HTMLReporter.class})
public class BaseTest {
	
	private static final Logger LOG = Logger.getLogger(BaseTest.class);

	private WebDriver driver;

	@BeforeClass
	public WebDriver startBrowser() {
		LOG.warn("start 'startBrowser'");
		System.setProperty("webdriver.gecko.driver", "d:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		LOG.warn("finish 'startBrowser'");
		return driver;
	}

	/*@Test
	protected void skipTest() {
		throw new SkipException("!!!!!Skipped");
	}*/

	protected MainPage navigate(String url) {
		//LOG.info("start 'navigate;");
		driver.get(url);
		//LOG.info("finish 'navigate'");
		return new MainPage(driver);
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void closeBrowser(){
		if(driver!=null){
			driver.quit();
		}
	}
}
