package by.htp.testreport.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import by.htp.testreport.pageobject.MainPage;

public class LoginTest extends BaseTest {

	private static final Logger LOG = Logger.getLogger(LoginTest.class);

	/*@Test
	public void doLogin() {
	
		
		LOG.warn("start: navigate");
		MainPage mainPage = navigate(MainPage.URL);
		
		LOG.warn("start: login");
		LOG.info("enter: tathtp@mail.ru Klopik123 ");
		
		mainPage.login("tathtp@mail.ru", "Klopik123");
		
		//LOG.info("start 'login;");
		// closeBrowser();
	}*/
}
