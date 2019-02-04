package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParallelDataProviderTest extends SeleniumBase {
    @DataProvider(parallel = true)
    private Object[][] simpleDataProvider() {
        return new Object[][]{
                {".benefits .col-sm-3:nth-of-type(1)", "To include good practices\n" +
                        "and ideas from successful\n" + "EPAM project"},
                {".benefits .col-sm-3:nth-of-type(2)", "To be flexible and\n" + "customizable"},
                {".benefits .col-sm-3:nth-of-type(3)", "To be multiplatform"},
                {".benefits .col-sm-3:nth-of-type(4)", "Already have good base\n" +
                        "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void simpleTest(String cssSelector, String expectedResult) {
        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert that 4 texts on the Index Page under have proper text
        assertEquals(driver.findElement(By.cssSelector(cssSelector)).getText(), expectedResult);

        //3 Close Browser
        driver.close();
    }
}
