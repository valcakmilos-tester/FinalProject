package com.example.TutorialPoint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;



public class FinalProjectCheckBox {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\ProgramovanieKody\\SkillmeaOOP2\\SkilmeaBDD\\SkillmeaSelenium\\SkillmeaSelenium\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

  @Test
  public void testFinalProjectCheckBox() throws Exception {
    driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
      // Nájdeme oba checkboxy
      WebElement checkbox1 = driver.findElement(By.id("c_bs_1"));
      WebElement checkbox2 = driver.findElement(By.id("c_bs_2"));

      // Klikneme na ne
      checkbox1.click();
      checkbox2.click();

      // OVERENIA:
      Assertions.assertTrue(checkbox1.isSelected(), "Checkbox 1 NIE je zaškrtnutý!");
      Assertions.assertTrue(checkbox2.isSelected(), "Checkbox 2 NIE je zaškrtnutý!");

  }
}
