package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	private By signInButton = By.className("login");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}
	
	public boolean signInButtonIsDisplayed() {
		return driver.findElement(signInButton).isDisplayed();
	}
}
