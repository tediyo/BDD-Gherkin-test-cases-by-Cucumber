package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;
    Properties properties;

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        loadProperties();
        setupWebDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("app.url"));
    }

    @When("the user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(properties.getProperty("username.field.id"))));
        driver.findElement(By.id(properties.getProperty("username.field.id"))).sendKeys(username);
        driver.findElement(By.id(properties.getProperty("password.field.id"))).sendKeys(password);
    }

    @When("clicks the login button")
    public void clicks_login_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(properties.getProperty("login.button.id"))));
        driver.findElement(By.id(properties.getProperty("login.button.id"))).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void redirected_to_dashboard() {
        wait.until(ExpectedConditions.urlContains(properties.getProperty("dashboard.url.contains")));
        String url = driver.getCurrentUrl();
        assertTrue("Expected to be redirected to dashboard, but current URL is: " + url, 
                  url.contains(properties.getProperty("dashboard.url.contains")));
        driver.quit();
    }

    @Then("an error message {string} should be displayed")
    public void error_message_displayed(String expectedMessage) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(properties.getProperty("error.message.id"))));
        WebElement error = driver.findElement(By.id(properties.getProperty("error.message.id")));
        assertEquals("Expected error message: " + expectedMessage + ", but got: " + error.getText(), 
                    expectedMessage, error.getText());
        driver.quit();
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    private void setupWebDriver() {
        String chromeDriverPath = properties.getProperty("webdriver.chrome.driver.path");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(properties.getProperty("webdriver.implicit.wait"))));
    }
}
   
// Tewodros Berhanu
// 02/08/2025