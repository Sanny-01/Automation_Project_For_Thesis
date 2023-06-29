package PageObject;

import org.openqa.selenium.By;

public class IpodTouchPage {

    public By addToCart = By.id("button-cart");
    public By itemPrice = By.xpath("//h2[starts-with(text(),'$')]");
    public By itemsCountAndPrice = By.id("cart-total");
    public By cart = By.id("cart");
    public By checkout = By.xpath("//strong[text() = 'Checkout']");
}
