package ru.iopump.sample.mobile.pages;

import org.openqa.selenium.support.FindBy;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.common.api.annotations.PPage;
import ru.mk.pump.web.elements.api.concrete.Button;

@PPage(value = "Выбор языка", desc = "Экран выбора страны. Автоматически загружается после приветствия")
public class SelectCountry extends AlfaBase {

    @PElement(value = "Россия", desc = "Локаль Россия")
    @FindBy(id = "ru.alfabank.mobile.android:id/select_country_ru_button")
    private Button ru;

    @PElement(value = "Казахстан", desc = "Локаль Казахстан")
    @FindBy(id = "ru.alfabank.mobile.android:id/select_country_kz_button")
    private Button kz;

    public SelectCountry(Browser browser) {
        super(browser);
    }


}
