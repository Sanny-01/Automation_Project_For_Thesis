package Steps;

import PageObject.AllDesktopsAndMP3PlayersPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class AllDesktopsAndMP3PlayersSteps {

    AllDesktopsAndMP3PlayersPage DesktopAndMP3Obj = new AllDesktopsAndMP3PlayersPage();

    @Step("Hovering on 'Desktops' button")
    public AllDesktopsAndMP3PlayersSteps MoveToDesktops() {
        $(DesktopAndMP3Obj.desktops).hover();
        return this;
    }

    @Step("Selecting 'Show All Desktops' in options")
    public AllDesktopsAndMP3PlayersSteps SelectShowAllDesktops() {
        $(DesktopAndMP3Obj.showAllDesktops).click();
        return this;
    }

    @Step("Choosing 'MP3 Players'")
    public AllDesktopsAndMP3PlayersSteps ChooseMP3Players() {
        $(DesktopAndMP3Obj.mp3PlayersItem).click();
        return this;
    }

    @Step("Hovering on iPod Touch image")
    public AllDesktopsAndMP3PlayersSteps MoveToIpodTouchImg() {
        $(DesktopAndMP3Obj.ipodTouchImage).hover();
        return this;
    }

    @Step("Checking the visibility of iPod Touch tooltip")
    public AllDesktopsAndMP3PlayersSteps CheckIpodTouchTextVisibility() {

        String check = $(DesktopAndMP3Obj.ipodTouchTooltip).getAttribute("title");
        String actual = $(DesktopAndMP3Obj.ipodTouch).getText();
        Assert.assertEquals(actual, check);
        return this;
    }

    @Step("Clicking on iPod Touch")
    public AllDesktopsAndMP3PlayersSteps ClickIpodTouchLink() {
        $(DesktopAndMP3Obj.ipodTouch).click();
        return this;
    }
}
