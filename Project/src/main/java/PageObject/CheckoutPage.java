package PageObject;

import org.openqa.selenium.By;

public class CheckoutPage {

    public By paymentFirstName = By.id("input-payment-firstname");
    public By paymentLastName = By.id("input-payment-lastname");
    public By paymentAddress = By.id("input-payment-address-1");
    public By paymentCity = By.id("input-payment-city");
    public By paymentPostCode = By.id("input-payment-postcode");
    public By paymentCountry = By.id("input-payment-country");
    public By paymentRegion = By.id("input-payment-zone");
    public By billingDetailsContinue = By.id("button-payment-address");
    public By deliveryDetailsContinue = By.id("button-shipping-address");
    public By flatRatePriceDeliveryMethods = By.xpath("//input[@name = 'shipping_method']/ancestor::label");
    public By deliveryMethodContinue = By.id("button-shipping-method");
    public By agreeTermsAndConditions = By.xpath("//input[@name = 'agree' and @value = '1']");
    public By paymentMethodContinue = By.id("button-payment-method");
    public By subTotal = By.xpath("//strong[text() = 'Sub-Total:']/following::td[1]");
    public By flatShippingRate = By.xpath("//strong[text() = 'Flat Shipping Rate:']/following::td[1]");
    public By total = By.xpath("//strong[text() = 'Total:']/following::td[1]");
}
