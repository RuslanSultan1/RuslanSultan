package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {
    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private SelenideElement rightSlider;

    @FindBy(css = ".ui-slider")
    private SelenideElement sliderRange;

    @FindBy(css = ".logs li")
    private List<SelenideElement> logs;

    private Integer leftSliderCurrentPos = 20;
    private Integer rightSliderCurrentPos = 100;

    private void setAndCheckSlider(int destination, SelenideElement slider, Integer currentPos) {
        float step = (float) (sliderRange.getSize().width / 100.0);
        int delta = (int) ((destination - currentPos) * step - 2);
        new Actions(getWebDriver()).dragAndDropBy(slider, delta, 0).perform();
        if (slider.equals(leftSlider)) leftSliderCurrentPos = destination;
        else rightSliderCurrentPos = destination;
        slider.shouldHave(text(String.valueOf(destination)));
    }

    // It's needed, when sliders get into one position. It changes order of calling setAndCheckSlider method
    // for left and right sliders.
    boolean switcher = true;

    @Step("Setting sliders range from {from} to {to} and checking them.")
    public void setAndCheckSliders(int from, int to) {
        if (switcher) {
            setAndCheckSlider(from, leftSlider, leftSliderCurrentPos);
            setAndCheckSlider(to, rightSlider, rightSliderCurrentPos);
        } else {
            setAndCheckSlider(to, rightSlider, rightSliderCurrentPos);
            setAndCheckSlider(from, leftSlider, leftSliderCurrentPos);
        }
        if (from == to) switcher = !switcher;
    }
}
