package com.endava.tema.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mieremiea on 8/2/2016.
 */
public class ItemPage{
    private WebDriver webDriver;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement nameOfTheItemOnIngrijireCorpPage;

    @FindBy(xpath = "//span[@class='v-icon-side-menu-arrow-left']")
    private WebElement inapoiIngrijireCorpButton;

    @FindBy(xpath = "//button[@id='addToBasketButton']")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//span[@class='basket-items']")
    private WebElement updatedBasketButton;

    @FindBy(xpath = "//span[@class='v-icon-mini-bag']")
    private  WebElement basketButton;

    public ItemPage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    public String getNameOfTheItem(){

        return nameOfTheItemOnIngrijireCorpPage.getText();
    }

    public void clickInapoiIngrijireCorp(){

        inapoiIngrijireCorpButton.click();
    }

    public void clickAddToBasket(){

        if(addToBasketButton.isDisplayed()) {
            addToBasketButton.click();
        }else{
            System.out.println("The button is not displayed!");
        }
    }

    public boolean isBasketAutomaticallyUpdated(){

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(updatedBasketButton));

        Integer updatedItemsInBasket = Integer.parseInt(updatedBasketButton.getText());

        if(updatedItemsInBasket == 1){
            return true;
        }else{
            return false;
        }
    }

    public ItemsOnBasketPage clickOnBasket(){

        basketButton.click();

        ItemsOnBasketPage itemsOnBasketPage = PageFactory.initElements(webDriver, ItemsOnBasketPage.class);
        itemsOnBasketPage.waitForPageBasket();

        return itemsOnBasketPage;
    }






}
