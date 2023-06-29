package PageObject;

import org.openqa.selenium.By;

public class AllDesktopsAndMP3PlayersPage {

    public By desktops = By.xpath("//a[@class = 'dropdown-toggle' and text() = 'Desktops']");
    public By showAllDesktops = By.xpath("//a[text() = 'Show AllDesktops']");
    public By mp3PlayersItem = By.xpath("//a[@class = 'list-group-item' and contains(text(),'MP3 Players')]");
    public By ipodTouchImage = By.xpath("//img[@title = 'iPod Touch']");
    public By ipodTouchTooltip = By.xpath("//img[@title = 'iPod Touch']");
    public By ipodTouch = By.xpath("//a[text() = 'iPod Touch']");
}
