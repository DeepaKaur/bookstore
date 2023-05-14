package demoqa.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Util {

    static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if(webDriver != null) {
            System.out.println("Returning web driver " + webDriver);
            return webDriver;
        }

        System.out.println("Creating web driver");
        String os = System.getProperty("os.name");
        String driverPath = "";
        if (os.contains("Windows")) {
            driverPath = Util.class
                    .getClassLoader().getResource("chromedriver.exe").getPath();
        } else if (os.contains("Linux")) {
            driverPath = Util.class
                    .getClassLoader().getResource("chromedriver_linux").getPath();
        } else if (os.contains("Mac")) {
            driverPath = Util.class
                    .getClassLoader().getResource("chromedriver_mac").getPath();
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1600,900", "--ignore-certificate-errors");
        //options.addArguments("--headless","--disable-gpu","--window-size=1920,1200","--ignore-certificate-errors");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return webDriver;
    }

    public static void closeWebDriver() {
        System.out.println("Closing web driver");
        if (webDriver == null) {
            return;
        }
        webDriver.close();
        webDriver = null;
    }
}