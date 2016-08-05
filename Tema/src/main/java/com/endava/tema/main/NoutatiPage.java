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
public class NoutatiPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//span[@class='total-count']")
    private WebElement totalNumberItemsInNoutatiField;

    @FindBy(xpath = "//div/div/section/section/a[2]")
    private WebElement secondItemOnNoutatiPageField;

    public NoutatiPage(WebDriver webDriver){

        this.webDriver = webDriver;
    }


    public Integer getTotalNumberOfItems(){

       WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
       webDriverWait.until(ExpectedConditions.visibilityOf(totalNumberItemsInNoutatiField));

        String totalNumberOfItems = totalNumberItemsInNoutatiField.getText();
        return Integer.parseInt(totalNumberOfItems);
    }

    public void clickOnSecondItem(){

        secondItemOnNoutatiPageField.click();
    }

}
