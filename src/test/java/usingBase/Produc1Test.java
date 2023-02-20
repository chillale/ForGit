package usingBase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepo.ProductDetailsPage;
import utility.BaseC;
import utility.ExcelUtility;
import utility.JavaUtility;

@Listeners(utility.ListImplementation.class)
public class Produc1Test extends BaseC{
	@Test
	public void product() throws Throwable {
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		Assert.assertEquals(false, true);
		productDetailsPage.getProductBtn().click();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility j = new JavaUtility();
		productDetailsPage.getCreateProductBtn().click();
		productDetailsPage.getProductNameTf().sendKeys(excel.readDataFromExcel("sheet1", 4, 0)+j.generateRandom());
		productDetailsPage.getSaveBtn().click();
	}

}
