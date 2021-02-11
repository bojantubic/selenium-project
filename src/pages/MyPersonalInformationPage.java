package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyPersonalInformationPage {
	private WebDriver driver;
	
	// Input fields
	private By mrInput = By.id("id_gender1");
	private By mrsNameInput = By.id("id_gender2");
	private By firstNameInput = By.id("firstname");
	private By lastNameInput = By.id("lastname");
	private By emailInput = By.id("email");
	private By dayInput = By.id("days");
	private By monthInput = By.id("months");
	private By yearInput = By.id("years");
	private By currentPasswordInput = By.id("old_passwd");
	private By newPasswordInput = By.id("passwd"); 
	private By confirmNewPasswordInput = By.id("confirmation"); 
	private By submitButton = By.xpath("//button[@name='submitIdentity']"); 
	private By successMessage = By.xpath("//p[contains(text(), 'Your personal information has been successfully updated.')]"); 
	
	public MyPersonalInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public MyPersonalInformationPage clickMr() {
		driver.findElement(mrInput).click();
		return this;
	}
	
	public MyPersonalInformationPage clickMrs() {
		driver.findElement(mrsNameInput).click();
		return this;
	}
	
	public MyPersonalInformationPage insertFirstName(String firstName) {
		driver.findElement(firstNameInput).clear();
		driver.findElement(firstNameInput).sendKeys(firstName);
		return this;
	}
	
	public MyPersonalInformationPage insertLastName(String lastName) {
		driver.findElement(lastNameInput).clear();
		driver.findElement(lastNameInput).sendKeys(lastName);
		return this;
	}
	
	public MyPersonalInformationPage insertEmail(String email) {
		driver.findElement(emailInput).clear();
		driver.findElement(emailInput).sendKeys(email);
		return this;
	}
	
	public MyPersonalInformationPage selectDay(String day) {
		Select dropDownState = new Select(driver.findElement(dayInput));
		dropDownState.selectByValue(day);
		return this;
	}
	
	public MyPersonalInformationPage selectMonth(String month) {
		Select dropDownState = new Select(driver.findElement(monthInput));
		dropDownState.selectByValue(month);
		return this;
	}
	
	public MyPersonalInformationPage selectYear(String year) {
		Select dropDownState = new Select(driver.findElement(yearInput));
		dropDownState.selectByValue(year);
		return this;
	}
	
	public MyPersonalInformationPage insertCurrentPassword(String currentPassword) {
		driver.findElement(currentPasswordInput).clear();
		driver.findElement(currentPasswordInput).sendKeys(currentPassword);
		return this;
	}
	
	public MyPersonalInformationPage insertNewPassword(String newPassword) {
		driver.findElement(newPasswordInput).clear();
		driver.findElement(newPasswordInput).sendKeys(newPassword);
		return this;
	}
	
	public MyPersonalInformationPage insertconfirmNewPassword(String confirmPassword) {
		driver.findElement(confirmNewPasswordInput).clear();
		driver.findElement(confirmNewPasswordInput).sendKeys(confirmPassword);
		return this;
	}
	
	public MyPersonalInformationPage clickSubmitButton() {
		driver.findElement(submitButton).click();
		return this;
	}
	
	public boolean successMessageIsDisplayed() {
		return driver.findElement(successMessage).isDisplayed();
	}
}
