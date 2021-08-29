package StepDefinitions;

import Pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.text.ParseException;
import java.util.Map;

public class CreateFlightSteps {

    MainPage mainPage = new MainPage();

    @Given("Acess Ryanair page")
    public void acessRyanaisPage() {
        mainPage.navigateToRyanaisPage();
        mainPage.agreeWithCookies();
    }

    @And("Search a flight if the filters")
    public void searchAFlightIfTheFilters(DataTable data) throws ParseException {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        mainPage.fillDepartureFilter(dataMap.get("Departure"));
        mainPage.fillDestinationFilter(dataMap.get("Destination"));
        mainPage.selectDepartureDate(dataMap.get("Departure Date"));
        mainPage.selectReturnDate(dataMap.get("Return Date"));
        mainPage.selectPassangers(dataMap.get("Adults"),"Adults");
        mainPage.selectPassangers(dataMap.get("Children"),"Children");
    }
}
