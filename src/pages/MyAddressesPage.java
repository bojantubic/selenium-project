package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyAddressesPage {
	private WebDriver driver;
	
	// Buttons and messages
	private By updateButton = By.xpath("//a[@title='Update']");
	private By deleteButton = By.xpath("//a[@title='Delete']");
	private By addAddressButton = By.xpath("//a[@title='Add an address']");
	private By saveButton = By.id("submitAddress");
	private By errorMessage = By.className("alert-danger");
	private By successMessage = By.xpath("//strong[contains(text(),'Your addresses are listed below.')]");
	
	// Input fields
	private By firstNameInput = By.id("firstname");
	private By lastNameInput = By.id("lastname");
	private By addressInput = By.id("address1");
	private By cityInput = By.id("city");
	private By stateInput = By.id("id_state");
	private By postalCodeInput = By.id("postcode");
	private By mobilePhoneInput = By.id("phone_mobile");
	private By noAddressesAvailableMessage = By.xpath("//p[contains(text(), 'No addresses are available.')]");
	
	// Constructor
	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Insert into input fields
	public MyAddressesPage insertFirstName(String firstName) {
		driver.findElement(firstNameInput).clear();
		driver.findElement(firstNameInput).sendKeys(firstName);
		return this;
	}

	public MyAddressesPage insertLastName(String lastName) {
		driver.findElement(lastNameInput).clear();
		driver.findElement(lastNameInput).sendKeys(lastName);
		return this;
	}

	public MyAddressesPage insertAddress(String address) {
		driver.findElement(addressInput).clear();
		driver.findElement(addressInput).sendKeys(address);
		return this;
	}

	public MyAddressesPage insertCity(String city) {
		driver.findElement(cityInput).clear();
		driver.findElement(cityInput).sendKeys(city);
		return this;
	}
	
	public MyAddressesPage selectState(String state) {
		Select dropDownState = new Select(driver.findElement(stateInput));
		dropDownState.selectByVisibleText(state);
		return this;
	}
	
	public MyAddressesPage insertPostalCode(String postalCode) {
		driver.findElement(postalCodeInput).clear();
		driver.findElement(postalCodeInput).sendKeys(postalCode);
		return this;
	}

	public MyAddressesPage insertMobilePhone(String mobilePhone) {
		driver.findElement(mobilePhoneInput).clear();
		driver.findElement(mobilePhoneInput).sendKeys(mobilePhone);
		return this;
	}
	
	// Click buttons
	public MyAddressesPage clickUpdateButton() {
		driver.findElement(updateButton).click();
		return this;
	}
	
	public MyAddressesPage clickSaveButton() {
		driver.findElement(saveButton).click();
		return this;
	}
	
	public MyAddressesPage clickDeleteButton() {
		driver.findElement(deleteButton).click();
		return this;
	}
	
	public MyAddressesPage clickAddAddressButton() {
		driver.findElement(addAddressButton).click();
		return this;
	}
	
	// Messages displayed
	public boolean errorMessageIsDisplayed() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public boolean successMessageIsDisplayed() {
		return driver.findElement(successMessage).isDisplayed();
	}
	
	public boolean noAddressesAvailableMessageIsDisplayed() {
		return driver.findElement(noAddressesAvailableMessage).isDisplayed();
	}
}
