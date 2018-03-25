package ru.iopump.sample.mobile.pages;

import org.openqa.selenium.support.FindBy;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.common.api.annotations.PPage;
import ru.mk.pump.web.elements.api.concrete.Button;

import java.util.List;

@PPage(value = "Счета и карты", desc = "Список карт и счетов пользователя")
public class AccountsAndCards extends AlfaBase {

    @PElement(value = "Карты", desc = "Карты с картинкой, названием и номером")
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='ru.alfabank.mobile.android:id/root']")
    private List<Button> cards;

    public AccountsAndCards(Browser browser) {
        super(browser);
    }
}
