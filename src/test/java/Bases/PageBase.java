package Bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageBase {
    protected WebDriver driver = null;

    public PageBase(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }
}
