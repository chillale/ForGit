package crossBrowseParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.JavaUtility;

public class Report {
	ExtentSparkReporter extentSpark;
	ExtentReports extentReport;
	ExtentTest extentTest;
	@Test
	public void report() {
		JavaUtility j = new JavaUtility();
		
		extentSpark = new ExtentSparkReporter("./ExtentReport/raja"+j.generateRandom()+".html");
		extentSpark.config().setDocumentTitle("SateeshReport");
		extentSpark.config().setTheme(Theme.DARK);
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSpark);
		extentReport.setSystemInfo("browser", "chrome");
		extentReport.setSystemInfo("env", "dev");
		extentReport.setSystemInfo("build", "10.3.2");
		extentReport.setSystemInfo("report Name", "Raja");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		extentTest=extentReport.createTest("Harika Facebook");
		driver.get("http://www.google.com");
		extentReport.flush();
	}

}
