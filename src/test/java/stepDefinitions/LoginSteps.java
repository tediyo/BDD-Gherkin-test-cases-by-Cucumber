package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // the path should be where chromedriver is located
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login"); // here is the login page of application as an example
    }

    @When("the user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username); // insert  the username  (once corrctly and once wrongly ) 
        driver.findElement(By.id("password")).sendKeys(password); // insert  the password  (once corrctly and once wrongly )
    }

    @When("clicks the login button")
    public void clicks_login_button() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void redirected_to_dashboard() {
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("/dashboard")); // here it must navigate to dashboard page of application if username and passwords are correct
        driver.quit();
    }

    @Then("an error message {string} should be displayed")
    public void error_message_displayed(String expectedMessage) {
        WebElement error = driver.findElement(By.id("errorMessage")); // here it must display error message since the username and passwords are wrong
        assertEquals(expectedMessage, error.getText());
        driver.quit();
    }
}
   
// Tewodros Berhanu
// 02/08/2025