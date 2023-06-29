package Steps;

import PageObject.IpodTouchPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class IpodTouchSteps {

    IpodTouchPage ipodTouchObj = new IpodTouchPage();

    @Step("Clicking 'Add to Cart'")
    public IpodTouchSteps AddToCart() {
        $(ipodTouchObj.addToCart).click();
        return this;
    }

    @Step("Separating item count amount from price")
    public String SeparateItemsCountFromPrice(String productAmount) {
        for (int i = 0; i < productAmount.length(); i++) {
            if (productAmount.charAt(i) == ' ') {
                productAmount = productAmount.substring(0, i);
                break;
            }
        }
        return productAmount;
    }

    @Step("Separating price from items count")
    public String SeparatePriceFromItemsCount(String price) {
        for (int i = 0; i < price.length(); i++) {
            if (price.charAt(i) == '$') {
                price = price.substring(i);
                break;
            }
        }
        return price;
    }

    @Step("Checking that ipod was added successfully")
    public IpodTouchSteps CheckItemsCountAndPrice() {

        // after adding item to cart this part of code acts as a wait until add to cart text is visible again
        $(ipodTouchObj.addToCart).shouldHave(exactText("Add to Cart"));

        String actualCount = SeparateItemsCountFromPrice($(ipodTouchObj.itemsCountAndPrice).getText());
        String actualPrice = SeparatePriceFromItemsCount($(ipodTouchObj.itemsCountAndPrice).getText());

        String expectedCount = "1";
        String expectedPrice = $(ipodTouchObj.itemPrice).getText();

        Assert.assertEquals(actualCount, expectedCount);
        Assert.assertEquals(actualPrice, expectedPrice);

        System.out.println("Product was added successfully!");
        System.out.println("Product's amount : " + actualCount);
        System.out.println("Product's price : " + actualPrice);

//        this part could have also been written more easily like this
//        $(ipodTouchObj.itemsCountAndPrice).shouldNotHave(Condition.exactText(" 0 item(s) - $0.00"));
        return this;
    }

    @Step("Clicking cart")
    public IpodTouchSteps ClickCart() {
        $(ipodTouchObj.cart).click();
        return this;
    }

    @Step("Clicking 'Checkout")
    public IpodTouchSteps ClickCheckout() {
        $(ipodTouchObj.checkout).click();
        return this;
    }

}
