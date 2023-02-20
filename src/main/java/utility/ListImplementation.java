package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplementation implements ITestListener{
	ExtentTest extentTest;
	ExtentReports extentReports;

	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getMethod().getMethodName()+ " got passed");
	}

	public void onTestFailure(ITestResult result) {
		String path = null;
		path = BaseC.screenShott(result.getMethod().getMethodName()+"got failed");
		extentTest.log(Status.FAIL, result.getMethod().getMethodName());
		extentTest.log(Status.FAIL, result.getThrowable());
		extentTest.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getMethod().getMethodName()+" got skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		extentTest.log(Status.INFO, result.getMethod().getSuccessPercentage()+"perceentage message");
	}

	public void onStart(ITestContext context) {
		JavaUtility j = new JavaUtility();
		ExtentSparkReporter extentSparkReporter =  new ExtentSparkReporter("./ExtentReport/Raja"+j.generateRandom()+".html");
		extentSparkReporter.config().setDocumentTitle("Raja Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("build", "1.2.3");
		extentReports.setSystemInfo("env", "dev");
		extentReports.setSystemInfo("reporter Name", "Raja Moleeti");
		extentReports.setSystemInfo("browser", "chrome");
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	
}
