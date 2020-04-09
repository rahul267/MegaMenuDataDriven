package pageObjects.MegaMenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsMenu extends CommonMenuFunctions {

    private WebDriver driver;
    private static Logger logger = LogManager.getLogger(ProductsMenu.class);

    @FindBy(xpath = "//div[@class = 'sdl-header-se_mm-main-list-wrap']//a")
    private List<WebElement> productsMenuAllLink;


    public ProductsMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("We are on Product Menu");
    }

    public boolean checkBrokenLink() {
        logger.info("Checking All Broken Links");
        return super.checkBrokenLink(productsMenuAllLink);

    }


    public void openSubMenu(String subMenu) {

        if (super.openSubMenuWithElement(productsMenuAllLink, subMenu) != null)
            driver.get(super.openSubMenuWithElement(productsMenuAllLink, subMenu));
    }
}
