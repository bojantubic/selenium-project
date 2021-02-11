package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAddressesTests extends BaseTest {
	
	private String sheetName = "MyAddressesTests";
	private int columnNumber = 6;
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String postalCode;
	private String mobilePhone;

	@Test (priority = 5)
	public void updateAddress() {
		
		this.firstName = excelReader.getData(sheetName, columnNumber, 3);
		this.lastName = excelReader.getData(sheetName, columnNumber, 4);
		this.address = excelReader.getData(sheetName, columnNumber, 5);
		this.city = excelReader.getData(sheetName, columnNumber, 6);
		this.state = excelReader.getData(sheetName, columnNumber, 7);
		this.postalCode = excelReader.getData(sheetName, columnNumber, 8);
		this.mobilePhone = excelReader.getData(sheetName, columnNumber, 9);
		
		this.successfulLogin();
		myAccountPage.clickMyAddressesPage();
		myAddressesPage.clickUpdateButton()
						.insertFirstName(firstName)
						.insertLastName(lastName)
						.insertAddress(address)
						.insertCity(city)
						.selectState(state)
						.insertPostalCode(postalCode)
						.insertMobilePhone(mobilePhone)
						.clickSaveButton();
		Assert.assertTrue(myAddressesPage.successMessageIsDisplayed());
		this.UpdateDataToPreviousState();
	}
	
	@Test (priority = 15)
	public void addNewAddress() {
		this.firstName = excelReader.getData(sheetName, columnNumber, 14);
		this.lastName = excelReader.getData(sheetName, columnNumber, 15);
		this.address = excelReader.getData(sheetName, columnNumber, 16);
		this.city = excelReader.getData(sheetName, columnNumber, 17);
		this.state = excelReader.getData(sheetName, columnNumber, 18);
		this.postalCode = excelReader.getData(sheetName, columnNumber, 19);
		this.mobilePhone = excelReader.getData(sheetName, columnNumber, 20);
		
		this.successfulLogin();
		myAccountPage.clickMyAddressesPage();
		myAddressesPage.clickAddAddressButton()
						.insertFirstName(firstName)
						.insertLastName(lastName)
						.insertAddress(address)
						.insertCity(city)
						.selectState(state)
						.insertPostalCode(postalCode)
						.insertMobilePhone(mobilePhone)
						.clickSaveButton();
		Assert.assertTrue(myAddressesPage.successMessageIsDisplayed());
	}
	
	@Test (priority = 10)
	public void deleteAddress() {
		this.successfulLogin();
		myAccountPage.clickMyAddressesPage();
		myAddressesPage.clickDeleteButton();
		driver.switchTo().alert().accept();
		Assert.assertTrue(myAddressesPage.noAddressesAvailableMessageIsDisplayed());
	}
}
