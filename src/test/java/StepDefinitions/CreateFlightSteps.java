package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CreateFlightSteps {

    MainPage mainPage = new MainPage();

    @Given("Acess Ryanair page")
    public void acessRyanaisPage() {
        mainPage.navigateToRyanaisPage();
        mainPage.agreeWithCookies();
    }

    @And("Search a flight if the filters")
    public void searchAFlightIfTheFilters() {
    }
}
