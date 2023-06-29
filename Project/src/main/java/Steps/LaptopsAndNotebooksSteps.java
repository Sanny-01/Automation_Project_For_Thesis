package Steps;

import PageObject.LaptopsAndNotebooksPage;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Ordering;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Character.isDigit;

public class LaptopsAndNotebooksSteps {

    LaptopsAndNotebooksPage laptopsObj = new LaptopsAndNotebooksPage();

    @Step("Hovering on 'Laptops & Notebooks' button")
    public LaptopsAndNotebooksSteps MoveToLaptopsAndNotebooks() {
        $(laptopsObj.laptopsAndNotebooks).hover();
        return this;
    }

    @Step("Clicking 'Show All Laptops & Notebooks' option")
    public LaptopsAndNotebooksSteps ClickShowAllLaptopsAndNotebooks() {
        $(laptopsObj.showAllLaptopsAndNotebooks).click();
        return this;
    }

    @Step("Choosing to sort by 'Price (High > Low)'")
    public LaptopsAndNotebooksSteps SortByHighToLow() {
        $(laptopsObj.sortBy).click();
        $(laptopsObj.sortByPriceHighToLow).click();
        return this;
    }

    @Step("Checking that laptop prices were sorted correctly")
    public LaptopsAndNotebooksSteps CheckPricesOfLaptopsToBeSorted() {

        List<SelenideElement> prices = $(laptopsObj.laptopPrices).findAll("p.price");
        List<Float> pricesFloatList = new ArrayList<Float>();

        // temporary array for converting string to float
        String temp = "";
        for (int i = 0; i < prices.size(); i++) {

            String text = prices.get(i).getText();

            // removing $ sign from text for example $100.00 -> 100.00
            text = text.substring(1);
            temp = "";

            for (int j = 0; j < text.length(); j++) {

                // if char is digit or '.' enter it in our array
                if ((isDigit(text.charAt(j)) || (text.charAt(j) == '.'))) {
                    temp += text.charAt(j);

                    // for example if string is like this 2,000.00 it should not stop at char ',' that's why there's this statement
                } else if (text.charAt(j) != ',')
                    break;
            }
            pricesFloatList.add(Float.parseFloat(temp));
        }
        boolean sorted = Ordering.natural().reverse().isOrdered(pricesFloatList);
        Assert.assertTrue(sorted, "Prices are not sorted!");
        System.out.println("Sorted prices are : " + pricesFloatList);
        return this;
    }
}
