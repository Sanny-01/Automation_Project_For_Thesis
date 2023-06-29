package PageObject;

import org.openqa.selenium.By;

public class HomeAndRegisterPage {

    public By myAccount = By.xpath("//a[@title = 'My Account' or @class = 'dropdown-toggle']");
    public By register = By.xpath("//a[text() = 'Register']");
    public By inputFirstName = By.id("input-firstname");
    public By inputLastName = By.id("input-lastname");
    public By inputEmail = By.id("input-email");
    public By inputTelephone = By.id("input-telephone");
    public By inputPassword = By.id("input-password");
    public By inputConfirmPassword = By.id("input-confirm");
    public By subscriptionOptionYes = By.xpath("//input[@name = 'newsletter'][@value = '1']");
    public By privacyPolicyAgree = By.xpath("//input[@name = 'agree']");
    public By submitRegistration = By.xpath("//input[@type = 'submit' and @value= 'Continue']");
}
