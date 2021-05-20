package sauce.lab;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest extends SaucelabsConfig {

	public void doLogin() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test
	public void check()  {
		doLogin();
		Assert.assertTrue(driver.findElements(By.cssSelector(".inventory_item")).size() == 6);
		
		
		
	}
}
