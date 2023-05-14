package demoqa.steps;

import demoqa.model.pages.ProfilePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProfileSteps {
    private ProfilePage profilePage = new ProfilePage();

    @After
    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        profilePage.cleanUp();
    }

    @Given("A user is on book store page")
    public void openBookStoreLoginPage() {
        System.out.println(this.getClass().getName() + " openBookStoreLoginPage");
        profilePage.NavigateHome();
    }

    @And("User clicks profile from side nav")
    public void clickProfileFromSideNav() {
        System.out.println(this.getClass().getName() + " clickProfileFromSideNav");
        profilePage.clickProfileSideNav();
    }

    @Then("Profile page is displayed")
    public void displayProfilePage() {
        System.out.println(this.getClass().getName() + " displayProfilePage");
        Assert.assertTrue(profilePage.verifyProfilePage());

    }


}
