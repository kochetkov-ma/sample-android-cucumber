package steps;

import cucumber.api.java.en.Given;
import ru.iopump.sample.mobile.elements.ElementMobile;
import ru.iopump.sample.mobile.utils.Swipe;
import ru.mk.pump.commons.utils.WaitResult;
import ru.mk.pump.cucumber.steps.AbstractSteps;
import ru.mk.pump.web.common.WebItemsController;
import ru.mk.pump.web.elements.api.Element;

public class Steps extends AbstractSteps {

    @Given("^Page - get element '(.+)' and scroll to other element '([^']+)' in direction '(.+?)'$")
    public void scroll(String mainElementExpression, String expectedElementExpression, Swipe.Direction direction) {
        Element main = WebItemsController.cast(core().getWebController().executeOnCurrentPage(mainElementExpression), Element.class);
        ElementMobile expected = WebItemsController.cast(core().getWebController().executeOnCurrentPage(expectedElementExpression), ElementMobile.class);
        WaitResult<Boolean> res = expected.swipeTo(main, direction);
        res.throwExceptionOnFail();
    }

    @Given("^Page - get element '(.+)' and scroll to other element '(.+)' with text '(.+)' in direction '(.+)'$")
    public void scrollConditions(String mainElementExpression, String expectedElementExpression, String expectedText, Swipe.Direction direction) {
        Element main = WebItemsController.cast(core().getWebController().executeOnCurrentPage(mainElementExpression), Element.class);
        ElementMobile expected = WebItemsController.cast(core().getWebController().executeOnCurrentPage(expectedElementExpression), ElementMobile.class);
        WaitResult<Boolean> res = expected.swipeTo(main, expectedText, direction);
        res.throwExceptionOnFail();
    }

    @Given("^Page - scroll to other element '(.+)' in direction '(.+)'$")
    public void scroll(String expectedElementExpression, Swipe.Direction direction) {
        ElementMobile expected = WebItemsController.cast(core().getWebController().executeOnCurrentPage(expectedElementExpression), ElementMobile.class);
        WaitResult<Boolean> res = expected.swipeTo(direction);
        res.throwExceptionOnFail();
    }

    @Deprecated
    @Given("^Page - scroll down$")
    public void scrollDown() {
        core().getBrowsers().get().actions().mobileScrollDown();
    }
}
