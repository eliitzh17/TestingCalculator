package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetupTest {
    public static String HomePagePath = "https://web2.0calc.com/";
    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeAll
    public static void Setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver,10);
        }
        driver.manage().window().maximize();
        driver.get(HomePagePath);
    }

    @AfterAll
    public static void TearDown()
    {
        driver.close();
    }
}
