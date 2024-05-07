/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author phalk
 */
public class GoogleSearchTest {
    private WebDriver driver;
    
    
    public GoogleSearchTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }
    
      @Test
    public void testGoogleSearch() {
        // Open Google
        driver.get("https://www.google.com");

        // Find the search input element by its name
        WebElement searchBox = driver.findElement(By.name("q"));

        // Type the search query
        searchBox.sendKeys("Selenium testing");

        // Submit the form
        searchBox.submit();
        
        // Verify that search results page title contains the search query
        Assert.assertTrue(driver.getTitle().contains("Selenium testing"));
    }
}
