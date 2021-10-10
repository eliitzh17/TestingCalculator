package elemnets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class HistoryElement extends BaseElement{
    private By clearHistoryButtonId = By.id("input");
    private By historyRecordTag = By.tagName("li");
    private By resultsTag = By.tagName("p");

    public HistoryElement(WebElement element) {
        super(element);
    }

    public void ClearHistory()
    {
        element.findElement(clearHistoryButtonId).click();
    }

    public Dictionary<String, String> GetResults(){
        Dictionary<String, String> results = new Hashtable<>();

        for (WebElement we : element.findElements(historyRecordTag)) {
            List<WebElement> resultsElement= we.findElements(resultsTag);
            results.put(resultsElement.get(1).getText(), resultsElement.get(0).getText().replaceAll("[^\\d.]", ""));
        }
        return results;
    }
}
