package BrowserConfiguration;

import com.codeborne.selenide.Configuration;


public class BaseTest {

    public void initialize(){

        Configuration.timeout = 5000;
        Configuration.startMaximized = true;
        Configuration.savePageSource = false;
        Configuration.headless = true;
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "http://tutorialsninja.com/demo/";
    }
}
