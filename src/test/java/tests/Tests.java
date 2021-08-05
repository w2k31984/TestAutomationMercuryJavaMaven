
/**
 * @author w2k31984
 *
 */
package tests;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



/**Creando nuestra primera clase**/
 public class Tests {
	 private WebDriver driver;
	 @BeforeMethod
	 public void setUp() {
		 DesiredCapabilities caps = new DesiredCapabilities();
		 System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.navigate().to("http://demo.guru99.com/test/newtours/");
		 try {
			 Thread.sleep(3000);
		 }catch(InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }
	 
	 //Creando nuestro primer test de prueba.
	 @Test
	 public void testUno() {
		 driver.findElement(By.name("userName")).sendKeys("user");
		 driver.findElement(By.name("password")).sendKeys("user");
		 driver.findElement(By.name("login")).click();
		 try {
			 Thread.sleep(3000);
		 }catch(InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 Assert.assertTrue(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[3]/td[1]/p[1]/font[1]/b[1]")).getText().contains("Welcome back to Mercury Tours!"));
	 }
	 @AfterMethod
	 public void tearDown(){
		 driver.close();
	 }
 }