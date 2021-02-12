package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressesPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private By productImg = By.xpath("//a[@href='http://automationpractice.com/index.php?id_product=3&controller=product' and @class='product_img_link']");
	private By procedeToCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");
	private By continueShoppingButton = By.xpath("//span[@title='Continue shopping']");
	private By deleteItemButton = By.xpath("//a[@class='cart_quantity_delete']");
	public DressesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		actions = new Actions(driver);
	}

	public DressesPage clickAddToCartButton(int numberOfTheItem) {
		WebElement addToCartButton = driver.findElement(By.xpath("//a[@data-id-product='" + numberOfTheItem +"' and @title='Add to cart']"));
		actions.moveToElement(driver.findElement(productImg)).perform();
		addToCartButton.click();
		return this;
	}
	
	public DressesPage clickContinueShoppingButton() {
		driver.findElement(continueShoppingButton);
		return this;
	}
	
	public DressesPage getToThePage() {
		driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
		return this;
	}
	
	public DressesPage deleteItemFromCart() {
		driver.findElement(deleteItemButton).click();
		return this;
	}
	
	public DressesPage ClickProceedButton() {
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(procedeToCheckoutButton));
		button.click();
		return this;
	}
	
	public boolean proceedButtonDisplayed() {
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(procedeToCheckoutButton));
		return button.isDisplayed();
	}
}
