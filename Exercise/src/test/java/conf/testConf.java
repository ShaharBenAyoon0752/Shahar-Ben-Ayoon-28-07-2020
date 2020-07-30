package conf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//Test configuration class
public class testConf {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected final static String PATH = "https://automation.herolo.co.il/";
	
	//starting the session
	@BeforeSuite
	public static void startSession() {
		//define webdriver path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
				"\\webDriver\\chromedriver.exe");
		
		//starting the driver session for the website
		driver = new ChromeDriver();
		driver.get(PATH);
		System.out.println("the session started");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//defining explicit wait 
		wait = new WebDriverWait(driver, 10);
	}
	
	//closing driver and ending session
	@AfterSuite
	public static void closeDriver() {
		driver.quit();
		System.out.println("the session ended");
	}
}
