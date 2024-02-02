package com.virgingames.steps;

import com.virgingames.pages.HomePage;
import com.virgingames.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageSteps {

    @Given("I am on homepage")
    public void iAmOnHomepage() {
        Assert.assertEquals(new HomePage().verifyCurrentPageUrl(), "https://www.virgingames.com/", "Home page URL is not valid");
    }

    @When("I click on accept cookies")
    public void iClickOnAcceptCookies() {
        new HomePage().clickAcceptCookies();
    }

    @Then("I should see Virgin Games logo on homepage")
    public void iShouldSeeVirginGamesLogoOnHomepage() {
        Assert.assertTrue(new HomePage().verifyVirginGamesLogo());
    }

    @And("I click on {string}")
    public void iClickOn(String headers) {
        new HomePage().clickOnAllHeaders(headers);
    }

    @Then("I verify the redirected pages {string}")
    public void iVerifyTheRedirectedPages(String urlLink) {
        Assert.assertEquals(new HomePage().verifyCurrentPageUrl(), urlLink);
    }

    @When("I click on Join Now")
    public void iClickOnJoinNow() {
        new HomePage().clickOnJoinNowButton();
    }

    @Then("I should redirect to register page")
    public void iShouldRedirectToRegisterPage() {
        new HomePage().verifyCurrentPageUrl();
    }

    @And("I should see the text {string}")
    public void iShouldSeeTheText(String registrationFormTitle) {
        Assert.assertEquals(new RegistrationPage().getRegistrationFormTitle(), registrationFormTitle, "Registration form title is not verified");
    }
}
