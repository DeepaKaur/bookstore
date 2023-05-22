package demoqa.model.pages;

import demoqa.common.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    public ProfilePage() {
    }

    public void NavigateHome() {
        Util.getWebDriver().get("https://demoqa.com/login");
        Util.getWebDriver().manage().window().maximize();
    }

    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        Util.closeWebDriver();
    }

    public void clickProfileSideNav() {
        System.out.println(this.getClass().getName() + " clickProfileSideNav");
        //scroll to the element to click
        WebElement element = Util.getWebDriver().findElement(By.xpath("//span[contains(text(),'Profile')]"));
        ((JavascriptExecutor) Util.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public boolean verifyProfilePage() {
        System.out.println(this.getClass().getName() + " verifyProfilePage");
        return Util.getWebDriver().findElement(By.xpath("//div[@class='main-header']")).getText().contains("Profile");
    }
}
