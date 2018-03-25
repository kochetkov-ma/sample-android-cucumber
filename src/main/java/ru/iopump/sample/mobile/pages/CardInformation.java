package ru.iopump.sample.mobile.pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import ru.iopump.sample.mobile.components.Card;
import ru.iopump.sample.mobile.elements.ElementMobile;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PAction;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.common.api.annotations.PPage;
import ru.mk.pump.web.elements.api.concrete.Button;

import java.util.List;

@PPage(value = "Информация о карте", desc = "Информация о карте")
public class CardInformation extends AlfaBase {

    @PElement(value = "Карты", desc = "Карты с картинкой, названием и номером")
    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='ru.alfabank.mobile.android:id/card_base']")
    private List<Card> cards;

    @PElement(value = "Имя карты")
    @FindBy(id = "ru.alfabank.mobile.android:id/card_name_view")
    private ElementMobile cardName;

    public CardInformation(Browser browser) {
        super(browser);
    }
}
