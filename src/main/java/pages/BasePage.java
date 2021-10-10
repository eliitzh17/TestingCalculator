package pages;

import org.openqa.selenium.WebDriver;
import steps.SetupTest;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = SetupTest.driver;
    }
}
