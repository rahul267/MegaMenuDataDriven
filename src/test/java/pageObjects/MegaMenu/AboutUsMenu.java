package pageObjects.MegaMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutUsMenu {
    private WebDriver driver;

    public AboutUsMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
