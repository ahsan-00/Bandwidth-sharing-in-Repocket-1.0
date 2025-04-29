import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

@SuppressWarnings("deprecation")
public class PocketTest {
    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException, URISyntaxException {
//        String appiumServerUrl = "http://192.168.97.169:4723/";
        String appiumServerUrl= "http://127.0.0.1:4723";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiAutomator2");
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/apps/Repocket.apk");
        dc.setCapability("appium:deviceName", "Pixel 7 Pro");
        dc.setCapability("appium:platformVersion", "Android 15.0");
        dc.setCapability("appium:noReset", true);
        dc.setCapability("appium:noSign", true);

        URI uri = new URI(appiumServerUrl);
        driver = new AndroidDriver(new URL(uri.toString()), dc);
    }

    @Test(priority = 1)
    public void clickAllowButton() {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE_APP")) {
                driver.context(contextName);
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']"))).click();
            System.out.println("Permission allowed button clicked successfully");
        } catch (Exception e) {
            System.out.println("Failed to click permission allowed button: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void clickSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"I'm new. Sign me up!\"]"))).click();
            System.out.println("Sign Up button clicked successfully");
        } catch (Exception e) {
            System.out.println("Failed to click sign Up button: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void completeSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Enter Name address
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"))).sendKeys("Test User");
            System.out.println("Email address entered successfully");

            // Enter email address
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"))).sendKeys("testmah007@gmail.com");
            System.out.println("Email address entered successfully");

            // Enter password
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[3]"))).sendKeys("Pass@1234");
            System.out.println("Password entered successfully");

            // Click on eye icon to view password
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button"))).click();
            System.out.println("Viewed password successfully");

           // Hide the keyboard
            driver.hideKeyboard();
            System.out.println("Keyboard closed successfully");

           // Click on Create Account button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Create Account\"]"))).click();
            System.out.println("Sign up button clicked successfully");
        } catch (Exception e) {
            System.out.println("Failed to complete sign up: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Click on login button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Have an account? Login\"]"))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"I already have an account\"]"))).click();
            System.out.println("Login button clicked successfully");

            // Enter email address
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[1]"))).sendKeys("testmah007@gmail.com");
            System.out.println("Email address entered successfully");

            // Enter password
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[2]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[2]"))).sendKeys("Pass@1234");
            System.out.println("Password entered successfully");

            // Click on the close button on the keyboard
            driver.hideKeyboard();
            System.out.println("Keyboard closed successfully");

            // Click on login button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]"))).click();
            System.out.println("Login button clicked successfully");
        } catch (Exception e) {
            System.out.println("Failed to login: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void Navigation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Click on Next button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Next\"]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Next\"]"))).click();
            System.out.println("Next button clicked successfully");

            // Click on Start Now
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Start Now\"]"))).click();
            System.out.println("Start Now button clicked successfully");

            // Click on Enable Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Enable\"]"))).click();
            System.out.println("Enable Button clicked successfully");

            // Click on Allow Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"))).click();
            System.out.println("Allow button clicked successfully");

            // Click on Enable Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Enable\"]"))).click();
            System.out.println("Enable button clicked successfully");

            // Click on Start earning Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Start earning\"]"))).click();
            System.out.println("Start earning button clicked successfully");

            // Click on Next Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Next\"]"))).click();
            System.out.println("Next button clicked successfully");

            // Click on Let's get started Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Let's get started\"]"))).click();
            System.out.println("Let's get started button clicked successfully");

        } catch (Exception e) {
            System.out.println("Failed to Navigate: " + e.getMessage());
        }
    }


    @Test(priority = 6)
    public void Navigat_to_Internet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Click on Internet menu button
            WebElement until = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Internet\\nTab 2 of 3")));
            until.click();
            System.out.println("Internet menu clicked successfully");

            // Click on Start Now
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Start Now\"]"))).click();
            System.out.println("Start Now button clicked successfully");

            // Click on Connect Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Connect\"]"))).click();
            System.out.println("Connect Button clicked successfully");

            // Check status.
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"You're earning\"]"))).click();
            System.out.println("Checked successfully! Traffic is sharing :)");

        } catch (Exception e) {
            System.out.println("Traffic is not sharing: " + e.getMessage());
        }
    }


    @AfterTest
    public void close() {
        driver.quit();
    }
}