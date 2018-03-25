package ru.iopump.sample.mobile.pages;

import org.openqa.selenium.support.FindBy;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.common.api.annotations.PPage;
import ru.mk.pump.web.elements.api.concrete.Button;
import ru.mk.pump.web.elements.api.concrete.Input;

import java.util.List;

@PPage(value = "Платежи и переводы")
public class Payments extends AlfaBase {

    @PElement(value = "Между счетами")
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='ru.alfabank.mobile.android:id/recipient_image']")
    private Button betweenAccounts;

    @PElement(value = "Перевод ввод")
    @FindBy(id = "ru.alfabank.mobile.android:id/amount_input")
    private Input transferInput;

    @PElement(value = "Перевод")
    @FindBy(id = "ru.alfabank.mobile.android:id/perform_action")
    private Button transfer;

    @PElement(value = "Отмена")
    @FindBy(id = "ru.alfabank.mobile.android:id/cancel_confirm")
    private Button cancel;

    public Payments(Browser browser) {
        super(browser);
    }
}
