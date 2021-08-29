package Pages;

import Bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainPage extends PageBase {

    By agreeWithCookiesButtonLocator = By.className("cookie-popup-with-overlay__button");
    By departureFieldLocator = By.id("input-button__departure");
    By destinationFieldLocator = By.id("input-button__destination");
    By departureDateField = By.xpath("//fsw-input-button[@uniqueid='dates-from']");
    By returnDateField = By.xpath("//fsw-input-button[@uniqueid='dates-to']");
    By monthScrollMenu = By.xpath("//div[contains(@class,'m-toggle__month')]");
    By dayScrollMenu = By.xpath("//div[@class='calendar-body__cell']");
    By passengersField = By.xpath("//fsw-input-button[@uniqueid='passengers']");
    By passengersCounter = By.xpath("//ry-counter[@data-ref='passengers-picker']");

    public By locationOptionLocator(String location) {
        return By.xpath("//span[contains(text(),'" + location + "')]");
    }

    public void navigateToRyanaisPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ryanair.com/gb/en");
    }

    public void agreeWithCookies() {
        driver.findElement(agreeWithCookiesButtonLocator).click();
    }

    public void fillDepartureFilter(String departure) {
        WebElement departureField = driver.findElement(departureFieldLocator);

        departureField.click();
        departureField.clear();
        departureField.sendKeys(departure);

        driver.findElement(locationOptionLocator(departure)).click();
    }

    public void fillDestinationFilter(String destination) {
        WebElement destinationField = driver.findElement(destinationFieldLocator);

        destinationField.click();
        destinationField.clear();
        destinationField.sendKeys(destination);

        driver.findElement(locationOptionLocator(destination)).click();
    }

    public void selectDepartureDate(String departureDate) throws ParseException {

        driver.findElement(departureDateField).click();//click on the field of departure date to open de calendar


        //Splits the informed date on day,month,year
        String[] dateString = departureDate.split(" ");

        //This part can be used in case the input format may differ of the website

        //Date monthDate = new SimpleDateFormat("MM", Locale.ENGLISH).parse(dateString[1]);
        //String monthString = new SimpleDateFormat("MMM", Locale.ENGLISH).format(monthDate);


        //Select the month in the scrollable menu
        List<WebElement> monthsField = driver.findElements(monthScrollMenu);
        for (WebElement month : monthsField) {
            if (month.getText().equals(dateString[1])) {
                month.click();
                break;
            }
        }
        //Select the day on the month
        List<WebElement> daysField = driver.findElements(dayScrollMenu);
        for (WebElement day : daysField) {
            if (day.getText().equals(dateString[0])) {
                day.click();
                break;
            }
        }




    }

    public void selectReturnDate(String returnDate) {
        driver.findElement(returnDateField).click();

        //Splits the informed date on day,month,year
        String[] dateString = returnDate.split(" ");

        //Select the month in the scrollable menu
        List<WebElement> monthsField = driver.findElements(monthScrollMenu);
        for (WebElement month : monthsField) {
            if (month.getText().equals(dateString[1])) {
                month.click();
                break;
            }
        }

        //Select the day on the month
        List<WebElement> daysField = driver.findElements(dayScrollMenu);
        for (WebElement day : daysField) {
            if (day.getText().equals(dateString[0])) {
                day.click();
                break;
            }
        }
    }

    public void selectPassangers(String amount,String type) {
        driver.findElement(passengersField).click();
        List<WebElement> counters = driver.findElements(passengersCounter);

        for(WebElement counter : counters){
            if()
        }

    }
}
