package com.epam.tc.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Locale;

@UtilityClass
public class DriverFabric {

    @SneakyThrows
    public WebDriver getWebDriver(final boolean isLocal, final String hub, @NonNull final String browser) {

        if (isLocal) {

            return WebDriverManager.getInstance(browser).create();
        } else {
            Capabilities caps;
            switch (browser.toUpperCase(Locale.ROOT)) {
                case "FIREFOX":
                    caps = new FirefoxOptions();
                    break;
                case "CHROME":
                default:
                    caps = new ChromeOptions();
                    break;
            }

            return new RemoteWebDriver(new URL(hub),caps);
        }
    }
}
