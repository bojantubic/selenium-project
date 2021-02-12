package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWishlistPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By nameInput = By.id("name");
	private By submitWishlistButton = By.id("submitWishlist");
	private By wishlists = By.xpath("//tr[starts-with(@id ,'wishlist')]");
	
	public MyWishlistPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public MyWishlistPage insertWishlistName(String name) {
		driver.findElement(nameInput).sendKeys(name);
		return this;
	}
	
	public MyWishlistPage clickSubmitWishlist() {
		driver.findElement(submitWishlistButton).click();
		return this;
	}
	
	public MyWishlistPage clickDeletebutton(String wishlistName) {
		driver.findElement(By.xpath("//a[contains(text(), \"" + wishlistName +"\")]/parent::td//following-sibling::*//following-sibling::*//following-sibling::*//following-sibling::*//following-sibling::*//a")).click();
		return this;
	}
	
	public String assertWishlistName(String wishlistName) {
		By wish = By.xpath("//a[contains(text(), '" + wishlistName + "')]");
		WebElement wishList = wait.until(ExpectedConditions.presenceOfElementLocated(wish));
		return wishList.getText();
	}
	
	public int getNumberOfWishlists() {
		List<WebElement> allWishlists = driver.findElements(wishlists);
		return allWishlists.size();
	}
}
