package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
	
	@Test
	public void addItemToCart() throws InterruptedException {
		successfulLogin();
		dressesPage.getToThePage()
					.clickAddToCartButton(3);
		Assert.assertTrue(dressesPage.proceedButtonDisplayed());
		dressesPage.ClickProceedButton()
					.deleteItemFromCart();
	}
	
	@Test
	public void addThreeItemsToCart() throws InterruptedException {
		successfulLogin();
		dressesPage.getToThePage()
					.clickAddToCartButton(3)
					.clickContinueShoppingButton()
					.clickAddToCartButton(3)
					.clickContinueShoppingButton()
					.clickAddToCartButton(3)
					.clickContinueShoppingButton();
		Assert.assertTrue(dressesPage.proceedButtonDisplayed());
		dressesPage.ClickProceedButton()
					.deleteItemFromCart()
					.deleteItemFromCart()
					.deleteItemFromCart();
	}
}
