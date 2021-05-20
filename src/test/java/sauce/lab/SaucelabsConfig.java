package sauce.lab;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaucelabsConfig {
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browserName) throws MalformedURLException  {
		
		System.out.println(browserName);
		
		MutableCapabilities caps  = new MutableCapabilities();
		
		caps.setCapability("build", "Java-w3c-examples");
	    caps.setCapability("seleniumVersion", "3.141.59");
		caps.setCapability("username", "nitin.bhagat");
	    caps.setCapability("accessKey", "d7a5b957-df27-465a-be71-65036ecc2742");
	    caps.setCapability("tags", "Java-w3c-tests");
	    
	    DesiredCapabilities cap = new DesiredCapabilities();
	    cap.setCapability("sauce:options", caps);
	    cap.setCapability("browserVersion", "latest");
    	cap.setCapability("platformName", "windows 10");
	    
	    if (browserName.equals("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	cap.setCapability("browserName", "chrome");
	    	
	    }
	    
	    driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()  {
		driver.quit();
	}

}
