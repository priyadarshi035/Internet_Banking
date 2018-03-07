package test;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class RetailBanking {
	 		@Test
	public void RetailBanking() throws InterruptedException {
	 System.out.println("*****Inside TestBank Class For Selenium Code Execution..\n");
	 Thread.sleep(18000);
    DesiredCapabilities DesireCaps = new DesiredCapabilities();
/* DesireCaps.setJavascriptEnabled(true);*/
	 /*DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS,"/var/jenkins_home/jobs/Fund-Transfer-Demo/workspace/driver/phantomjs");*/
/*	DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_PATH_PROPERTY,"/home/phantomjs");*/
    DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"driver/phantomjs");
	/* DesireCaps.setCapability("phantom.binary.path","/home/phantomjs");*/
	 
	 
	 
		System.out.print("*****Read the file in the path.......\n");		
	WebDriver driver = new PhantomJSDriver(DesireCaps);
   /*	System.out.println(driver.getCapabilities()); */
		System.out.println("*****Driver Executed in linux......\n");	
	 		/*	WebDriver driver = new FirefoxDriver(); */
	 		/*	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); */
	 			
		driver.get("https://internetbanking.mybluemix.net/#/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	/*	driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).click();
		driver.findElement(By.id("username")).sendKeys("demo");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("demo");
		String s1 = driver.findElement(
				By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).getText();
		System.out.println("Login Button" + s1);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).click();
		Thread.sleep(15000);
		System.out.println(driver.getTitle());
		 new Select(driver.findElement(By.name("from_country"))).selectByIndex(3);
		    new Select(driver.findElement(By.name("to_country"))).selectByIndex(2);
		String s2 = driver.findElement(By.xpath("//div[7]/button")).getText();
		System.out.println("End page button" + s2);
		driver.findElement(By.xpath("//div[7]/button")).click();
		driver.findElement(By.name("amount")).clear();
		driver.findElement(By.name("amount")).sendKeys("100");
		driver.findElement(By.name("transferinfo")).clear();
		driver.findElement(By.name("transferinfo")).sendKeys("ABCD");
		new Select(driver.findElement(By.name("additioninfo"))).selectByVisibleText("AUD");
		Thread.sleep(2000);
		String s3 = driver.findElement(By.xpath("//div[32]/button")).getText();
		System.out.println("Page next 1" + s3);
		driver.findElement(By.xpath("//div[32]/button")).click();
		Thread.sleep(2000);
		String s4 = driver.findElement(By.xpath("//div[32]/button")).getText();
		System.out.println(s4);
		List <WebElement> options = driver.findElements(By.xpath("//div[32]/button"));
		int Rows_Count=options.size();
		options.get(0).click();
		Thread.sleep(4000);	
		System.out.println(driver.findElement(By.linkText("Go - back to home")).getText());
		driver.findElement(By.linkText("Go - back to home")).click();
		String s5 = driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div/div/div/a")).getText();
		System.out.println(s5);
		driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div/div/div/a")).click();	*/
		driver.quit();
		
	}
		
}
