package pageObjects.MegaMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainMenu extends CommonMenuFunctions {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class = 'sdl-header-se_mm-l1-list js-header-section-list'][1]")
    private WebElement productsLink;

    @FindBy(xpath = "//ul[@class = 'sdl-header-se_mm-l1-list js-header-section-list'][2]")
    private WebElement solutionsLink;

    @FindBy(xpath = "//ul[@class = 'sdl-header-se_mm-l1-list js-header-section-list'][3]")
    private WebElement servicesLink;

    @FindBy(xpath = "//ul[@class = 'sdl-header-se_mm-l1-list js-header-section-list'][1]")
    private WebElement supportLink;

    @FindBy(xpath = "//ul[@class = 'sdl-header-se_mm-l1-list js-header-section-list'][1]")
    private WebElement aboutUsLink;


    public MainMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsMenu openProductMenu() {
        if (productsLink.isDisplayed()) productsLink.click();
        return new ProductsMenu(driver);
    }

    public ServicesMenu openServicesMenu() {
        servicesLink.click();
        return new ServicesMenu(driver);
    }


    public SolutionsMenu openSolutionsMenu() {
        solutionsLink.click();
        return new SolutionsMenu(driver);
    }


    public SupportMenu openSupportMenu() {
        supportLink.click();
        return new SupportMenu(driver);
    }

    public AboutUsMenu openAboutUsMenu() {
        aboutUsLink.click();
        return new AboutUsMenu(driver);
    }


    public CommonMenuFunctions openMenu(String menu) {
        switch (menu) {
            case "PRODUCT":
                return openProductMenu();

            case "SOLUTIONS":
                return openSolutionsMenu();
        }
        return openProductMenu();
    }


}
