package com.endava.tema.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mieremiea on 8/3/2016.
 */
public class ItemsOnBasketPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//span[@title='Increase value']")
    private WebElement increaseNumberOfProducts;

    @FindBy(xpath = "//ul//span[@class='price']//span")
    private WebElement getPrice;

    @FindBy(xpath = "//div//span//span[@class='value']")
    private WebElement getTotalPrice;

    @FindBy(xpath = "//div//span//span[@class='total-bp']")
    private WebElement bonusPoints;

    public ItemsOnBasketPage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    public void clickIncreaseNumberOfItems(int numberOfTimes){

        for(int i=0; i < numberOfTimes ;i++) {
            increaseNumberOfProducts.click();
            if(i<1) {
                System.out.println("Produsul a fost adaugat o data.");
            }else{
                System.out.println("Produsul a fost adaugat de " + (i+1) + " ori.");
            }
        }
    }

    public void waitForPageBasket(){

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(increaseNumberOfProducts));
    }
    public Double stringToDouble(String s){

        s = s.replace(",",".");
        String[] s1 = s.split(" ");

        return Double.parseDouble(s1[0]);
    }

    public Double getPrice(){

        String itemPriceLEI = getPrice.getText();
        Double itemPrice = stringToDouble(itemPriceLEI);

        return itemPrice;
    }


    public Double getTotalPrice() {

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getTotalPrice));

        String totalPrice1= getTotalPrice.getText();
        Double totalPrice3 = stringToDouble(totalPrice1);

        return totalPrice3;
    }

    public Double calculateTotalPrice(int numberOfProducts){

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getPrice));

        Double a = stringToDouble(getPrice.getText());
        return a * numberOfProducts;
    }

    public Double bonusPointsEarned(){

        Double a = stringToDouble(bonusPoints.getText());
        return a;
    }
}
