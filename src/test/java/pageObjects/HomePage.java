package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.MegaMenu.CommonMenuFunctions;

public class HomePage {

    private WebDriver driver;
    private static Logger logger = LogManager.getLogger(HomePage.class.getName());

        public HomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void open(String url) {

            driver.get(url);
            logger.info("Opening Home Page of Schnider ");
        }
    }




