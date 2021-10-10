package elemnets;

import org.openqa.selenium.WebElement;

public class BaseElement {

    public WebElement element;

    public BaseElement(){}
    public BaseElement (WebElement element)
    {
        this.element = element;
    }
}
