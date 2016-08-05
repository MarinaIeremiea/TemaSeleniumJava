package com.endava.tema.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mieremiea on 8/1/2016.
 */
public class IngrijireCorpPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement totalNumberOfItemsField;

    @FindBy(xpath = "//span[@class='k-input']")
    private WebElement sortClickField;

    @FindBy(xpath = "//li[contains(text(),'Preț – Cel mai mare la Cel mai mic')]")
    private WebElement sortByHighestPriceField;

    @FindBy(xpath = "//section//section//a[1]")
    private WebElement mostExpensiveItemOnIngrijireCorpPage;

    @FindBy(xpath = "//section//section//a[1]//div[2]//div[1]//span[1]")
    private WebElement highestPrice;

    @FindBy(xpath = "//section//section//a[1]//div[2]//span[@class='name']")
    private WebElement nameOfTheMostExpensiveItem;

    @FindBy(xpath = "//a[@href='/bath-body/new']")
    private  WebElement noutatiButton;


    public IngrijireCorpPage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    public Integer getNumberOfItems(){

        String totalNumbersOfItems = totalNumberOfItemsField.getText();
        return Integer.parseInt(totalNumbersOfItems);
    }

    public void sortByClick(){

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sortClickField));

        sortClickField.click();
    }

    public void sortByHighestPrice(){

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sortByHighestPriceField));

        sortByHighestPriceField.click();
    }

    public String getPriceOfTheMostExpensiveItem(){

        if (highestPrice.getText() == null) {
            System.out.println("Unspecified price");
        } else {
             highestPrice.getText();
        }

        return highestPrice.getText();
    }

    public String getNameOfTheMostExpensiveItem(){

        return nameOfTheMostExpensiveItem.getText();
    }

    public ItemPage clickOnTheMostExpensiveItem(){

        mostExpensiveItemOnIngrijireCorpPage.click();

        ItemPage itemPage = PageFactory.initElements(webDriver, ItemPage.class);
        return itemPage;
    }

    public NoutatiPage clickOnNoutati(){

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(noutatiButton));

        noutatiButton.click();

        NoutatiPage noutatiPage = PageFactory.initElements(webDriver, NoutatiPage.class);
        return noutatiPage;
    }


    public void waitForPage(){

        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.textToBePresentInElement(sortByHighestPriceField, ""));

    }








}
