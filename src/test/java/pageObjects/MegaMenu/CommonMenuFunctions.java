package pageObjects.MegaMenu;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrokenLinkChecker;

import java.net.URL;
import java.util.List;

public class CommonMenuFunctions {

    private WebDriver driver;
    private WebDriverWait wait;
    Logger logger = LogManager.getLogger(CommonMenuFunctions.class);

    @FindBy(xpath = "//ul[@class = 'sdl-header-se_mm-l1-list js-header-section-list open']")
    private List<WebElement> verifyLinkExpanded;


    public CommonMenuFunctions() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CommonMenuFunctions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean checkBrokenLink(List<WebElement> elementLinkList) {

        for (WebElement el : elementLinkList) {
            try {
                logger.log(Level.INFO, "Checking Link :: " + el.getText());
                BrokenLinkChecker.isLinkBroken(new URL(el.getAttribute("href")));
            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.INFO, "Missing Link :: " + el.getText());
                return false;
            }
        }
        return true;
    }

    public boolean checkThatMenuisExpanded() {

        if (verifyLinkExpanded.size() == 1) return true;
        else return false;
    }

    public boolean checkThatMenuisNotExpanded() {

        if (verifyLinkExpanded.size() == 0) return true;
        else return false;
    }

    public void OpentheLinkinMEnu(WebElement el, String text) {
        if (el.getAttribute("text").contains(text))
            driver.get(el.getAttribute("href"));
    }

    public String openSubMenuWithElement(List<WebElement> elementList, String subMenu) {
        for (WebElement el : elementList) {
            if (el.getAttribute("innerHTML").contains(subMenu)) {
                return el.getAttribute("href");
            }
        }
        return null;
    }


    public void openSubMenu(String subMenu) {
    }
}
