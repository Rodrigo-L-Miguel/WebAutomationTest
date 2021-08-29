package Pages;

import Bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainPage extends PageBase{

    By agreeWithCookiesButton = By.className("cookie-popup-with-overlay__button");
    By departureField = By.id("input-button__departure");
    By departureLisbonOption = By.xpath("//span[@data-id='LIS']");

    By destinationField = By.id("input-button__destination");


    public void navigateToRyanaisPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ryanair.com/gb/en");
    }

    public void agreeWithCookies() {
        driver.findElement(agreeWithCookiesButton).click();
    }
}
