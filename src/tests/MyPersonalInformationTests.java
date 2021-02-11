package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyPersonalInformationTests extends BaseTest {
	private String sheetName = "MyPersonalInformationTests";
	private int columnNumber = 6;
	
	private String firstName;
	private String lastName;
	private String email;
	private String day;
	private String month;
	private String year;
	private String currentPassword;
	private String newPassword;
	private String confirmNewPassword;
	
	public void insertDataIntoPersonalInfo(String firstName, String lastName, String email, String day, String month, String year, String currentPassword, String newPassword, String confirmNewPassword) {
		myAccountPage.clickMyPersonalInformationPage();
		myPersonalInformationPage.insertFirstName(firstName)
									.insertLastName(lastName)
									.insertEmail(email)
									.selectDay(day)
									.selectMonth(month)
									.selectYear(year)
									.insertCurrentPassword(currentPassword)
									.insertNewPassword(newPassword)
									.insertconfirmNewPassword(confirmNewPassword)
									.clickSubmitButton();
	}
	
	public void updateDataToPreviousState() {
		insertDataIntoPersonalInfo("Bojan", "Tubic", "bojantubic@fakemail.com", "24", "11", "1993", "stevoposlic", "bojantubicfake", "bojantubicfake");
	}
	
	@Test (priority = 5)
	public void successfulUpdatePersonalInfo() {
		this.firstName = excelReader.getData(sheetName, columnNumber, 4);
		this.lastName = excelReader.getData(sheetName, columnNumber, 5);
		this.email = excelReader.getData(sheetName, columnNumber, 6);
		this.day = excelReader.getData(sheetName, columnNumber, 7);
		this.month = excelReader.getData(sheetName, columnNumber, 8);
		this.year = excelReader.getData(sheetName, columnNumber, 9);
		this.currentPassword = excelReader.getData(sheetName, columnNumber, 10);
		this.newPassword = excelReader.getData(sheetName, columnNumber, 11);
		this.confirmNewPassword = excelReader.getData(sheetName, columnNumber, 12);
		
		successfulLogin();
		insertDataIntoPersonalInfo(firstName, lastName, email, day, month, year, currentPassword, newPassword, confirmNewPassword);
		Assert.assertTrue(myPersonalInformationPage.successMessageIsDisplayed());
		driver.navigate().back();
		driver.navigate().back();
		updateDataToPreviousState();
	}
}
