package org.example;

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
      System.out.println("####### Test Case REQ-C1 ######");
      // Nájdeme oba checkboxy
      WebElement checkbox1 = driver.findElement(By.id("c_bs_1"));
      WebElement checkbox2 = driver.findElement(By.id("c_bs_2"));

      // Klikneme na ne
      checkbox1.click();
      checkbox2.click();

      // OVERENIA:

      Assertions.assertTrue(checkbox1.isSelected(), "Checkbox 1 NIE je zaškrtnutý!");
      Assertions.assertTrue(checkbox2.isSelected(), "Checkbox 2 NIE je zaškrtnutý!");
      System.out.println("####### Test Case REQ-C1 úspešne ukončený ######");
  }
    @Test
    public void testREQC2_SimulatedParentChildBehavior() throws Exception {

        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        System.out.println("####### Test Case REQ-C2 ######");
        // simulovaný parent checkbox (true/false)
        boolean parent = false;

        WebElement child1 = driver.findElement(By.id("c_bs_1"));
        WebElement child2 = driver.findElement(By.id("c_bs_2"));

        // ---------------------------------------------------------------------
        // 1️⃣ SCENÁR: OBA CHILD SÚ ZAŠKRTNUTÉ  →  PARENT = TRUE
        // ---------------------------------------------------------------------


        child1.click(); // zakomentovanimm zmením podmienku
        child2.click(); // zakomentovanim zmením podmienku

        boolean c1 = child1.isSelected();
        boolean c2 = child2.isSelected();

        if (c1 && c2) {
            parent = true;    // pravidlo: všetky deti → parent = true
        }

        Assertions.assertTrue(parent,
                "REQ-C2 FAILED → Parent má byť TRUE keď oba child sú zaškrtnuté!");


        // ---------------------------------------------------------------------
        // 2️⃣ SCENÁR: JEDEN CHILD JE ODOŠKRTNUTÝ → PARENT = FALSE
        // ---------------------------------------------------------------------

        child1.click();  // odškrtneme child1
        c1 = child1.isSelected(); // načítame nový stav

        if (!c1 || !c2) {
            parent = false;   // pravidlo: ak aspoň jedno dieťa false → parent = false
        }

        Assertions.assertFalse(parent,
                "REQ-C2 FAILED → Parent má byť FALSE keď jeden child nie je zaškrtnutý!");


        // ---------------------------------------------------------------------
        // 3️⃣ SCENÁR: OBA CHILD NIE SÚ ZAŠKRTNUTÉ → PARENT = FALSE
        // ---------------------------------------------------------------------

        child2.click(); // odškrtneme aj child2
        c1 = child1.isSelected();
        c2 = child2.isSelected();

        if (!c1 && !c2) {
            parent = false;   // obe deti false -> parent musí byť false
        }

        Assertions.assertFalse(parent,
                "REQ-C2 FAILED → Parent má byť FALSE keď ani jeden child NIE je zaškrtnutý!");
        System.out.println("####### Test Case REQ-C2 ukončený ######");
    }

}
