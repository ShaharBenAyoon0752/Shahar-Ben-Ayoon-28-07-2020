package sectionInPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import conf.testConf;

//get help section web elements 
public class getHelpSection extends testConf{
	
	private final static String NAME_ERROR_MESSAGE = "שדה שם הוא שדה חובה";
	private final static String EMAIL_ERROR_MESSAGE = "שדה אימייל הוא שדה חובה";
	private final static String PHONE_ERROR_MESSAGE = "שדה טלפון הוא שדה חובה";
	
	//return name element
	public static WebElement getName() {
		return driver.findElement(By.cssSelector("input[class='Footer__Input-sc-1xqajj9-6 hxDwKy'][name='name']"));
	}
	
	//return email element
	public static WebElement getEmail() {
		return driver.findElement(By.cssSelector("input[class='Footer__Input-sc-1xqajj9-6 hxDwKy'][name='email']"));
	}
	
	//return phone element
	public static WebElement getPhone() {
		return driver.findElement(By.cssSelector("input[class='Footer__Input-sc-1xqajj9-6 hxDwKy'][name='phone']"));
	}
	
	//return send button element
	public static WebElement getSendButton() {
		return driver.findElement(By.cssSelector("button[class='Footer__Button-sc-1xqajj9-7 jixtxJ']"));
	}
	
	//return first error element
	public static WebElement getCurrentError() {
		return driver.findElement(By.cssSelector("label[class='Footer__InputError-sc-1xqajj9-5 fYJjBk']"));
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

}
