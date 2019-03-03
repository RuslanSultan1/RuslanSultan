package base.jdi.pages;

import base.jdi.entities.User;
import base.jdi.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.complex.Menu;
import enums.HeaderMenu;
import org.openqa.selenium.support.FindBy;

public class IndexPageJdi extends WebPage {
    LoginForm loginForm;
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8'] //a[text()='%s']")
    public Menu menu;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void openPage(HeaderMenu page) {
        menu.select(page);
    }

}
