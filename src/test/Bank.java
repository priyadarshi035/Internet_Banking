package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Bank {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://genericbankui.mybluemix.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHsbc() throws Exception {
    driver.get(baseUrl);
    driver.manage().window().maximize();
    Thread.sleep(3000);
    driver.findElement(By.id("username")).sendKeys("1234");
    Thread.sleep(3000);
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).click();
    Thread.sleep(2000);
    
    new Select(driver.findElement(By.name("from_country"))).selectByVisibleText("IND");
    new Select(driver.findElement(By.name("to_country"))).selectByVisibleText("IND");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[8]/button")).click();
    
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("100");
    driver.findElement(By.name("transferinfo")).clear();
    driver.findElement(By.name("transferinfo")).sendKeys("ABCD");
    new Select(driver.findElement(By.name("additioninfo"))).selectByVisibleText("AUD");
    driver.findElement(By.xpath("//div[32]/button")).click();
   /* driver.findElement(By.xpath("//div[32]/button")).click();*/
    Thread.sleep(2000);
    driver.findElement(By.linkText("logout")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

