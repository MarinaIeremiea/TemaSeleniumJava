package com.endava.tema.test;

import com.endava.tema.main.*;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by mieremiea on 8/1/2016.
 */
public class SearchItemsTest extends TestBaseClass{

    @Test
    public void searchItems(){

        //Click on "Ingrijire corp" tab
        IngrijireCorpPage ingrijireCorpPage = homepage.clickIngrijireCorpTab();


        //Verify how many products are in the selected category.
        Integer totalNumberOfItems = ingrijireCorpPage.getNumberOfItems();
        System.out.println("Number of items on the page: " + totalNumberOfItems);
        assertTrue(totalNumberOfItems > 0);


        // Filter by the highest price
        ingrijireCorpPage.sortByClick();
        ingrijireCorpPage.sortByHighestPrice();

        //Print the name and price for the first value returned. UPDATE: If there is no price, print ‘unspecified price’ message.
        String a = ingrijireCorpPage.getNameOfTheMostExpensiveItem();
        System.out.println("Price of the most expensive item: "+ ingrijireCorpPage.getPriceOfTheMostExpensiveItem());
        System.out.println("Name of the most expensive item: " + a);

        //Verify the product selected is the desired one.
        ItemPage itemPage = ingrijireCorpPage.clickOnTheMostExpensiveItem();
        String b = itemPage.getNameOfTheItem();
        assertEquals(a,b);

        //Click on the “Inapoi Inrijire Corp” link (top left)
        itemPage.clickInapoiIngrijireCorp();

        //Once redirected to “Ingrijire Corp” page click on ‘NOUTATI’ link.
        NoutatiPage noutatiPage = ingrijireCorpPage.clickOnNoutati();

        //Print the number of the new products (can be used asserts too)
        Integer c = noutatiPage.getTotalNumberOfItems();
        System.out.println("Number of items from NOUTATI:" + c);
        assertTrue( c >= 0 );

        //Click on the 2nd product and then click on "Adauga in cos" button (before clicking verify the button is displayed).
        noutatiPage.clickOnSecondItem();
        itemPage.clickAddToBasket();

        //Check that the shopping cart (upper right of the page) is automatically updated with the new item added.
        System.out.println("Is the basket updated automatically: " + itemPage.isBasketAutomaticallyUpdated());
        assertTrue(itemPage.isBasketAutomaticallyUpdated());

        //After the shopping basket icon is clicked, go to the products section and increase the quantity of the selected item to be  3.
        ItemsOnBasketPage itemsOnBasketPage = itemPage.clickOnBasket();
        itemsOnBasketPage.clickIncreaseNumberOfItems(2);

        //Verify the total price and print the number of earned points.
        System.out.println("Price of item: " + itemsOnBasketPage.getPrice());
        System.out.println("Total price: " + itemsOnBasketPage.getTotalPrice());
        assertEquals(itemsOnBasketPage.calculateTotalPrice(3), itemsOnBasketPage.getTotalPrice());
        System.out.println("Number of bonus points earned: " + itemsOnBasketPage.bonusPointsEarned());


        //Bonus
        //Click on "Pentru EL" tab
        PentruElPage pentruElPage = homepage.clickPentruElPage();

        //In the left side of the page - click on "Ceasuri" - under the Accesorii category
        pentruElPage.clickAccessorii();
        pentruElPage.clickWatches();

        //Go to the last item returned and print the name and the number of stars displayed.
        System.out.println("Name of the last watch:" + pentruElPage.getNameOfTheLastWatch());
        System.out.println("Number of stars:" + pentruElPage.getNumberOfStars());

        //Click on the last item.
        pentruElPage.clickOnLastItem();


        //In the order page, verify the email share icon is displayed (under INFORMATII LIVRARE section).
        //Click on the email icon to share.(verify the URL for the new page )
        ShareEmailPage shareEmailPage = pentruElPage.clickShareEmailButton();
        assertEquals("http://ro.oriflame.com/products/product?code=27386", shareEmailPage.getUrl());

    }
}
