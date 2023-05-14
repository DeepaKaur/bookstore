package demoqa.steps;

import demoqa.model.pages.BookStorePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BookstoreSteps {
    private BookStorePage bookStorePage = new BookStorePage();

    @After
    public void cleanUp() {
        bookStorePage.cleanUp();
    }

    @Given("A user navigates to book store website")
    public void navigateToBookStore() {
        System.out.println(this.getClass().getName() + " navigateToBookStore");
        bookStorePage.navigateBookStorePage();
    }

    @When("User clicks {string} link from table")
    public void clickBookNameLink(String bookName) {
        System.out.println(this.getClass().getName() + " clickBookNameLink");
        bookStorePage.clickBookLink(bookName);

    }

    @Then("Book details page for {string} is displayed")
    public void showBookDetails(String bookName) {
        System.out.println(this.getClass().getName() + " showBookDetails");
        Assert.assertTrue(bookStorePage.verifyBookDetails(bookName));
    }

}
