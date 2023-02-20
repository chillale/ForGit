package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.HomePage;

public class BaseC {
	public WebDriver driver;
	public static WebDriver sdriver=null;
	HomePage homePage;
	@BeforeSuite
	public void connectToDB() {
		System.out.println("==> connect to Db <== ");
	}
	@AfterSuite
	public void disconnectToDB() {
		System.out.println("==> Disconnect to Db <== ");
	}
	@BeforeClass
	public void launchTheBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 sdriver = driver;
	}
	@org.testng.annotations.AfterClass
	public void closeTheBrowser() {
		driver.close();
	}
	@BeforeMethod
	public void loginIntoApp() throws Throwable {
		PropertyFiles prop = new PropertyFiles();
		driver.get(prop.readDataFromProperty("url"));
		homePage = new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage.getuName().sendKeys(prop.readDataFromProperty("username"));
		homePage.getpWd().sendKeys(prop.readDataFromProperty("password"));
		homePage.getSubmitBtn().click();
	}
	@AfterMethod
	public void logOutFromApp() {
		WebElement aImg = homePage.getAdminImg();
		Actions act = new Actions(driver);
		act.moveToElement(aImg).perform();
		homePage.getSignOutBtn().click();
	}
	public static String screenShott(String name) {
		TakesScreenshot ts = (TakesScreenshot)BaseC.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".//Screensot//"+name+".PNG";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return path;
}
}