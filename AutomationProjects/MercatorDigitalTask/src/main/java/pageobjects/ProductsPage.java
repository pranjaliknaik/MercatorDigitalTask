package pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.regex.Matcher;

public class ProductsPage {
	
WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[text()='Products']")
	private WebElement editYourAccountInformationOption;
	
	public boolean verifyDisplayOfProducts() throws InterruptedException {
		Thread.sleep(3000);
		return editYourAccountInformationOption.isDisplayed();
		
	}
	
	@FindBy(css = "[class='inventory_item_price']")
	private List<WebElement> productPrices;
	
	private List<Float> productPriceValues = new ArrayList<Float>();
	
	public void FindGreatestPrice() throws InterruptedException {
		for(int i=0; i<productPrices.size();i++) {
			if(productPrices.get(i).getText() !="") {
				productPriceValues.add(Float.parseFloat(productPrices.get(i).getText().replaceAll("[$]", "")));
				
			}
		}
		
		Collections.sort(productPriceValues);
		Float greatestPrice = productPriceValues.get(productPriceValues.size()-1);
		ClickOnHightestPriceItem(greatestPrice);
	}
	
	public ProductDetailsPage ClickOnHightestPriceItem(Float greatestPrice) throws InterruptedException {
		WebElement highestPriceItemLink= driver.findElement(By.xpath("//div[text()='"+greatestPrice+"']//preceding::a[1]"));
		highestPriceItemLink.click();
		return new ProductDetailsPage(driver);
	}
	
	
}
