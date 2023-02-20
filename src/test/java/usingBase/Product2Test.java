package usingBase;

import org.testng.annotations.Test;

import objectRepo.ProductDetailsPage;
import utility.BaseC;
import utility.ExcelUtility;
import utility.JavaUtility;

public class Product2Test extends BaseC{
	@Test
	public void product() throws Throwable {
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.getProductBtn().click();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility j = new JavaUtility();
		productDetailsPage.getCreateProductBtn().click();
		productDetailsPage.getProductNameTf().sendKeys(excel.readDataFromExcel("sheet1", 3, 0)+j.generateRandom());
		productDetailsPage.getSaveBtn().click();
		Thread.sleep(3000);
	}

}
