package basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;

@RunWith(SeleniumScreenshotJUnit4Runner.class)
public class AbstractSelenium {
	protected WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebConnectors\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	
	public HomePage openCeneo() {
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public void takeScreenshot() throws IOException {
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File destFile = new File("C:\\Borowik\\workspace\\starterkit\\Selenium\\testScreenshots"+screenshot.getName());
//		FileUtils.copyFile(screenshot, destFile);
//		System.out.println(String.format("[[ATTACHMENT|%s]]", destFile.getAbsolutePath()));
	}
	
	@After
	public void thearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
