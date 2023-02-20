package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(name = "user_name")
	private WebElement uName;
	
	@FindBy(name ="user_password")
	private WebElement pWd;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutBtn;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getuName() {
		return uName;
	}

	public WebElement getpWd() {
		return pWd;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	

}
