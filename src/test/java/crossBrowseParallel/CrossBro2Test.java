package crossBrowseParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.HomePage;
import objectRepo.ProductDetailsPage;
import utility.ExcelUtility;
import utility.JavaUtility;
import utility.PropertyFiles;

public class CrossBro2Test {
	@Test
	@Parameters("Browser")
	public void cross(String browser) throws Throwable {
		WebDriver driver;
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		HomePage homePage = new HomePage(driver);
		PropertyFiles props = new PropertyFiles();
		ExcelUtility excelUtility = new ExcelUtility();
		driver.get(props.readDataFromProperty("url"));
		homePage.getuName().sendKeys(props.readDataFromProperty("username"));
		homePage.getpWd().sendKeys(props.readDataFromProperty("password"));
		homePage.getSubmitBtn().click();
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.getProductBtn().click();
		productDetailsPage.getCreateProductBtn().click();
		JavaUtility j = new JavaUtility();
		productDetailsPage.getProductNameTf().sendKeys(excelUtility.readDataFromExcel("sheet1", 6, 0)+j.generateRandom());
		productDetailsPage.getSaveBtn().click();
		WebElement aImg = homePage.getAdminImg();
		Actions act =  new Actions(driver);
		act.moveToElement(aImg).perform();
		homePage.getSignOutBtn().click();
	}

}
