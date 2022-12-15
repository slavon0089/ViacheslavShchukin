package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitActions {

    private WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public Boolean waitUntilCondition(Function<WebDriver, Boolean> p) {
        return webDriverWait.ignoring(NoSuchElementException.class)
                .until(p);
    }
}
