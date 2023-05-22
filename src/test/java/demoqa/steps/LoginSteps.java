package demoqa.steps;

import demoqa.model.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    @After
    public void cleanUp() {
        loginPage.cleanUp();
    }

    @Given("A user is on book store login page")
    public void navigateToHome() {
        System.out.println(this.getClass().getName() + " navigateToHome");
        loginPage.NavigateHome();
    }


    @When("User enters {string} and {string} and submits")
    public void setLoginInput(String username, String password) {
        System.out.println(this.getClass().getName() + " setLoginInput");
       // enterLoginCredentials(datatable);
        loginPage.enterLoginCredentials(username, password);
        loginPage.clickLoginBtn();
    }


    public void enterLoginCredentials(DataTable datatable) {
        String username = datatable.cell(1, 0);
        String password = datatable.cell(1, 1);
        loginPage.enterLoginCredentials(username, password);
    }

    @When("User does not populate {string} and submits")
    public void setInvalidLoginInput(String credential, DataTable datatable) {
        System.out.println(this.getClass().getName() + " setInvalidLoginInput");
        enterLoginCredentials(datatable);
        loginPage.clickLoginBtn();
    }

    @Then("User successfully logs in")
    public void loginSuccess() {
        System.out.println(this.getClass().getName() + " loginSuccess");
        Assert.assertTrue(loginPage.isLoginSuccess());

    }



    @And("{string} is displayed")
    public void verifyLoginUser(String username) {
        System.out.println(this.getClass().getName() + " verifyLoginUser");
        //String username = datatable.cell(1, 0);
        Assert.assertEquals(username, loginPage.getUsername());
    }


    @Then("Input error for username is displayed")
    public void displayUsernameEmptyError() {
        System.out.println(this.getClass().getName() + " displayUsernameEmptyError");
        Assert.assertTrue(loginPage.isUsernameError());
    }

    @Then("Input error for password is displayed")
    public void displayPasswordEmptyError() {
        System.out.println(this.getClass().getName() + " displayPasswordEmptyError");
        Assert.assertTrue(loginPage.isPasswordError());
    }

    @And("User logs out")
    public void userLogsOut() {
        System.out.println(this.getClass().getName() + " userLogsOut");
        loginPage.logout();
    }




}
