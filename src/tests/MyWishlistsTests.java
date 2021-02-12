package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWishlistsTests extends BaseTest {

	private String sheetName = "MyWishlistsTests";
	private int columnNumber = 6;
	
	private String wishlistNameShoes;
	private String wishlistNamePajamas;
	private String wishlistNamePants;
	private String wishlistNameSocks;
	
	@Test
	public void addWishList() throws InterruptedException {
		this.wishlistNameShoes = excelReader.getData(sheetName, columnNumber, 3);
		
		this.successfulLogin();
		myAccountPage.clickMyWishlistsPage();
		myWishlistPage.insertWishlistName(wishlistNameShoes).clickSubmitWishlist();
		Thread.sleep(2000);
		Assert.assertEquals(myWishlistPage.assertWishlistName(wishlistNameShoes), wishlistNameShoes);
		deleteWishlist(wishlistNameShoes);
	}
	
	@Test
	public void addMultipleWishList() throws InterruptedException {
		this.wishlistNamePajamas = excelReader.getData(sheetName, columnNumber, 6);
		this.wishlistNamePants = excelReader.getData(sheetName, columnNumber, 8);
		this.wishlistNameSocks = excelReader.getData(sheetName, columnNumber, 10);
		
		this.successfulLogin();
		myAccountPage.clickMyWishlistsPage();
		myWishlistPage.insertWishlistName(wishlistNamePajamas)
						.clickSubmitWishlist()
						.insertWishlistName(wishlistNamePants)
						.clickSubmitWishlist()
						.insertWishlistName(wishlistNameSocks)
						.clickSubmitWishlist();
		
		Assert.assertEquals(myWishlistPage.assertWishlistName(wishlistNamePajamas), wishlistNamePajamas);
		Assert.assertEquals(myWishlistPage.assertWishlistName(wishlistNamePants), wishlistNamePants);
		Assert.assertEquals(myWishlistPage.assertWishlistName(wishlistNameSocks), wishlistNameSocks);
		
		deleteWishlist(wishlistNamePajamas);
		deleteWishlist(wishlistNamePants);
		deleteWishlist(wishlistNameSocks);
	}
	
	public void deleteWishlist(String wishlistName) throws InterruptedException {
		int numberOfWishlistsBefore = myWishlistPage.getNumberOfWishlists();
		myWishlistPage.clickDeletebutton(wishlistName);
		acceptAlert();
		Thread.sleep(5000);
		int numberOfWishlistsAfter = myWishlistPage.getNumberOfWishlists();
		Assert.assertTrue(numberOfWishlistsBefore > numberOfWishlistsAfter);
	}
	
}
