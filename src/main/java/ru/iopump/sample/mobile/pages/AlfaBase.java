package ru.iopump.sample.mobile.pages;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.support.FindBy;
import ru.iopump.sample.mobile.components.Card;
import ru.iopump.sample.mobile.elements.ElementMobile;
import ru.mk.pump.commons.constants.StringConstants;
import ru.mk.pump.commons.helpers.Parameters;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.common.api.annotations.PElement;
import ru.mk.pump.web.constants.ElementParams;
import ru.mk.pump.web.elements.api.Element;
import ru.mk.pump.web.elements.api.concrete.Button;
import ru.mk.pump.web.elements.api.concrete.Input;
import ru.mk.pump.web.elements.api.concrete.TextArea;
import ru.mk.pump.web.page.BasePage;

import java.util.List;
import java.util.Map;

public class AlfaBase extends BasePage {

    @PElement(value = "Назад")
    @FindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'toolbar')]/android.widget.ImageButton")
    private Button back;

    @PElement(value = "Запретить", desc = "Запрос безопасности телефона на доступ - Запретить")
    @FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private Button deny;

    public AlfaBase(Browser browser) {
        super(browser);
    }
    @Override
    protected void afterConstruct() {
        Map<Class<? extends Element>, Parameters> parametersMap = ImmutableMap.<Class<? extends Element>, Parameters>builder()
                .put(Button.class, Parameters.of(ElementParams.FOCUS_CUSTOM_SCRIPT.withValue(StringConstants.EMPTY)))
                .put(TextArea.class, Parameters.of(ElementParams.FOCUS_CUSTOM_SCRIPT.withValue(StringConstants.EMPTY)))
                .put(ElementMobile.class, Parameters.of(ElementParams.FOCUS_CUSTOM_SCRIPT.withValue(StringConstants.EMPTY)))
                .put(Input.class, Parameters.of(ElementParams.FOCUS_CUSTOM_SCRIPT.withValue(StringConstants.EMPTY)))
                .build();
        getInitializer().setElementsImplParametersStore(parametersMap);
        super.afterConstruct();
    }

    @Override
    public void check() {
        /*do nothing*/
    }
}
