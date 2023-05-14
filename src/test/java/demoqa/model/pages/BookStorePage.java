package demoqa.model.pages;

import demoqa.common.ScreenShots;
import demoqa.common.Util;
import org.openqa.selenium.By;

public class BookStorePage {
    public BookStorePage() {
    }

    public void navigateBookStorePage() {
        System.out.println(this.getClass().getName() + " navigateBookStorePage");
        Util.getWebDriver().get("https://demoqa.com/books");
        ScreenShots.takeScreenshot(Util.getWebDriver(),"BookStore");
    }

    public void clickBookLink(String bookName) {
        System.out.println(this.getClass().getName() + " clickBookLink");
        String xpath = "//a[contains(text(),'" + bookName + "')]";
        Util.getWebDriver().findElement(By.xpath(xpath)).click();

    }

    public boolean verifyBookDetails(String bookName) {
        System.out.println(this.getClass().getName() + " verifyBookDetails");
        String xpath = "//label[contains(text(),'" + bookName + "')]";
        return Util.getWebDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        Util.closeWebDriver();
    }
}
