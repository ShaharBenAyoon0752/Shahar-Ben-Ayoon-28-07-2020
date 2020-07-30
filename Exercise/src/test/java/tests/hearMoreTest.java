package tests;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import conf.testConf;
import sectionInPage.hearMoreSection;

//hear more section tests
public class hearMoreTest extends testConf{

	//filling all the fields and sending the details
	@Test(priority = 1)
	public static void sendHelp() throws InterruptedException {
		//filling all the fields
		hearMoreSection.getName().sendKeys("shahar");
		hearMoreSection.getCompany().sendKeys("myCompany");
		hearMoreSection.getEmail().sendKeys("123shar@gmail.com");
		hearMoreSection.getPhone().sendKeys("0566448912");

		//checking if the thank you site opened
		Thread.sleep(5000);
		hearMoreSection.getSendButton().click();
		wait.until(ExpectedConditions.urlToBe(PATH + "thank-you/"));
		assertTrue(driver.getCurrentUrl().equals(PATH + "thank-you/"),"The details sending failed");

		//navigate back to the main page
		driver.navigate().to(PATH);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//checking the error message of empty name field
	@Test(priority = 2)
	public static void emptyNameError() throws InterruptedException {
		//filling all the fields besides name
		hearMoreSection.getCompany().sendKeys("myCompany");
		hearMoreSection.getEmail().sendKeys("123shar@gmail.com");
		hearMoreSection.getPhone().sendKeys("0566448912");

		//click the send button
		Thread.sleep(5000);
		hearMoreSection.getSendButton().click();

		//checking if the right message appeared
		Thread.sleep(5000);
		assertTrue(hearMoreSection.getCurrentError().getText().equals(hearMoreSection.getNameErrorMessage())
				,"empty name error message appered");
	}

	//checking the error message of empty company field
	@Test(priority = 3)
	public static void emptyCompanyError() throws InterruptedException {
		//filling all the fields besides company 
		hearMoreSection.getName().sendKeys("shahar");
		hearMoreSection.getEmail().sendKeys("123shar@gmail.com");
		hearMoreSection.getPhone().sendKeys("0566448912");
		hearMoreSection.getCompany().clear();

		//click the send button
		Thread.sleep(5000);
		hearMoreSection.getSendButton().click();

		//checking if the right message appeared
		Thread.sleep(5000);
		assertTrue(hearMoreSection.getCurrentError().getText().equals(hearMoreSection.getCompanyErrorMessage())
				,"empty company error message appered");
	}

	//checking the error message of empty email field
	@Test(priority = 4)
	public static void emptyEmailError() throws InterruptedException {
		//filling all the fields besides email 
		hearMoreSection.getName().sendKeys("shahar");
		hearMoreSection.getCompany().sendKeys("myCompany");
		hearMoreSection.getPhone().sendKeys("0566448912");
		
		//click the send button
		Thread.sleep(5000);
		hearMoreSection.getSendButton().click();

		//checking if the right message appeared
		Thread.sleep(5000);
		assertTrue(hearMoreSection.getCurrentError().getText().equals(hearMoreSection.getEmailErrorMessage())
				,"empty email error message appered");
	}

	//checking the error message of empty phone field
	@Test(priority = 5)
	public static void emptyPhoneError() throws InterruptedException {
		//filling all the fields besides phone
		hearMoreSection.getName().sendKeys("shahar");
		hearMoreSection.getCompany().sendKeys("myCompany");
		hearMoreSection.getEmail().sendKeys("123shar@gmail.com");

		//click the send button
		Thread.sleep(5000);
		hearMoreSection.getSendButton().click();

		//checking if the right message appeared
		Thread.sleep(5000);
		assertTrue(hearMoreSection.getCurrentError().getText().equals(hearMoreSection.getPhoneErrorMessage())
				,"empty phone error message appered");
	}

	//after every test refreshing the page
	@AfterMethod
	public static void pageRefresh() {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
