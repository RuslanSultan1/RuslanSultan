package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
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

    @FindBy(css = ".panel-body-list.logs>li")
    private List<SelenideElement> logs;

    private int leftSliderCurrentPos = 20;
    private int rightSliderCurrentPos = 100;

    private void setAndCheckSlider(SelenideElement slider, int currentPos, int destination) {
        Actions actions = new Actions(getWebDriver());
        int step;
        boolean flag=false;
        if (currentPos <= destination) {
            step = sliderRange.getSize().width / 100;
        } else {
            step = -sliderRange.getSize().width / 50;
        }
        while (Integer.valueOf(slider.getText()) != destination) {
            actions.dragAndDropBy(slider, step, 0).perform();
            flag=true;
        }
        currentPos = destination;
        if (flag) logs.get(0).shouldHave(text(String.valueOf(destination)));
    }

    public void setAndCheckSliders(int from, int to) {
        setAndCheckSlider(leftSlider, leftSliderCurrentPos, from);
        setAndCheckSlider(rightSlider, rightSliderCurrentPos, to);
    }

}
