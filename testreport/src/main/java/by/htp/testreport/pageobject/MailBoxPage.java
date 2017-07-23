package by.htp.testreport.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxPage extends BasePage {

	@FindBy(xpath = ".//*[@id='b-toolbar__left']/div/div/div[2]/div/a/span")
	private WebElement writeMailButton;
	@FindBy(xpath = ".//*[@id='b-nav_folders']/div/div[2]/a")
	private WebElement sentMailButton;

	public MailBoxPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WriteMailPage openWriteMailPage() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		writeMailButton.click();
		return new WriteMailPage(driver);
	}

	public String quantitySentMail() {
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String quantitySentMail = sentMailButton.getAttribute("title");

		return quantitySentMail;
	}
}
