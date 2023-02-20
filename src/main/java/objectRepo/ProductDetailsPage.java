package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	WebDriver driver;
	@FindBy(linkText = "Products")
	private WebElement productBtn;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createProductBtn;
	
	@FindBy(name = "productname")
	private WebElement productNameTf;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
//	@FindBy(name = "sales_start_date")
//	private WebElement salesDate;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductBtn() {
		return productBtn;
	}

	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}

	public WebElement getProductNameTf() {
		return productNameTf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

//	public WebElement getSalesDate() {
//		return salesDate;
//	}
	

}
