package com.endava.tema.test;

import com.endava.tema.main.HomePage;
import com.endava.tema.main.ItemsOnBasketPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mieremiea on 8/1/2016.
 */
public class TestBaseClass {

    private static WebDriver webDriver;
    protected HomePage homepage;
    protected ItemsOnBasketPage itemsOnBasketPage;

    @BeforeClass
    public static void setUp(){

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://ro.oriflame.com/");
    }

    @Before
    public void initTema(){

        homepage = PageFactory.initElements(webDriver, HomePage.class);
        itemsOnBasketPage = PageFactory.initElements(webDriver, ItemsOnBasketPage.class);
        homepage.clickCloseCookiesNotification();
    }

    @AfterClass
    public static void tearDown(){

        webDriver.close();

    }

}
