package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
	
	@Test
	public void addItemToCart() throws InterruptedException {
		successfulLogin();
		dressesPage.getToThePage()
					.clickAddToCartButton(3);
		Thread.sleep(2000);
		Assert.assertTrue(dressesPage.proceedButtonDisplayed());
	}
	
//	@Test
	public void addThreeItemsToCart() throws InterruptedException {
		successfulLogin();
		dressesPage.getToThePage()
					.clickAddToCartButton(3)
					.clickContinueShoppingButton()
					.clickAddToCartButton(3)
					.clickContinueShoppingButton()
					.clickAddToCartButton(3)
					.clickContinueShoppingButton();
		Thread.sleep(2000);
		Assert.assertTrue(dressesPage.proceedButtonDisplayed());
	}
}
