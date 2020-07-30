package tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sectionInPage.getHelpSection;
import conf.testConf;

//get help section tests
public class getHelpTest extends testConf{

	//scrolling up for the section be visible
	@BeforeClass
	public static void scrollup() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 0)");
	}

	//filling all the fields and sending the details
	@Test(priority = 1)
	public static void sendHelp() throws InterruptedException {
		//filling all the fields
		getHelpSection.getName().sendKeys("shahar");
		getHelpSection.getEmail().sendKeys("123shar@gmail.com");
		getHelpSection.getPhone().sendKeys("0566448912");

		//click the send button
		Thread.sleep(5000);
		getHelpSection.getSendButton().click();

		//checking if the thank you site opened
		wait.until(ExpectedConditions.urlToBe(PATH + "thank-you/"));
		assertTrue(driver.getCurrentUrl().equals(PATH + "thank-you/"),"The details sending failed");

		//navigate back to the main page
		Thread.sleep(5000);
		driver.navigate().to(PATH);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//checking the error message of empty name field
	@Test(priority = 2)
	public static void emptyNameError() throws InterruptedException {
		//filling all the fields besides name
		getHelpSection.getEmail().sendKeys("123shar@gmail.com");
		getHelpSection.getPhone().sendKeys("0566448912");

		//click the send button
		Thread.sleep(5000);
		getHelpSection.getSendButton().click();

		//checking if the right message appeared
		Thread.sleep(5000);
		assertTrue(getHelpSection.getCurrentError().getText().equals(getHelpSection.getNameErrorMessage())
				,"empty name error message appered");
	}

	//checking the error message of empty email field
	@Test(priority = 3)
	public static void emptyEmailError() throws InterruptedException {
		//filling all the fields besides email
		getHelpSection.getName().sendKeys("shahar");
		getHelpSection.getPhone().sendKeys("0566448912");

		//click the send button
		Thread.sleep(5000);
		getHelpSection.getSendButton().click();

		//checking if the right message appeared
		wait.until(ExpectedConditions.visibilityOf(getHelpSection.getCurrentError()));
		//Thread.sleep(5000);
		assertTrue(getHelpSection.getCurrentError().getText().equals(getHelpSection.getEmailErrorMessage())
				,"empty email error message appered");
	}

	//checking the error message of empty phone field
	@Test(priority = 4)
	public static void emptyPhoneError() throws InterruptedException {
		//filling all the fields besides phone
		getHelpSection.getName().sendKeys("shahar");
		getHelpSection.getEmail().sendKeys("123shar@gmail.com");

		//click the send button
		Thread.sleep(5000);
		getHelpSection.getSendButton().click();

		//checking if the right message appeared
		Thread.sleep(5000);
		assertTrue(getHelpSection.getCurrentError().getText().equals(getHelpSection.getPhoneErrorMessage())
				,"empty phone error message appered");
	}

	//after every test refreshing the page
	@AfterMethod
	public static void pageRefresh() {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
