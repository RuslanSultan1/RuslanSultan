package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.System.setProperty;

public class HomePageTestWithSoftAsserts {

    @Test
    public void homePageTestWithSoftAsserts() {
        //0 Creating SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        //1 Open test site by URL
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is logged in
        softAssert.assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(),
                "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(driver.findElement(By.cssSelector(".uui-header [href='index.html']")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".uui-header [href='index.html']")).getText(),
                "HOME");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".uui-header [href='contacts.html']")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".uui-header [href='contacts.html']")).getText(),
                "CONTACT FORM");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".uui-header [data-toggle='dropdown']")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".uui-header [data-toggle='dropdown']")).getText(),
                "SERVICE");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".uui-header [href='metals-colors.html']"))
                .isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".uui-header [href='metals-colors.html']")).getText(),
                "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-base")).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(1)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(1)")).getText(),
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(2)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(2)")).getText(),
                "To be flexible and\n" + "customizable");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(3)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(3)")).getText(),
                "To be multiplatform");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(4)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".benefits .col-sm-3:nth-of-type(4)")).getText(),
                "Already have good base\n" + "(about 20 internal and\n" +
                        "some external projects),\n" + "wish to get more…");

        //9 Assert a text of the main headers
        softAssert.assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".main-title")).getText(),
                "EPAM FRAMEWORK WISHES…");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector(".main-txt")).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                        "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
                        "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE " +
                        "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iframe);
        softAssert.assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().parentFrame();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center a"));
        softAssert.assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.cssSelector(".uui-side-bar")).isDisplayed());

        //16 Assert that there is Footer
        softAssert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17 Close Browser
        driver.close();

        //18 Check all asserts
        softAssert.assertAll();
    }
}