package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeatsPage {
    WebDriver driver;
    public SeatsPage(WebDriver driver){
        this.driver = driver;
    }

    By seat6A = By.id("seat-06A");
    By seat6B = By.id("seat-06B");
    By seat6C = By.id("seat-06C");

    By nextFlightButton = By.xpath("//button[text()=' Next flight ']");
    By continueButton = By.xpath("//button[text()=' Continue ']");
    By noThanksButton = By.xpath("//button[text()=' No, thanks ']");
    By smallBagOption = By.id("ry-radio-button--0");
    By continueSelectBags = By.xpath("//bags-continue-flow//button");
    By continueParking = By.cssSelector(".app-container__cta[_ngcontent-ryanair-flightextras-c243]");


    public void selectSeat(String passenger) {

        if(passenger=="06A"){
            driver.findElement(seat6A).click();
        }
        if(passenger=="06C"){
            driver.findElement(seat6C).click();
        }
        if(passenger=="06B"){
            driver.findElement(seat6B).click();
        }
    }

    public void clickOnNextFlight(){
        driver.findElement(nextFlightButton).click();
    }

    public void clickInContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickInNoThanks() {
        driver.findElement(noThanksButton).click();
    }

    public void selectSmallBagOnly() {
        driver.findElement(smallBagOption).click();
    }

    public void clickOnContinueInTransports() {
        driver.findElement(continueParking);
    }
}
