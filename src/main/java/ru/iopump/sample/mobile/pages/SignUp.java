package ru.iopump.sample.mobile.pages;

import org.openqa.selenium.support.FindBy;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.common.api.annotations.PPage;
import ru.mk.pump.web.elements.api.concrete.Button;

@PPage(value = "Авторизация", desc = "Экран авторизации с возможностью демо режима")
public class SignUp extends AlfaBase {

    @PElement(value = "Демо", desc = "Демо аккаунт")
    @FindBy(id = "ru.alfabank.mobile.android:id/sign_up_demo")
    private Button demo;

    public SignUp(Browser browser) {
        super(browser);
    }
}
