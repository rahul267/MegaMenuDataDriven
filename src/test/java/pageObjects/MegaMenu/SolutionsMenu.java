package pageObjects.MegaMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SolutionsMenu extends CommonMenuFunctions {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'sdl-header-se_mm-main-list-wrap']//a")
    private List<WebElement> solutionsMenuAllLink;

    public SolutionsMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSubMenu(String subMenu) {

        super.openSubMenuWithElement(solutionsMenuAllLink, subMenu);
    }
}
