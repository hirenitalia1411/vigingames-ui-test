package com.virgingames.pages;

import com.virgingames.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegistrationPage.class.getName());

// ======================= Page  Initialisation ==================================
    public RegistrationPage() {
        PageFactory.initElements(driver, this);

    }

// ======================= Elements Locator ==================================

    @CacheLookup
    @FindBy(linkText = "Your Details")
    WebElement registrationFormTitle;

// ======================= Action on Elements ==================================

    public String getRegistrationFormTitle() {
        log.info("Getting registration form title : " + registrationFormTitle.toString());
        return getTextFromElement(registrationFormTitle);
    }

}