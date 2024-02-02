package com.virgingames.pages;

import com.virgingames.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

// ======================= Page  Initialisation ==================================

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

// ======================= Elements Locator ==================================

    @CacheLookup
    @FindBy(css= "label[for='privacy_pref_optin']")
    WebElement acceptCookies;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='StyledNavigationMenuList-sc-v46bks-1 ctndtu nav-bar']//li")
    List<WebElement> headers;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='Virgin Games']")
    WebElement virginGamesLogo;

    @CacheLookup
    @FindBy(linkText = "Join Now")
    WebElement joinNowButton;

// ======================= Action on Elements ==================================

    public String verifyCurrentPageUrl() {
        log.info("Verifying redirected page URL");
        return driver.getCurrentUrl();
    }

    public void clickAcceptCookies() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", acceptCookies);
        log.info("Clicking accept cookies: " + acceptCookies.toString());
    }

    public void clickOnAllHeaders(String tab) {
        for (WebElement menu : headers) {
            if (menu.getText().contentEquals(tab)) {
                clickOnElement(menu);
                log.info("Clicking on header "+ tab +" : " + headers.toString());
                break;
            }
        }
    }

    public boolean verifyVirginGamesLogo(){
        log.info("Verifying Virgin Games Logo : " + virginGamesLogo.toString());
        return verifyThatElementIsDisplayed(virginGamesLogo);
    }

    public void clickOnJoinNowButton() {
        waitUntilVisibilityOfElementLocated(joinNowButton, 10);
        clickOnElement(joinNowButton);
        log.info("Clicking join now button : " + joinNowButton.toString());
    }
}