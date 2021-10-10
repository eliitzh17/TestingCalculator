package steps;
import static org.junit.Assert.*;

import io.cucumber.java.After;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import pages.HomePage;

import java.util.Dictionary;

public class CalculatorSteps {

    private HomePage homePage;

    public CalculatorSteps(){homePage = new HomePage();}

    @BeforeClass
    public static void Init(){
        SetupTest.Setup();
    }

    @After
    public void TearDown()  {
        homePage.getCalculator().Clear();
    }

    @When("User send equation {string}")
    public void SendEquation(String equation) {
        homePage.getCalculator().SendEquationAndCalculate(equation);
    }
    @When("User press on a number {int}")
    public void PresNumber(int number)
    {
        homePage.getCalculator().PressOnNumber(number);
    }

    @When("User press on a sign {string}")
    public void PressSign(String sign)
    {
        switch (sign)
        {
            case "(":
            {
                homePage.getCalculator().ParanL();
                break;
            }
            case ")":
            {
                homePage.getCalculator().ParanR();
                break;
            }
        }
    }

    //@When("User press on action (PLUS|MINUS|MULTIPLE|DIV|CALCULATE)")
    @When("User press on action {string}}")
    public void MakeAnAction(String action)
    {
        switch (action)
        {
            case "PLUS":
            {
                homePage.getCalculator().Plus();
                break;
            }
            case "MINUS":
            {
                homePage.getCalculator().Minus();
                break;
            }
            case "MULTIPLE":
            {
                homePage.getCalculator().Multiple();
                break;
            }
            case "DIV":
            {
                homePage.getCalculator().Div();
                break;
            }
            case "CALCULATE":
            {
                homePage.getCalculator().Calculate();
                break;
            }
        }
    }

    @Then("Results should be {double}")
    public void ResultsShouldBe(double result) {
        assertEquals(result,Double.parseDouble(homePage.getCalculator().GetResult()), 0);
    }

    @Then("Results shouldn't be {double}")
    public void ResultsShouldnotBe(double result) {
        assertNotEquals(result,Double.parseDouble(homePage.getCalculator().GetResult()));
    }

    @Then("Validate equation history:")
    public void ValidateHistory(DataTable table)
    {
        Dictionary<String, String> results = homePage.getCalculator().GetHistory().GetResults();

        for (int i = 1; i < table.asLists().size(); i++) {
            String record = results.get(table.row(i).get(0));
            assertNotNull(record);
            assertEquals(record, table.row(i).get(1));
        }
    }
}