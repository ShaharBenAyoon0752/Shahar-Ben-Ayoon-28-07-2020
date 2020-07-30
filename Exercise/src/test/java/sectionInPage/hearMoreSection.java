package sectionInPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import conf.testConf;

//hear more section web elements 
public class hearMoreSection extends testConf{

	private final static String NAME_ERROR_MESSAGE = "שדה שם הוא שדה חובה";
	private final static String EMAIL_ERROR_MESSAGE = "שדה אימייל הוא שדה חובה";
	private final static String PHONE_ERROR_MESSAGE = "שדה טלפון הוא שדה חובה";
	private final static String COMPANY_ERROR_MESSAGE = "שדה חברה הוא שדה חובה";

	//return name element
	public static WebElement getName() {
		return driver.findElement(By.cssSelector("input[class*='commun__Input-mgrfny-4 form__Input-sc-1ju2h8q-0'][id='name']"));
	}

	//return company element
	public static WebElement getCompany() {
		return driver.findElement(By.cssSelector("input[class*='commun__Input-mgrfny-4 form__Input-sc-1ju2h8q-0'][id='company']"));
	}

	//return email element
	public static WebElement getEmail() {
		return driver.findElement(By.cssSelector("input[class*='commun__Input-mgrfny-4 form__Input-sc-1ju2h8q-0'][id='email']"));
	}

	//return phone element
	public static WebElement getPhone() {
		return driver.findElement(By.cssSelector("input[class*='commun__Input-mgrfny-4 form__Input-sc-1ju2h8q-0'][id='telephone']"));
	}

	//return send button element
	public static WebElement getSendButton() {
		return driver.findElement(By.cssSelector("a[class='commun__Button-mgrfny-0 commun__ButtonContact-mgrfny-1 form__ButtonContact-sc-1ju2h8q-1 gGWtQr']"));
	}

	//return first error element
	public static WebElement getCurrentError() {
		return driver.findElement(By.cssSelector("span[class='commun__ErrorText-mgrfny-6 yqHnF']"));
	}

	//return the expected name error message
	public static String getNameErrorMessage() {
		return NAME_ERROR_MESSAGE;
	}

	//return the expected email error message
	public static String getEmailErrorMessage() {
		return EMAIL_ERROR_MESSAGE;
	}

	//return the expected phone error message
	public static String getPhoneErrorMessage() {
		return PHONE_ERROR_MESSAGE;
	}

	//return the expected company error message
	public static String getCompanyErrorMessage() {
		return COMPANY_ERROR_MESSAGE;
	}
}
