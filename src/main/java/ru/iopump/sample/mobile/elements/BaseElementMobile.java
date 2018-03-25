package ru.iopump.sample.mobile.elements;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import ru.iopump.sample.mobile.utils.Swipe;
import ru.mk.pump.commons.utils.Strings;
import ru.mk.pump.commons.utils.WaitResult;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.elements.api.Element;
import ru.mk.pump.web.elements.enums.StateType;
import ru.mk.pump.web.elements.internal.BaseElement;
import ru.mk.pump.web.elements.internal.State;
import ru.mk.pump.web.elements.internal.interfaces.InternalElement;
import ru.mk.pump.web.page.api.Page;

import javax.annotation.Nullable;

public class BaseElementMobile extends BaseElement implements ElementMobile {
    public BaseElementMobile(By avatarBy, Page page) {
        super(avatarBy, page);
    }

    public BaseElementMobile(By avatarBy, InternalElement parentElement) {
        super(avatarBy, parentElement);
    }

    public BaseElementMobile(By avatarBy, Browser browser) {
        super(avatarBy, browser);
    }


    private State swipeSate(@Nullable Element element, @Nullable String expectedText, @NonNull Swipe.Direction direction) {
        final Swipe swipe = element != null ? Swipe.of(element).withDirection(direction) : Swipe.of(getBrowser()).withDirection(direction);
        return State.of(StateType.DISPLAYED,
                webElement -> {

                    boolean res = webElement.isSuccess() && webElement.getResult().isDisplayed()
                            && (expectedText == null || StringUtils.contains(getBrowser().actions().getText(webElement.getResult()), expectedText));
                    if (!res) {
                        getBrowser().actions().mobileScroll(swipe.getStart(), swipe.getStop());
                    }
                    return res;
                }, getFinder()).withName(String.format("Swipe to element '%s' from '%s' to '%s'",
                info().getName(),
                Strings.toString(swipe.getStart().build()),
                Strings.toString(swipe.getStop().build())));
    }

    @Override
    public WaitResult<Boolean> swipeTo(Swipe.Direction direction) {
        return getStateResolver().resolve(swipeSate(null, null, direction)).result();
    }

    @Override
    public WaitResult<Boolean> swipeTo(Element element, Swipe.Direction direction) {
        element.isDisplayed().result().throwExceptionOnFail();
        return getStateResolver().resolve(swipeSate(element, null, direction)).result();
    }

    @Override
    public WaitResult<Boolean> swipeTo(Element element, String expectedText, Swipe.Direction direction) {
        element.isDisplayed().result().throwExceptionOnFail();
        return getStateResolver().resolve(swipeSate(element, expectedText, direction)).result();
    }
}