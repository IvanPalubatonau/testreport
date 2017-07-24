package by.htp.testreport.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WriteMailPage extends BasePage {
	@FindBy(xpath = "//textarea[@class='js-input compose__labels__input']")
	private WebElement adress;
	@FindBy(xpath = "//input[@class='b-input']")
	private WebElement themeOfMail;
	@FindBy(xpath = "//iframe[@allowtransparency='true']")
	private WebElement frame;
	@FindBy(xpath = ".//*[@id='tinymce']")
	private WebElement textOfMail;
	@FindBy(xpath = ".//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']")
	private WebElement buttonSend;

	public WriteMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void enterForWhoMailAndTheme(String forWho, String theme) {

		adress.click();
		adress.sendKeys(forWho);
		themeOfMail.click();
		themeOfMail.sendKeys(theme);
	}

	public void enterTextOfMail(String text) {

		driver.switchTo().frame(frame);
		textOfMail.click();
		textOfMail.sendKeys(text);
		driver.switchTo().parentFrame();
	}

	public void sendMail() {

		buttonSend.click();

	}

}
