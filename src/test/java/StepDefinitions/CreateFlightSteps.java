package StepDefinitions;

import Pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.text.ParseException;
import java.util.Map;

public class CreateFlightSteps {

    MainPage mainPage = new MainPage();

    FlightPage flightPage = new FlightPage();

    @Given("Acess Ryanair page")
    public void acessRyanaisPage() {
        mainPage.navigateToRyanaisPage();
        mainPage.agreeWithCookies();
    }

    @And("Search a flight if the filters")
    public void searchAFlightIfTheFilters(DataTable data)  {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        mainPage.fillDepartureFilter(dataMap.get("Departure"));
        mainPage.fillDestinationFilter(dataMap.get("Destination"));
        mainPage.selectDepartureDate(dataMap.get("Departure Date"));
        mainPage.selectReturnDate(dataMap.get("Return Date"));
        mainPage.incrementPassangers(dataMap.get("Adults"),"Adults");
        mainPage.incrementPassangers(dataMap.get("Children"),"Children");
        mainPage.clickOnSearch();
    }

    @When("I change the dates to")
    public void iChangeTheDatesTo(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        flightPage.selectDepartureDate(dataMap.get("Departure Date"));
        flightPage.selectReturnDate(dataMap.get("Return Date"));
    }
}
