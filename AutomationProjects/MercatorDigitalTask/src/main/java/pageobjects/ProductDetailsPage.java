package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//button[@id='add-to-cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@id='shopping_cart_container']/a")
	private WebElement cartIconLink;
	
	public void addProductToCart() throws InterruptedException {
		
		addToCartBtn.click();
		Thread.sleep(5000);
		cartIconLink.click();
		Thread.sleep(5000);
	}
}
