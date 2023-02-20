package crossBrowseParallel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FlagsTest {
	@Test(priority = 1,dependsOnMethods = "m2")
	public void m1() {
		System.out.println("m1 method executed");
		Assert.assertEquals(false, true);
	}
	@Test(priority = 2,invocationCount = 2)
	public void m2() {
		System.out.println("m2 method executed");
	}
	@Test(priority = 1,dependsOnMethods = "m1", alwaysRun = true)
	public void m3() {
		System.out.println("m3 method executed");
	}

}
