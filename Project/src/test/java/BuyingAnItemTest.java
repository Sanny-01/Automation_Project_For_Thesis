import BrowserConfiguration.BaseTest;
import Steps.*;
import UserData.UserData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BuyingAnItemTest extends BaseTest {

    private HomeAndRegisterSteps _register = new HomeAndRegisterSteps();
//    private DatabaseInsertAndRetrieve _insert = new DatabaseInsertAndRetrieve();
//    private DatabaseConnection _connection = new DatabaseConnection();
    private LaptopsAndNotebooksSteps _laptops = new LaptopsAndNotebooksSteps();
    private AllDesktopsAndMP3PlayersSteps _desktopsAndMP3 = new AllDesktopsAndMP3PlayersSteps();
    private IpodTouchSteps _ipodTouchSteps = new IpodTouchSteps();
    private CheckoutSteps _checkout = new CheckoutSteps();
    static int methodExecutionCount = 0;

    private UserData userData = new UserData();

    // attaching screenshots to allure report
    @BeforeClass(alwaysRun = true)
    public void setupAllureReportsAndSetData() {
        userData.setUserCredentials();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @Epic("Epic 1")
    @Feature("Feature 1")
    @Story("Story 1")
    @Story("Combined Feature 1 Story")
    @Description("Going to register page and registering a new user")
    @Test(groups = {"Regression 1"}, priority = 1)
    public void RegisterUser() {

        initialize();

        open(Configuration.baseUrl);

        // going to register page
        _register
                .ClickMyAccount()
                .ClickRegister()
                .EnterFirstName(userData.firstName)
                .EnterLastName(userData.lastName)
                .EnterEmail(userData.email)
                .EnterPhone(userData.phone)
                .EnterPassword(userData.password)
                .EnterConfirmPassword(userData.password)
                .ClickSubscribeYes()
                .ClickAgreePrivacyPolicy()
                .ClickContinue();
    }

    @Epic("Epic 1")
    @Feature("Feature 1")
    @Story("Story 2")
    @Story("Combined Feature 1 Story")
    @Description("Showing all desktops, sorting and then checking that sorting worked correctly")
    @Test(groups = {"Regression 1"}, priority = 2)
    public void AllDesktops() {

        _laptops
                .MoveToLaptopsAndNotebooks()
                .ClickShowAllLaptopsAndNotebooks()
                .SortByHighToLow()
                .CheckPricesOfLaptopsToBeSorted();
    }

    @Epic("Epic 1")
    @Feature("Feature 2")
    @Story("Story 1")
    @Story("Combined Feature 2 Story")
    @Description("Selecting all MP3 players and buying one of them")
    @Test(dependsOnMethods = {"RegisterUser"}, groups = {"Regression 2"}, priority = 3)
    public void MP3Players() {

        _desktopsAndMP3
                .MoveToDesktops()
                .SelectShowAllDesktops()
                .ChooseMP3Players()
                .MoveToIpodTouchImg()
                .CheckIpodTouchTextVisibility()
                .ClickIpodTouchLink();

        _ipodTouchSteps
                .AddToCart()
                .CheckItemsCountAndPrice();
    }

    @Epic("Epic 1")
    @Feature("Feature 2")
    @Story("Story 2")
    @Story("Combined Feature 2 Story")
    @Description("Filling address and other necessary information to purchase a product")
    @Test(dependsOnMethods = {"MP3Players"}, priority = 4, groups = {"Regression 2"}, retryAnalyzer = RetryAnalyzer.Retry.class)
    public void BuyingProduct() {

        Float flatShippingRate;
        methodExecutionCount++;

        _ipodTouchSteps
                .ClickCart()
                .ClickCheckout();

        // if the method is executed for the first time enter an address
        if (methodExecutionCount == 1) {
            _checkout
                    .EnterFirstName(userData.firstName)
                    .EnterLastName(userData.lastName)
                    .EnterAddress(userData.address)
                    .EnterCity(userData.city)
                    .EnterPostCode(userData.zip)
                    .ChooseCountry(userData.country)
                    .ChooseState(userData.state)
                    .ClickBillingDetailsContinue();
        }
        // if test execution count does not equal 4, fail on purpose
        if (methodExecutionCount < 2) {
            _checkout
                    .CheckTotal();
        }
        // if it is 4th time continue in delivery details with existing address
        if (methodExecutionCount == 2) {
            _checkout
                    .ClickBillingDetailsContinue()
                    .ClickDeliveryDetailsContinue();

        }

        // saving flat shipping rate cost in variable
        flatShippingRate = _checkout.GetFlatShippingRate();

        // Leaving some details default and checking that amounts are correct in confirm order
        _checkout
                .ClickDeliveryMethodContinue()
                .ClickAgreeTermsAndConditions()
                .ClickPaymentMethodContinue()
                .CheckSubTotal()
                .CheckFlatShippingRate(flatShippingRate)
                .CheckTotal();

        // closing connection
        // _connection.closeConnection();
    }
}
