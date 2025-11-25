package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class REQC3Checkboxes {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();


  @BeforeEach
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\ProgramovanieKody\\SkillmeaOOP2\\SkilmeaBDD\\SkillmeaSelenium\\SkillmeaSelenium\\src\\main\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";

  }

  @Test
  public void testREQC3Checkboxes() throws Exception {
    driver.get("http://localhost/req_c3_checkboxes.html");
    /*driver.findElement(By.id("parent")).click();
    driver.findElement(By.id("child1")).click();
    driver.findElement(By.id("child2")).click();
    driver.findElement(By.id("child3")).click();
    */
      WebElement parent = driver.findElement(By.id("parent"));

      if (parent.isDisplayed()) {
          parent.click();

          driver.findElement(By.id("child1")).click();
          driver.findElement(By.id("child2")).click();
          driver.findElement(By.id("child3")).click();
      }
      try {
          Thread.sleep(4000); // pauza 2000 ms = 2 sekundy
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      if (parent.isDisplayed()) {
          parent.click();

          driver.findElement(By.id("child1")).click();
          driver.findElement(By.id("child2")).click();
          driver.findElement(By.id("child3")).click();
      }
  }

}
