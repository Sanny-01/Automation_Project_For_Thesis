package PageObject;

import org.openqa.selenium.By;

public class LaptopsAndNotebooksPage {

    public By laptopsAndNotebooks = By.xpath("//a[text() = 'Laptops & Notebooks']");
    public By showAllLaptopsAndNotebooks = By.xpath("//a[text()= 'Show AllLaptops & Notebooks']");
    public By sortBy =  By.id("input-sort");
    public By sortByPriceHighToLow = By.xpath("//option[text()='Price (High > Low)']");
    public By laptopPrices = By.xpath("//div[@class = 'row'][4]");



}
