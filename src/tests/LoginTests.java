package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
	
	private String sheetName = "LoginTests";
	private int columnNumber = 5;
	private String email;
	private String password;

	@Test
	public void successfulLogin() {
		this.email = excelReader.getData(sheetName, columnNumber, 4);
		this.password = excelReader.getData(sheetName, columnNumber, 5);
		
		homePage.clickSignInButton();
		myAccountPage.insertEmail(email).insertPassword(password).clickSignInButton();
		Assert.assertTrue(myAccountPage.welcomeMessageIsDisplayed());
	}
	
	@Test
	public void incorrectCredentialsLogin() {
		this.email = excelReader.getData(sheetName, columnNumber, 9);
		this.password = excelReader.getData(sheetName, columnNumber, 10);
		
		homePage.clickSignInButton();
		myAccountPage.insertEmail(email).insertPassword(password).clickSignInButton();
		Assert.assertTrue(myAccountPage.errorMessageIsDisplayed());
	}
	
	@Test
	public void noCredentialsLogin() {
		this.email = excelReader.getData(sheetName, columnNumber, 14);
		this.password = excelReader.getData(sheetName, columnNumber, 15);
		
		homePage.clickSignInButton();
		myAccountPage.insertEmail(email).insertPassword(password).clickSignInButton();
		Assert.assertTrue(myAccountPage.errorMessageIsDisplayed());
	}
	
	@Test
	public void incorrectPasswordLogin() {
		this.email = excelReader.getData(sheetName, columnNumber, 19);
		this.password = excelReader.getData(sheetName, columnNumber, 20);
		
		homePage.clickSignInButton();
		myAccountPage.insertEmail(email).insertPassword(password).clickSignInButton();
		Assert.assertTrue(myAccountPage.errorMessageIsDisplayed());
	}
	
	@Test
	public void incorrectEmailLogin() {
		this.email = excelReader.getData(sheetName, columnNumber, 24);
		this.password = excelReader.getData(sheetName, columnNumber, 25);
		
		homePage.clickSignInButton();
		myAccountPage.insertEmail(email).insertPassword(password).clickSignInButton();
		Assert.assertTrue(myAccountPage.errorMessageIsDisplayed());
	}
	
	@Test
	public void successfulLogout() {
		successfulLogin();
		myAccountPage.clickLogOutButton();
		Assert.assertTrue(homePage.signInButtonIsDisplayed());
	}
	
}
