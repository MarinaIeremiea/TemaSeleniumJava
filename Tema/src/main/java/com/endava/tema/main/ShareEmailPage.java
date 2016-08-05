package com.endava.tema.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mieremiea on 8/5/2016.
 */
public class ShareEmailPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//div//span[@class='at-expanded-menu-page-url']")
    private WebElement urlToShareField;

    public ShareEmailPage(WebDriver webDriver){

        this.webDriver = webDriver;
    }

    public String getUrl(){

        webDriver.get("https://www.addthis.com/tellfriend_v2.php?v=300&winname=addthis&pub=ra-518911b443df2509&source=men-300&lng=ro-RO&s=email&url=http%3A%2F%2Fro.oriflame.com%2Fproducts%2Fproduct%3Fcode%3D27386&title=Ceas%20pentru%20el%20Elegant%20Business&ate=AT-ra-518911b443df2509/-/-/57a4719068c3116b/3&ct=0&ui_email_to=&ui_email_from=&ui_email_note=&pre=http%3A%2F%2Fro.oriflame.com%2Fmen%2Faccessories%2Fwatches&tt=0&captcha_provider=recaptcha2&pro=0&ats=url%3Dhttp%253A%252F%252Fro.oriflame.com%252Fproducts%252Fproduct%253Fcode%253D27386%26title%3DCeas%2520pentru%2520el%2520Elegant%2520Business%26templates%3Dtwitter%253D%25257B%25257Burl%25257D%25257D%26imp_url%3D0%26smd%3Drsi%253D%2526gen%253D0%2526rsc%253D%2526dr%253Dhttp%25253A%25252F%25252Fro.oriflame.com%25252Fmen%25252Faccessories%25252Fwatches%2526sta%253DAT-ra-518911b443df2509%25252F-%25252F-%25252F57a4719068c3116b%25252F1%26hideEmailSharingConfirmation%3Dundefined%26service%3Demail%26media%3Dundefined%26description%3Dundefined%26passthrough%3Dundefined%26email_template%3Dundefined%26email_vars%3Dundefined&atc=data_track_addressbar%3Dfalse%26data_track_clickback%3Dfalse%26ui_use_css%3Dtrue%26username%3Dra-518911b443df2509%26product%3Dundefined%26pubid%3Dra-518911b443df2509%26ui_pane%3Demail&rb=false");

        return urlToShareField.getText();
    }


}
