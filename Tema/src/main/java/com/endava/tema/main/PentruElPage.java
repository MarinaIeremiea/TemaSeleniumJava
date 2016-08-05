package com.endava.tema.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mieremiea on 8/4/2016.
 */
public class PentruElPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//div//nav//div//ul//li//a[@href='/men/accessories']")
    private WebElement accessoriiButton;

    @FindBy(xpath = "//div//ul[2]//li//ul//a[@href='/men/accessories/watches']")
    private WebElement watchesButton;

    @FindBy(xpath = "//div//section//section//a[last()]")
    private WebElement lastWatch;

    @FindBy(xpath = "//div//section//section//a[last()]//div[2]//span[@class='name']")
    private WebElement nameLastWatch;

    @FindBy(xpath = "//div//section//section//a[last()]//div[2]//span[@class='stars']")
    private WebElement numberOfStars;

    @FindBy(xpath = "//div//a[@title='Email']")
    private WebElement emailShareButton;

    public PentruElPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }


    public void waitForPage() {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(accessoriiButton));
    }

    public void clickAccessorii() {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(accessoriiButton));

        WebElement element = webDriver.findElement(By.xpath("//div//nav//div//ul//li//a[@href='/men/accessories']"));
        Actions actions = new Actions(webDriver);

        actions.moveToElement(element);
        actions.click();
        actions.perform();

    }

    public void clickWatches() {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(watchesButton));

        Actions actions = new Actions(webDriver);
        actions.moveToElement(watchesButton).click().perform();
    }

    public String getNameOfTheLastWatch() {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(lastWatch));

        return nameLastWatch.getText();
    }

    public String getNumberOfStars() {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(lastWatch));

        return numberOfStars.getText();
    }

    public void clickOnLastItem() {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(lastWatch));

        lastWatch.click();
    }

    public ShareEmailPage clickShareEmailButton() {


        if (emailShareButton.isDisplayed()) {
            emailShareButton.click();
        } else {
            System.out.println("The button for email share is not displayed!");
        }

        ShareEmailPage shareEmailPage = PageFactory.initElements(webDriver, ShareEmailPage.class);
        return shareEmailPage;
    }
}

