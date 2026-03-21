package org.thetestingacademy.Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.thetestingacademy.Base.BaseTest;
import org.thetestingacademy.Factory.DriverFactory;
import org.thetestingacademy.utils.WaitHelper;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheapMacMini extends BaseTest {

    By productListLocator = By.cssSelector(".RGLWAk");


    @Test
    public void cheapMacMiniTest() {

        WaitHelper waitHelper = new WaitHelper(DriverFactory.getTLDriver());
        driver.get("https://www.flipkart.com/search?q=macmini&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
        List<WebElement> productList = waitHelper.waitForVisibilityOfAllElements(productListLocator, Duration.ofSeconds(15));
        HashMap<String, Integer> productPriceMap = new HashMap<>();
        int cheapPrice = Integer.MAX_VALUE;
        String cheapProduct = "";
        int cnt = 0;
        try {
            for (WebElement element : productList) {
                List<WebElement> nameElement = element.findElements(By.cssSelector("a[title]"));
                List<WebElement> priceElement = element.findElements(By.cssSelector(".hZ3P6w"));

                //If no element found list returns empty value where as driver.findElement throws no such element exception
                if (nameElement.isEmpty() || priceElement.isEmpty())
                    continue;

                String pname = nameElement.get(0).getText();

                String p = priceElement.get(0).getText();
                int price = Integer.parseInt(p.replaceAll("[^0-9]", ""));

                productPriceMap.put(pname, price);

                if (price < cheapPrice) {
                    cheapPrice = price;
                    cheapProduct = pname;
                }


                cnt++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Map.Entry<String, Integer> pmap : productPriceMap.entrySet()) {
            System.out.println(pmap.getKey());
            System.out.println(pmap.getValue());
        }
        System.out.println("Product count: " + cnt);
        System.out.println("Cheap Product: " + cheapProduct);
        System.out.println("Product Price: " + cheapPrice);
    }
}
