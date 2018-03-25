package ru.iopump.sample.mobile.elements;

import ru.iopump.sample.mobile.utils.Swipe;
import ru.mk.pump.commons.utils.WaitResult;
import ru.mk.pump.web.elements.api.Element;

public interface ElementMobile extends Element {

    WaitResult<Boolean> swipeTo(Swipe.Direction direction);

    WaitResult<Boolean> swipeTo(Element element, Swipe.Direction direction);

    WaitResult<Boolean> swipeTo(Element element, String expectedText, Swipe.Direction direction);
}
