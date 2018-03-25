package ru.iopump.sample.mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.iopump.sample.mobile.elements.ElementMobile;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.component.BaseComponent;
import ru.mk.pump.web.elements.internal.interfaces.InternalElement;
import ru.mk.pump.web.page.api.Page;

public class Card extends BaseComponent {

    @PElement(value = "Номер")
    @FindBy(id = "ru.alfabank.mobile.android:id/card_number")
    private ElementMobile number;

    @PElement(value = "Срок")
    @FindBy(id = "ru.alfabank.mobile.android:id/card_valid_thru")
    private ElementMobile validPeriod;

    public Card(By avatarBy, Page page) {
        super(avatarBy, page);
    }

    public Card(By avatarBy, InternalElement parentElement) {
        super(avatarBy, parentElement);
    }

    public Card(By avatarBy, Browser browser) {
        super(avatarBy, browser);
    }
}
