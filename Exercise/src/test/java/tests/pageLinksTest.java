package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import conf.testConf;
import sectionInPage.pageLinksSection;

//test of several links in the page
public class pageLinksTest extends testConf{

	//checking if the whatsapp link in the left side of the screen works
	@Test(priority = 1)
	public static void WhatsappNavigation() throws InterruptedException {
		//saving the current page window
		String winHandleBefore = driver.getWindowHandle();

		//click the whatsapp link
		pageLinksSection.getWhatsappLink().click();

		//driver switched to the new window that opened from the link
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		//checking if the right website opened from the link
		wait.until(ExpectedConditions.urlToBe("https://api.whatsapp.com/send?phone=972544945333"));
		assertTrue(driver.getCurrentUrl().equals("https://api.whatsapp.com/send?phone=972544945333"),
				"Whatsapp Navigation failed");

		//closing the page and driver switching to the main window 
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	//checking if the scroll up button works
	@Test(priority = 2)
	public static void ScrollToTop() throws InterruptedException {
		//scroll to the bottom of the page
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 70000)");

		//clicking the scroll up button
		Thread.sleep(5000);
		pageLinksSection.getScrollToTopButton().click();

		//checking if the scroll up button worked
		Thread.sleep(5000);
		System.out.println(js.executeScript("return window.pageYOffset;").toString());
		assertTrue(js.executeScript("return window.pageYOffset;").toString().equals("0") 
				,"the window didn't scroll to the top");
	}

	//checking if the links in the bottom of the page work
	@Test(priority = 3)
	public static void BottomLinks() throws InterruptedException {
		String currentlink = "";
		//getting all the bottom links
		List<WebElement> links = pageLinksSection.getSocialMediaLinks();

		//checking all the links one by one
		for(WebElement link: links) {
			//saving the current link before clicking the link
			currentlink =link.getAttribute("href");
			
			//click the link
			link.click();

			//saving the current page window
			String winHandleBefore = driver.getWindowHandle();

			//driver switched to the new window that opened from the link
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}

			//checking if the link is not for linkedin(because the link open human verification window
			// that I can't with selenium
			if(!currentlink.contains("linkedin")) {
				//checking if the right website opened from the link
				assertTrue(currentlink.equals(driver.getCurrentUrl()),
						"social link Navigation failed");
			}

			//closing the page and driver switching to the main window 
			driver.close();
			driver.switchTo().window(winHandleBefore);
		}
	}

	//after every test refreshing the page
	@AfterMethod
	public static void pageRefresh() {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
