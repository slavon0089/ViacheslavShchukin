package steps;

import static steps.AbstractStep.webDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackGroundStep {
    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After()
    public void browserQuit() {
        webDriver.quit();
        webDriver = null;
    }
}
