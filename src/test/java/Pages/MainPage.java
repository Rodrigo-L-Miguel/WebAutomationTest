package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    By agreeWithCookiesButtonLocator = By.className("cookie-popup-with-overlay__button");
    By departureFieldLocator = By.id("input-button__departure");
    By destinationFieldLocator = By.id("input-button__destination");
    By departureDateField = By.xpath("//fsw-input-button[@uniqueid='dates-from']");
    By returnDateField = By.xpath("//fsw-input-button[@uniqueid='dates-to']");
    By monthScrollMenu = By.xpath("//div[contains(@class,'m-toggle__month')]");
    By dayCalendar = By.xpath("//div[@class='calendar-body__cell']");
    By passengersField = By.xpath("//fsw-input-button[@uniqueid='passengers']");
    By passengersCounter = By.xpath("//fsw-passengers-picker/ry-counter");
    By passengerType = By.xpath(".//div[@class='passengers-picker__counter-main-label']");
    By passengerCounterValue = By.xpath(".//div[@class='counter__value']");
    By passengerCounterIncrement = By.xpath(".//div[@data-ref='counter.counter__increment']");
    By searchButton = By.cssSelector(".flight-search-widget__start-search[_ngcontent-ryanair-homepage-c62]");


    public By locationOptionLocator(String location) {
        return By.xpath("//span[contains(text(),'" + location + "')]");
    }

    public void navigateToRyanairPage() {
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

    public void selectDepartureDate(String departureDate)  {

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
        List<WebElement> daysField = driver.findElements(dayCalendar);
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
        List<WebElement> daysField = driver.findElements(dayCalendar);
        for (WebElement day : daysField) {
            if (day.getText().equals(dateString[0])) {
                day.click();
                break;
            }
        }
    }

    public void incrementPassangers(String quantity, String type) {
        int desiredAmount = Integer.parseInt(quantity);
        driver.findElement(passengersField).click();
        List<WebElement> counters = driver.findElements(passengersCounter);

        for (WebElement counter : counters) {
            if (type.equals(counter.findElement(passengerType).getText())) {
                int amountPage = Integer.parseInt(counter.findElement(passengerCounterValue).getText());
                while (desiredAmount > amountPage) {
                    counter.findElement(passengerCounterIncrement).click();

                    amountPage = Integer.parseInt(counter.findElement(passengerCounterValue).getText());
                }
            }
        }

    }

    public void clickOnSearch() {
        driver.findElement(searchButton).click();
    }
}
