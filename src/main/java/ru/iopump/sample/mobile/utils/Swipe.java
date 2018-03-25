package ru.iopump.sample.mobile.utils;

import com.google.common.base.Preconditions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.mk.pump.web.browsers.Browser;
import ru.mk.pump.web.elements.api.Element;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class Swipe {
    private final PointOption startPoint;
    private final PointOption stopPoint;
    private final Dimension windowSize;
    private final Pair<Dimension,Dimension> element;
    @Getter
    @NonNull
    private final Direction direction;

    private Swipe(@NonNull Dimension windowSize, @Nullable Pair<Dimension,Dimension> elementCenter, @NonNull Direction direction, @Nullable PointOption startPoint, @Nullable PointOption stopPoint) {
        this.windowSize = windowSize;
        this.element = elementCenter;
        this.direction = direction;
        this.startPoint = startPoint;
        this.stopPoint = stopPoint;
    }

    private Swipe(@NonNull WebDriver driver, @Nullable Element relativeElement) {
        this(windowSize(driver),
                relativeElement != null ? element(relativeElement, windowSize(driver)) : null,
                Direction.NONE,
                null,
                null);
    }

    public static Swipe of(@NonNull Element relativeElement) {
        return new Swipe(relativeElement.advanced().getBrowser().getDriver(), relativeElement);
    }

    public static Swipe of(@NonNull Browser driver) {
        return new Swipe(driver.getDriver(), null);
    }

    private Swipe create(Direction direction) {
        if (element != null) {
            return new Swipe(windowSize, element, direction, calcStartPointByElement(direction), calcStopPointByElement(direction));
        } else {
            return new Swipe(windowSize, null, direction, calcStartPointByWindow(direction), calcStopPointByWindow(direction));
        }
    }

    public Swipe withDirection(Direction direction) {
        return create(direction);
    }

    public Swipe left() {
        return create(Direction.LEFT);
    }

    public Swipe right() {
        return create(Direction.RIGHT);
    }

    public Swipe up() {
        return create(Direction.UP);
    }

    public Swipe down() {
        return create(Direction.DOWN);
    }

    @NonNull
    public PointOption getStart() {
        if (startPoint == null) {
            throw new IllegalStateException("You must choose swipe direction");
        }
        return startPoint;
    }

    @NonNull
    public PointOption getStop() {
        if (stopPoint == null) {
            throw new IllegalStateException("You must choose swipe direction");
        }
        return stopPoint;
    }

    public enum Direction {
        DOWN, UP, LEFT, RIGHT, NONE
    }

    private PointOption calcStartPointByElement(Direction direction) {
        switch (direction) {
            case DOWN:
                return PointOption.point(element.getKey().width, element.getKey().height);
            case UP:
                return PointOption.point(element.getKey().width,element.getKey().height);
            case LEFT:
                return PointOption.point(element.getKey().width - element.getValue().width / 2, element.getKey().height);
            case RIGHT:
                return PointOption.point(element.getKey().width + element.getValue().width / 2, element.getKey().height);
        }
        throw new IllegalArgumentException();
    }

    private PointOption calcStopPointByElement(Direction direction) {
        switch (direction) {
            case DOWN:
                return PointOption.point(element.getKey().width, (int) (windowSize.height * 0.1));
            case UP:
                return PointOption.point(element.getKey().width, (int) (windowSize.height * 0.8));
            case LEFT:
                return PointOption.point(element.getKey().width + element.getValue().width / 2, element.getKey().height);
            case RIGHT:
                return PointOption.point(element.getKey().width - element.getValue().width / 2, element.getKey().height);
        }
        throw new IllegalArgumentException();
    }

    private PointOption calcStartPointByWindow(Direction direction) {
        switch (direction) {
            case DOWN:
                return PointOption.point((int) (windowSize.width * 0.1), (int) (windowSize.height * 0.8));
            case UP:
                return PointOption.point((int) (windowSize.width * 0.1), (int) (windowSize.height * 0.1));
            case LEFT:
                return PointOption.point((int) (windowSize.width * 0.1), (int) (windowSize.height * 0.1));
            case RIGHT:
                return PointOption.point((int) (windowSize.width * 0.9), (int) (windowSize.height * 0.1));
        }
        throw new IllegalArgumentException();
    }

    @SuppressWarnings("Duplicates")
    private PointOption calcStopPointByWindow(Direction direction) {
        switch (direction) {
            case DOWN:
                return PointOption.point((int) (windowSize.width * 0.1), (int) (windowSize.height * 0.1));
            case UP:
                return PointOption.point((int) (windowSize.width * 0.1), (int) (windowSize.height * 0.8));
            case LEFT:
                return PointOption.point((int) (windowSize.width * 0.9), (int) (windowSize.height * 0.1));
            case RIGHT:
                return PointOption.point((int) (windowSize.width * 0.1), (int) (windowSize.height * 0.1));
        }
        throw new IllegalArgumentException();
    }

    private static Pair<Dimension,Dimension> element(Element relativeElement, Dimension winSize) {
        Preconditions.checkNotNull(relativeElement);
        WebElement avatar = relativeElement.advanced().getFinder().findFast().throwExceptionOnFail().getResult();
        int x = avatar.getLocation().getX() + avatar.getSize().getWidth() / 2;
        int y = avatar.getLocation().getY() + avatar.getSize().getHeight() / 2;
        return Pair.of(new Dimension(x, y), avatar.getSize());
    }

    private static Dimension windowSize(WebDriver driver) {
        Preconditions.checkNotNull(driver);
        return driver.manage().window().getSize();
    }
}