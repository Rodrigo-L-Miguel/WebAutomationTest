package StepDefinitions;

import Pages.FlightPage;
import Pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CreateFlightSteps {
    WebDriver driver = null;
    MainPage mainPage;
    FlightPage flightPage;

    public String departure = null;
    public String destination = null;
    public String adults = null;
    public String child = null;

    @Given("Acess Ryanair page")
    public void acessRyanairPage() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);

        mainPage.navigateToRyanairPage();
        mainPage.agreeWithCookies();
    }

    @And("Search a flight if the filters")
    public void searchAFlightIfTheFilters(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);
        mainPage = new MainPage(driver);

        mainPage.fillDepartureFilter(dataMap.get("Departure"));
        departure = dataMap.get("Departure");
        mainPage.fillDestinationFilter(dataMap.get("Destination"));
        destination = dataMap.get("Destination");
        mainPage.selectDepartureDate(dataMap.get("Departure Date"));
        mainPage.selectReturnDate(dataMap.get("Return Date"));
        mainPage.incrementPassangers(dataMap.get("Adults"), "Adults");
        mainPage.incrementPassangers(dataMap.get("Children"), "Children");
        mainPage.clickOnSearch();
    }

    @When("I change the dates to")
    public void iChangeTheDatesTo(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);
        flightPage = new FlightPage(driver);

        flightPage.selectNewDepartureDate(dataMap.get("Departure Date"));
        flightPage.selectDepartureFlight(destination);
        flightPage.selectNewReturnDate((dataMap.get("Return Date")));
        flightPage.selectDepartureFlight(departure);
    }

    @And("I inform the passagers names")
    public void iInformThePassagersNames(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);

        flightPage.fillPassengerInfo(dataMap);
        flightPage.clickInContinue();
    }

    @And("Select the payment method")
    public void selectThePaymentMethod() {
        flightPage.selectThePayment();
        flightPage.clickOnOptionLoginLater();
    }

    @And("Select the same seats for de flights")
    public void selectTheSameSeatsForDeFlights(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);
        SeatsPage.selectSeat(dataMap.get("Passenger 1"));
    }
}
