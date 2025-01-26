package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="user-name")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement invalidCredentailsWarningMessage;
	
	public void enterUsername(String emailText) {
		
		usernameField.sendKeys(emailText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
	}
	
	public ProductsPage clickOnLoginButton() {
		
		loginButton.click();
		return new ProductsPage(driver);
	}
	
	/*
	 * public String retrieveInvalidCredentailsWarningMessage() {
	 * 
	 * return invalidCredentailsWarningMessage.getText();
	 * 
	 * }
	 */

}
