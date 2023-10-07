package fb;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FbLogin {
	ChromeDriver driver;
	SoftAssert sa;
	@Test
	@BeforeMethod
	public void browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe" );
		 driver=new ChromeDriver();

	}
	@Test
	@Parameters({"email","pass"})
	public void login(String email,String pass) throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6lux']/input[@id='email']")).sendKeys(email);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_6lux']/div[@id='passContainer']/input[@id='pass']")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_6ltg']/button")).click();
		
	}
	@AfterMethod
	public void after() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
