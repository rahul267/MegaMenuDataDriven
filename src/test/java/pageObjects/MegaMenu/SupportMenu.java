package pageObjects.MegaMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SupportMenu {
    private WebDriver driver;

    public SupportMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
