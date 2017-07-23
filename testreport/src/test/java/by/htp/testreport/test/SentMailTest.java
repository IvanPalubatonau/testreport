package by.htp.testreport.test;




import org.apache.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import by.htp.testreport.pageobject.MailBoxPage;
import by.htp.testreport.pageobject.MainPage;
import by.htp.testreport.pageobject.WriteMailPage;

public class SentMailTest extends BaseTest {
	private static final Logger LOG = Logger.getLogger(SentMailTest.class);
    String quantityMailBefore;
    String quantityMailAfter;
	@BeforeClass
	public void loginAndWrite() {

		LOG.warn("start: navigate");
		MainPage mainPage = navigate(MainPage.URL);

		LOG.warn("start: login");
		LOG.info("enter: tathtp@mail.ru Klopik123 ");
		MailBoxPage mailBoxPage = mainPage.login("tathtp@mail.ru", "Klopik123");
		quantityMailBefore=mailBoxPage.quantitySentMail();
		//System.out.println(quantityMailBefore);
		LOG.info("openWriteMailPage ");
		WriteMailPage writeMailPage=mailBoxPage.openWriteMailPage();
		LOG.info("enter:tathtp@mail.ru IvanHomeWork");
		writeMailPage.enterForWhoMailAndTheme("tathtp@mail.ru", "IvanHomeWork");
		LOG.info("enter text of Mail:Ivan Here");
		writeMailPage.enterTextOfMail("Ivan Was Here");
		LOG.info("send letter");
		writeMailPage.sendMail();
		quantityMailAfter=mailBoxPage.quantitySentMail();
	} 

	@Test
	public void sentLetterTest() {
		LOG.warn("MailBefore"+" "+quantityMailBefore);
		LOG.warn("MailAfter"+" "+quantityMailAfter);
		Assert.assertNotEquals(quantityMailBefore, quantityMailAfter);
		}
	}

