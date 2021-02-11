package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	private WebDriver driver;
  	
	private By emailInput = By.id("email");
	private By passwordInput = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By logOutButton = By.className("logout");
	private By welcomeMessage = By.xpath("//p[@class='info-account' and contains(text(),'Welcome to your account')]");
	private By errorMessage = By.className("alert-danger");
	
	private By myAddressesPage = By.xpath("//a[@title=\"Addresses\"]");
	private By myPersonalInformationPage = By.xpath("//a[@title='Information']");
	private By myWishlistsPage = By.xpath("//a[@title='My wishlists']");
	private By dressesPage = By.xpath("//a[@title='Dresses']");
			
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Insert into fields
	public MyAccountPage insertEmail(String email) {
		driver.findElement(emailInput).sendKeys(email);
		return this;
	}
	
	public MyAccountPage insertPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
		return this;
	}
	
	// Click buttons
	public MyAccountPage clickSignInButton() {
		driver.findElement(signInButton).click();
		return this;
	}
	
	public MyAccountPage clickLogOutButton() {
		driver.findElement(logOutButton).click();
		return this;
	}
	
	// Click pages
	public MyAccountPage clickMyAddressesPage() {
		driver.findElement(myAddressesPage).click();
		return this;
	}
	
	public MyAccountPage clickMyPersonalInformationPage() {
		driver.findElement(myPersonalInformationPage).click();
		return this;
	}
	
	public MyAccountPage clickMyWishlistsPage() {
		driver.findElement(myWishlistsPage).click();
		return this;
	}
	
	public MyAccountPage clickDressesPage() {
		driver.findElement(dressesPage).click();
		return this;
	}
	
	// Display messages
	public boolean errorMessageIsDisplayed() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public boolean welcomeMessageIsDisplayed() {
		return driver.findElement(welcomeMessage).isDisplayed();
	}
}
