package Steps;

import PageObject.CheckoutPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutSteps {

    CheckoutPage checkoutObj = new CheckoutPage();

    @Step("converting string to float")
    public Float StringToFloat(String toBeConverted) {
        for (int i = 0; i < toBeConverted.length(); i++) {
            if (toBeConverted.charAt(i) == '$') {
                toBeConverted = toBeConverted.substring(i + 1);
                break;
            }
        }
        return Float.parseFloat(toBeConverted);
    }

    @Step("Entering the name of user")
    public CheckoutSteps EnterFirstName(String firstName) {
        $(checkoutObj.paymentFirstName).sendKeys(firstName);
        return this;
    }

    @Step("Entering the last name of user")
    public CheckoutSteps EnterLastName(String lastName) {
        $(checkoutObj.paymentLastName).sendKeys(lastName);
        return this;
    }

    @Step("Entering address of user")
    public CheckoutSteps EnterAddress(String address) {
        $(checkoutObj.paymentAddress).sendKeys(address);
        return this;
    }

    @Step("Entering city of user")
    public CheckoutSteps EnterCity(String city) {
        $(checkoutObj.paymentCity).sendKeys(city);
        return this;
    }

    @Step("Entering postcode of user")
    public CheckoutSteps EnterPostCode(String postCode) {
        $(checkoutObj.paymentPostCode).sendKeys(postCode);
        return this;
    }

    @Step("Choosing country of user")
    public CheckoutSteps ChooseCountry(String country) {
        $(checkoutObj.paymentCountry).click();
        $(checkoutObj.paymentCountry).selectOptionContainingText(country);
        return this;
    }

    @Step("Choosing state of the country")
    public CheckoutSteps ChooseState(String state) {
        $(checkoutObj.paymentRegion).click();
        $(checkoutObj.paymentRegion).selectOptionContainingText(state);
        return this;
    }

    @Step("Clicking continue button in Billing Details")
    public CheckoutSteps ClickBillingDetailsContinue() {
        $(checkoutObj.billingDetailsContinue).click();
        return this;
    }

    @Step("Clicking continue in Delivery Details")
    public CheckoutSteps ClickDeliveryDetailsContinue() {
        $(checkoutObj.deliveryDetailsContinue).click();
        return this;
    }

    @Step("Clicking continue in Delivery Method")
    public CheckoutSteps ClickDeliveryMethodContinue() {
        $(checkoutObj.deliveryMethodContinue).click();
        return this;
    }

    @Step("Getting flat shipping rate price from delivery methods")
    public Float GetFlatShippingRate() {
        $(checkoutObj.flatRatePriceDeliveryMethods).shouldBe(visible);
        return StringToFloat($(checkoutObj.flatRatePriceDeliveryMethods).getText());
    }

    @Step("Clicking agree terms & conditions in Payment Method")
    public CheckoutSteps ClickAgreeTermsAndConditions() {
        $(checkoutObj.agreeTermsAndConditions).click();
        return this;
    }

    @Step("Clicking continue in Payment Method")
    public CheckoutSteps ClickPaymentMethodContinue() {
        $(checkoutObj.paymentMethodContinue).click();
        return this;
    }

    @Step("Checking sub total price in Confirm Method")
    public CheckoutSteps CheckSubTotal() {
        $(checkoutObj.subTotal).shouldBe(visible);
        Assert.assertEquals($(checkoutObj.subTotal).getText(), "$100.00");
        System.out.println("Sub total : $100.0");
        return this;
    }

    @Step("Checking flat shipping rate price in Confirm Method")
    public CheckoutSteps CheckFlatShippingRate(Float actual) {
        Float expected = StringToFloat($(checkoutObj.flatShippingRate).getText());
        Assert.assertEquals(actual, expected);
        System.out.println("Flat shipping rate : $" + actual);
        return this;
    }

    @Step("Checking total price in Confirm Method")
    public CheckoutSteps CheckTotal() {

        // expected = flat shipping rate + subtotal
        Float expected = StringToFloat($(checkoutObj.flatShippingRate).getText()) + StringToFloat($(checkoutObj.subTotal).getText());
        Float actual = StringToFloat($(checkoutObj.total).getText());
        Assert.assertEquals(actual, expected);
        System.out.println("Total Price : $" + actual);
        return this;
    }

}
