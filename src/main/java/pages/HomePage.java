package pages;

import elemnets.CalculatorElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By calculatorId = By.className("calccontainer");
    private CalculatorElement calculator;

    public HomePage() {
        super();
        calculator = new CalculatorElement(driver.findElement(calculatorId));
    }

    public CalculatorElement getCalculator() {
        return calculator;
    }
}
