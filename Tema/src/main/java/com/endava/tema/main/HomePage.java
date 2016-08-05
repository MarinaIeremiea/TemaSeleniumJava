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
public class HomePage {
    @FindBy(xpath = "//body//div//button[@class='k-button']")
    private WebElement closeCookiesNotification;

    @FindBy(xpath = "//a[@data-category='bath-body']")
    private WebElement ingrijireCorp;

    @FindBy(xpath = "//li//a[@data-category='men']")
    private WebElement pentruElButton;

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    public void clickCloseCookiesNotification(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(closeCookiesNotification));
        closeCookiesNotification.click();
    }

    public IngrijireCorpPage clickIngrijireCorpTab(){

        ingrijireCorp.click();

        IngrijireCorpPage ingrijireCorpPage = PageFactory.initElements(webDriver, IngrijireCorpPage.class);
        ingrijireCorpPage.waitForPage();

        return ingrijireCorpPage;
    }

    public PentruElPage clickPentruElPage(){

        pentruElButton.click();

        PentruElPage pentruElPage = PageFactory.initElements(webDriver, PentruElPage.class);
        pentruElPage.waitForPage();

        return pentruElPage;
    }




}
