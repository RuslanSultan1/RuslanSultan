package hw2.ex3;

import base.hw2.SeleniumBase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestWithAnnotations extends SeleniumBase1 {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void testWithAnnotations() {
        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is logged in
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(),
                "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        assertTrue(driver.findElement(By.cssSelector(".uui-header [href='index.html']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".uui-header [href='index.html']")).getText(),
                "HOME");
        assertTrue(driver.findElement(By.cssSelector(".uui-header [href='contacts.html']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".uui-header [href='contacts.html']")).getText(),
                "CONTACT FORM");
        assertTrue(driver.findElement(By.cssSelector(".uui-header [data-toggle='dropdown']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".uui-header [data-toggle='dropdown']")).getText(),
                "SERVICE");
        assertTrue(driver.findElement(By.cssSelector(".uui-header [href='metals-colors.html']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".uui-header [href='metals-colors.html']")).getText(),
                "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-base")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(1)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(1)")).getText(),
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(2)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(2)")).getText(),
                "To be flexible and\n" + "customizable");
        assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(3)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(3)")).getText(),
                "To be multiplatform");
        assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(4)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(4)")).getText(),
                "Already have good base\n" + "(about 20 internal and\n" +
                        "some external projects),\n" + "wish to get more…");

        //9 Assert a text of the main headers
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(".main-txt")).getText(),
                "LOREM IPSUM DOLOR SIT AMET," +
                        " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
                        "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU " +
                        "FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("iframe"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iframe);
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().parentFrame();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center a"));
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());
    }
}