package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger(SearchBar.class.getName());
    @FindBy(xpath = "//input[@type = 'search'][1]")
    private WebElement productsLink;

    @FindBy(xpath = "//button[@type = 'reset'][1]")
    private WebElement resetButton;

    @FindBy(xpath = "//button[@type = 'submit'][1]")
    private WebElement submitButton;


    public SearchBar(WebDriver driver)
    {
      this.driver = driver ;
        PageFactory.initElements(driver, this);
        logger.info(" On the Search bar");
    }

    public void searchText(String text)
    {
        productsLink.click();
        logger.info(" Searching for text : "+text);
        productsLink.sendKeys(text);
        submitButton.click();
    }

    public void clearText()
    {
        productsLink.click();
        productsLink.sendKeys("a");
        resetButton.click();
    }

}

