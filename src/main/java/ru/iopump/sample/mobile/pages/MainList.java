package ru.iopump.sample.mobile.pages;

import org.openqa.selenium.support.FindBy;
import ru.iopump.sample.mobile.elements.ElementMobile;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.common.api.annotations.PPage;
import ru.mk.pump.web.elements.api.concrete.Button;
import ru.mk.pump.web.elements.api.concrete.TextArea;

import java.util.List;

@PPage(value = "Основной экран", desc = "Основная страница пользователя со счетами")
public class MainList extends AlfaBase {

    @PElement(value = "Показать все счета", desc = "Показать все счета")
    @FindBy(id = "ru.alfabank.mobile.android:id/banking_account_item_header")
    private Button showAllAccounts;

    @PElement(value = "Счета и карты", desc = "Счета и карты")
    @FindBy(id = "ru.alfabank.mobile.android:id/widget_cards_group")
    private Button accountsAndCards;

    @PElement(value = "Платежи и переводы")
    @FindBy(id = "ru.alfabank.mobile.android:id/all_payments_widget_payments")
    private Button payments;

    @PElement(value = "Счета", desc = "Счета из раскрывающегося списка")
    @FindBy(xpath = "//android.widget.TextView[@resource-id='ru.alfabank.mobile.android:id/widget_account_item_balance']")
    private List<TextArea> accountsList;

    @PElement(value = "Альфа", desc = "Иконка Альфа-Банка внизу экрана")
    @FindBy(xpath = "//*[@resource-id='ru.alfabank.mobile.android:id/widget_currencies_list_container']/../../following-sibling::android.widget.FrameLayout//android.widget.ImageView")
    private ElementMobile alfaIcon;

    public MainList(Browser browser) {
        super(browser);
    }
}
