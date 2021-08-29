package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import javax.swing.*;
import java.util.List;
import java.util.Map;

public class FlightPage {
    WebDriver driver;

    public FlightPage(WebDriver driver) {
        this.driver = driver;
    }

    By scrollDepartureDateBar = By.xpath("//ul[@class='container ng-tns-c128-9 ng-trigger ng-trigger-listSlide']/li");
    By scrollReturnDateBar = By.xpath("//ul[@class='container ng-tns-c128-12 ng-trigger ng-trigger-listSlide']/li");
    By dayField = By.xpath(".//span[contains(@class,'date-item__day-of-month')]");
    By monthField = By.xpath(".//span[contains(@class,'date-item__month')]");
    By nextDatesButton = By.xpath("//button[@data-e2e='carousel-next']");
    By originFlightField = By.xpath("//span[contains(@data-ref,'origin-airport')]");
    By fareCardButton = By.cssSelector(".fare-card__button[_ngcontent-tlp-c290]");
    By loginLaterButton = By.cssSelector(".expanded[_nghost-tlp-c231] .login-touchpoint__login-later[_ngcontent-tlp-c231]");
    By titlePassenger1ComboBox = By.xpath("//pax-passenger/div[@data-ref='pax-details__ADT-0']");
    By continueButton=By.xpath("//continue-flow/div/div/span/button");

    public By titleComboOption(String title) {
        return By.xpath("//div[text()='" + title + "']");
    }

    By namePassenger1Field = By.id("form.passengers.ADT-0.name");
    By lastNamePassenger1Field = By.id("form.passengers.ADT-0.surname");
    By titlePassenger2ComboBox = By.xpath("//pax-passenger/div[@data-ref='pax-details__ADT-1']");
    By namePassenger2Field = By.id("form.passengers.ADT-1.name");
    By lastNamePassenger2Field = By.id("form.passengers.ADT-1.surname");
    By namePassenger3Field = By.id("form.passengers.CHD-0.name");
    By lastNamePassenger3Field = By.id("form.passengers.CHD-0.surname");


    public void selectNewDepartureDate(String departureDate) {
        //todo if is required use of past dates from the inicial ones, need improvement for the code identify them
        String[] dateString = departureDate.split(" ");
        boolean val = false;

        while (!val) {
            List<WebElement> dateFields = driver.findElements(scrollDepartureDateBar);
            for (WebElement field : dateFields) {
                String month = field.findElement(monthField).getText();
                String day = field.findElement(dayField).getText();
                if (dateString[0].equals(day)) {
                    if (dateString[1].equals(month)) {
                        field.click();
                        val = true;
                        return;
                    }
                }
            }
            driver.findElement(nextDatesButton).click();
        }

    }

    public void selectNewReturnDate(String departureDate) {
        //todo if is required use of past dates from the inicial ones, need improvement for the code identify them
        String[] dateString = departureDate.split(" ");
        boolean val = false;

        while (!val) {
            List<WebElement> dateFields = driver.findElements(scrollReturnDateBar);
            for (WebElement field : dateFields) {
                String month = field.findElement(monthField).getText();
                String day = field.findElement(dayField).getText();
                if (dateString[0].equals(day)) {
                    if (dateString[1].equals(month)) {
                        field.click();
                        val = true;
                        return;
                    }
                }
            }
            driver.findElement(nextDatesButton).click();
        }

    }

    public void selectDepartureFlight(String origin) {
        List<WebElement> flightOrigin = driver.findElements(originFlightField);

        for (WebElement flight : flightOrigin) {
            if (origin.equals(flight.getText())) {
                new Actions(driver).moveToElement(flight).perform();
                flight.click();
                break;
            }
        }
    }

    public void selectThePayment() {
        driver.findElement(fareCardButton).click();
    }

    public void clickOnOptionLoginLater() {
        driver.findElement(loginLaterButton).click();
    }

    public void fillPassengerInfo(Map<String, String> dataMap) {
        String[] passenger1 = dataMap.get("Passenger 1").split(" ");
        String[] passenger2 = dataMap.get("Passenger 2").split(" ");
        String[] passenger3 = dataMap.get("Passenger 3").split(" ");


        driver.findElement(titlePassenger1ComboBox).click();
        driver.findElement(titleComboOption(passenger1[0]));
        driver.findElement(namePassenger1Field).sendKeys(passenger1[1]);
        driver.findElement(lastNamePassenger1Field).sendKeys(passenger1[2]);

        driver.findElement(titlePassenger2ComboBox).click();
        driver.findElement(titleComboOption(passenger2[0]));
        driver.findElement(namePassenger2Field).sendKeys(passenger2[1]);
        driver.findElement(lastNamePassenger2Field).sendKeys(passenger2[2]);

        driver.findElement(namePassenger3Field).sendKeys(passenger3[0]);
        driver.findElement(lastNamePassenger3Field).sendKeys(passenger3[1]);

    }

    public void clickInContinue() {
        driver.findElement(continueButton).click();
    }
}
