package pageObjects.MegaMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ServicesMenu {

    private WebDriver driver;

    public ServicesMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
