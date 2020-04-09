package testsInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.MegaMenu.MainMenu;
import pageObjects.SearchBar;
import java.util.concurrent.TimeUnit;

public class MegaMenuTest {

    WebDriver driver;
    private String loaclUrl = "https://www.se.com/ww/en/" ;

    @BeforeMethod()
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000,
            dataProvider = "testData", dataProviderClass = DataProviderClass.class,enabled = true)
    public void verifyLoginUsingCsv (String url)
    {
        new HomePage(driver).open(url);
        new MainMenu(driver).openProductMenu() ;
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviderClass.class,enabled = false)
    public void verifyBrokenLink (String url)
    {
        new HomePage(driver).open(url);
        Assert.assertTrue( new MainMenu(driver)
                .openProductMenu()
                .checkBrokenLink());
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviderClass.class,enabled = true)
    public void verifyLinkToggling (String url)
    {
        new HomePage(driver).open(url);
        Assert.assertFalse(new MainMenu(driver).openProductMenu().checkThatMenuisExpanded()) ;
        Assert.assertTrue(new MainMenu(driver).openProductMenu().checkThatMenuisNotExpanded()) ;
    }

    @Test(dataProvider = "searchData", dataProviderClass = DataProviderClass.class,enabled = true)
    public void searchText(String url,String text)
    {
        new HomePage(driver).open(url);
        new SearchBar(driver).searchText(text);
        Assert.assertTrue(driver.getTitle().contains("Search"));
    }

    @Test(dataProvider = "menuItems", dataProviderClass = DataProviderClass.class,enabled = true)
    public void OpenMenuItem(String menu , String subMenu , String title)
    {
        new HomePage(driver).open(loaclUrl);
        new MainMenu(driver).openMenu(menu).openSubMenu(subMenu) ;
        Assert.assertTrue(driver.getTitle().contains(title));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
