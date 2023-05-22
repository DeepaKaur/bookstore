package demoqa.model.pages;

import demoqa.common.ScreenShots;
import demoqa.common.Util;
import org.openqa.selenium.By;

public class LoginPage {

    public LoginPage() {
    }

    public void cleanUp() {
        System.out.println("cleanUp");
        Util.closeWebDriver();
    }

    public void enterLoginCredentials(String username, String password) {
        System.out.println("In page : Username and password : " + username + " " + password);
        Util.getWebDriver().findElement(By.xpath("//input[@id='userName']")).sendKeys(username == null ? "" : username);
        Util.getWebDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password == null ? "" : password);
    }

    public void clickLoginBtn() {

        Util.getWebDriver().findElement(By.id("login")).click();

    }

    public String getUsername() {
        return Util.getWebDriver().findElement(By.id("userName-value")).getText();
    }

    public boolean isUsernameError() {
        ScreenShots.takeScreenshot(Util.getWebDriver(), "UsernameError");
        return Util.getWebDriver().findElement(By.xpath("//input[@class='mr-sm-2 is-invalid form-control' and @id='userName']")).isDisplayed();
    }

    public boolean isPasswordError() {
        ScreenShots.takeScreenshot(Util.getWebDriver(), "PasswordError");
        return Util.getWebDriver().findElement(By.xpath("//input[@class='mr-sm-2 is-invalid form-control' and @id='password']")).isDisplayed();
    }

    public boolean isLoginSuccess() {
        ScreenShots.takeScreenshot(Util.getWebDriver(), "LoginSuccess");
        return Util.getWebDriver().findElement(By.id("userName-label")).isDisplayed();
    }

    public void NavigateHome() {
        Util.getWebDriver().get("https://demoqa.com/login");
        Util.getWebDriver().manage().window().maximize();
        ScreenShots.takeScreenshot(Util.getWebDriver(), "Homepage");
    }

    public void logout() {
        Util.getWebDriver().findElement(By.xpath("//button[contains(text(),'Log out')]")).click();
    }
}
