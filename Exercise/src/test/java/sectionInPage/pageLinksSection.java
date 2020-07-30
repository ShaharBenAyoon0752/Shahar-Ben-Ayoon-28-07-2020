package sectionInPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import conf.testConf;

//links in website web elements 
public class pageLinksSection extends testConf{
	
	//return whatsapp link element
	public static WebElement getWhatsappLink() {
		return driver.findElement(By.cssSelector("a[class = 'callUsWhatsapp__BtnWhatsapp-sc-1bcgurk-0 cPQmgB']"));
	}
	
	//return scroll up element
	public static WebElement getScrollToTopButton() {
		return driver.findElement(By.cssSelector("a[class = 'backToTop__BtnGoUp-sc-1deq75d-0 fIqtKc']"));
	}
	
	//return social media links element
	public static List<WebElement> getSocialMediaLinks() {
		return driver.findElements(By.xpath("//div[@class = 'socialMediaBar__container-sc-1f95hbj-1 cPJwVC']//a"));
	}
}
