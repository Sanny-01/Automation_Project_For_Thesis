package Steps;

import PageObject.HomeAndRegisterPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomeAndRegisterSteps {

    HomeAndRegisterPage registerObject = new HomeAndRegisterPage();

    @Step("Clicking 'My Account'")
    public HomeAndRegisterSteps ClickMyAccount() {
        $(registerObject.myAccount).click();
        return this;
    }

    @Step("Choosing register option")
    public HomeAndRegisterSteps ClickRegister() {
        $(registerObject.register).click();
        return this;
    }

    @Step("Entering the first name")
    public HomeAndRegisterSteps EnterFirstName(String firstName) {
        $(registerObject.inputFirstName).sendKeys(firstName);
        return this;
    }

    @Step("Entering the lastname")
    public HomeAndRegisterSteps EnterLastName(String lastName) {
        $(registerObject.inputLastName).sendKeys(lastName);
        return this;
    }

    @Step("Entering the email")
    public HomeAndRegisterSteps EnterEmail(String email) {
        $(registerObject.inputEmail).sendKeys(email);
        return this;
    }

    @Step("Entering the phone number")
    public HomeAndRegisterSteps EnterPhone(String phone) {
        $(registerObject.inputTelephone).sendKeys(phone);
        return this;
    }

    @Step("Entering the password")
    public HomeAndRegisterSteps EnterPassword(String password) {
        $(registerObject.inputPassword).sendKeys(password);
        return this;
    }

    @Step("Confirming the password by entering it second time")
    public HomeAndRegisterSteps EnterConfirmPassword(String password) {
        $(registerObject.inputConfirmPassword).sendKeys(password);
        return this;
    }

    @Step("Clicking yes option in subscribe options")
    public HomeAndRegisterSteps ClickSubscribeYes() {
        $(registerObject.subscriptionOptionYes).click();
        return this;
    }

    @Step("Clicking agree in privacy policy")
    public HomeAndRegisterSteps ClickAgreePrivacyPolicy() {
        $(registerObject.privacyPolicyAgree).click();
        return this;
    }

    @Step("Clicking continue")
    public HomeAndRegisterSteps ClickContinue() {
        $(registerObject.submitRegistration).click();
        return this;
    }
}
