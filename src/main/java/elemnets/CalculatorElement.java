package elemnets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.SetupTest;

public class CalculatorElement extends BaseElement {
    private By inputBoxId = By.id("input");
    private By openHistoryButtonClass = By.className("dropdown-toggle");
    private By historyId = By.id("histframe");
    private By divButtonId = By.id("BtnDiv");
    private By clearButtonId = By.id("BtnClear");
    private By multipleButtonId = By.id("BtnMult");
    private By minusButtonId = By.id("BtnMinus");
    private By plusButtonId = By.id("BtnPlus");
    private By calculateButtonId = By.id("BtnCalc");
    private By dotButtonId = By.id("BtnDot");
    private By paranLButtonId = By.id("BtnParanL");
    private By paranRButtonId = By.id("BtnParanR");

    public CalculatorElement() {
    }

    public CalculatorElement(WebElement element) {
        super(element);
    }

    public WebElement SendEquation(String equation) {
        Clear();
        element.findElement(inputBoxId).sendKeys(equation);
        return element;
    }

    public WebElement Plus() {
        element.findElement(plusButtonId).click();
        return element;
    }

    public WebElement Minus() {
        element.findElement(minusButtonId).click();
        return element;
    }

    public WebElement Div() {
        element.findElement(divButtonId).click();
        return element;
    }

    public WebElement Multiple() {
        element.findElement(multipleButtonId).click();
        return element;
    }

    public WebElement Clear() {
        element.findElement(clearButtonId).click();
        return element;
    }

    public WebElement Calculate() {
        element.findElement(calculateButtonId).click();
        return element;
    }

    public WebElement Dot() {
        element.findElement(dotButtonId).click();
        return element;
    }

    public WebElement ParanL() {
        element.findElement(paranLButtonId).click();
        return element;
    }

    public WebElement ParanR() {
        element.findElement(paranRButtonId).click();
        return element;
    }

    public WebElement PressOnNumber(int number) {
        element.findElement(By.id("Btn" + number)).click();
        return element;
    }

    public WebElement OpenHistory() {
        if (!element.findElement(historyId).isDisplayed())
            element.findElement(openHistoryButtonClass).click();

        SetupTest.wait.until(ExpectedConditions.visibilityOf(element.findElement(historyId)));

        return element;
    }

    public WebElement SendEquationAndCalculate(String equation)
    {
        SendEquation(equation);
        Calculate();
        OpenHistory();
        SetupTest.wait.until(ExpectedConditions.textToBePresentInElementLocated(historyId,equation));
        return element;
    }
    public HistoryElement GetHistory() {
        return new HistoryElement(element.findElement(historyId));
    }

    public String GetResult() {
        OpenHistory();
        return GetHistory().GetResults().elements().nextElement();
    }
}
