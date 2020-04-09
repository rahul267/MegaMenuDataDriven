package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkChecker {

    public static List findAllLinks(WebDriver driver) {
        List<WebElement> elementList = new ArrayList();
        elementList = driver.findElements(By.tagName("a"));
        elementList.addAll(driver.findElements(By.tagName("img")));
        List finalList = new ArrayList();
        for (WebElement element : elementList) {
            if (element.getAttribute("href") != null) finalList.add(element);
        }
        return finalList;
    }


    public static String isLinkBroken(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            return response;
        } catch (Exception exp) {
            return exp.getMessage();
        }


    }
}
