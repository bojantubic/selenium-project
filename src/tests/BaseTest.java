package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyPersonalInformationPage;
import pages.MyWishlistPage;
import pages.DressesPage;

public class BaseTest {
	WebDriver driver;
	WebDriverWait wait;
	ExcelReader excelReader;
	String baseUrl;

	HomePage homePage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	MyPersonalInformationPage myPersonalInformationPage;
	MyWishlistPage myWishlistPage;
	DressesPage dressesPage;

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();

		this.excelReader = new ExcelReader("data\\data.xlsx");
		this.homePage = new HomePage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressesPage = new MyAddressesPage(driver);
		this.myPersonalInformationPage = new MyPersonalInformationPage(driver);
		this.myWishlistPage = new MyWishlistPage(driver);
		this.dressesPage = new DressesPage(driver);
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		baseUrl = "http://automationpractice.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@AfterClass
	public void afterClass() throws IOException {
		driver.close();
		excelReader.fis.close();
	}

	// Successful login into the web-site
	public void successfulLogin() {
		String email = excelReader.getData("LoginTests", 5, 4);
		String password = excelReader.getData("LoginTests", 5, 5);

		homePage.clickSignInButton();
		myAccountPage.insertEmail(email).insertPassword(password).clickSignInButton();
		Assert.assertTrue(myAccountPage.welcomeMessageIsDisplayed());
	}

	// Update back address information
	public void UpdateDataToPreviousState() {
		myAddressesPage.clickUpdateButton().insertFirstName("Bojan").insertLastName("Tubic")
				.insertAddress("Green Street").insertCity("Novi Sad").selectState("Alaska").insertPostalCode("21000")
				.insertMobilePhone("+38161000000").clickSaveButton();
	}

	// Accept alert
	public void acceptAlert() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}
}
