package testsInTestNG;

import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderClass {

    @DataProvider(name = "testData")
    public Iterator<Object[]> testData() throws IOException
    {
        return new DataProviderClass().parseCsvData("Data/test.csv");
    }

    @DataProvider(name = "searchData")
    public Iterator<Object[]> searchData() throws IOException
    {
        return new DataProviderClass().parseCsvData("Data/urls.csv");
    }

    @DataProvider(name = "menuItems")
    public Iterator<Object[]> menuItems() throws IOException
    {
        return new DataProviderClass().parseCsvData("Data/MenuAndSubMenu.csv");
    }

    public   Iterator<Object[]> parseCsvData(String fileName) throws IOException
    {
        BufferedReader input = null;
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        input = new BufferedReader(new FileReader(file));
        String line = null;
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        while ((line = input.readLine()) != null)
        {
            String in = line.trim();
            String[] temp = in.split(",");
            List<Object> arrray = new ArrayList<Object>();
            for(String s : temp)
            {
                arrray.add(s);
            }
            data.add(arrray.toArray());
        }
        input.close();
        return data.iterator();
    }
}
