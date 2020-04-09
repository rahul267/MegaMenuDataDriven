package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    private WebDriver driver ;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Given("^I go to schnider$")
    public void iGoToSchnider() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new HomePage(driver).open("www.schnider.com");
    }
}
