package tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.LoginPage;
import pageobjects.ProductDetailsPage;
import pageobjects.ProductsPage;

public class LoginTest extends Base{
	
	public WebDriver driver;
	
	
	
	@BeforeClass
	 public void setup() throws IOException {
	 
		driver = initializeBrowser(); 
	 	driver.get( prop.getProperty("url"));
	 }
	 
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority=0)
	public void loginWithValidCrendetials() throws InterruptedException {
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(prop.getProperty("validusername"));
		loginPage.enterPassword(prop.getProperty("validpassword"));
		ProductsPage productsPage = loginPage.clickOnLoginButton();		
		Assert.assertTrue(productsPage.verifyDisplayOfProducts());
		

	}
	
	@Test(priority = 1)
	public void findHighestPriceProduct() throws InterruptedException {
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.FindGreatestPrice();
	}
	
	@Test(priority = 2)
	public void verifyAddToCart() throws InterruptedException {
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addProductToCart();
	}

}
