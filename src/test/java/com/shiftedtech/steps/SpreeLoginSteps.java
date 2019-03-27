package com.shiftedtech.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SpreeLoginSteps {
    private WebDriver driver;
    @Before
    public void setup(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @After
    public void teardown(){
        //driver.quit();
       // driver.close();
    }
    @Given("^Not a validated user$")
    public void not_a_validated_user() throws Throwable {
        driver.manage().deleteAllCookies();
    }
    @When("^User browse to the site$")
    public void user_browser_to_the_site(){
        driver.navigate().to("https://www.saksfifthavenue.com/checkout/checkout.jsp#init1");

    }
    @Then("^Spree home page should display$")
    public void spree_home_page_should_display() throws Throwable {
      String pageTitle=driver.getTitle();
      Assert.assertEquals("Spree Demo Site",pageTitle);
    }

    @When("^User click login link$")
    public void user_click_login_link() throws Throwable {
        WebElement loginLink= driver.findElement(By.id("shipFirst"));
        loginLink.sendKeys("saiful");

    }

    @Then("^Browser display Login page$")
    public void browser_display_Login_page() throws Throwable {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Login - Spree Demo Site", pageTitle);
    }

    @When("^User enter user email as \"([^\"]*)\"$")
    public void user_enter_user_email_as(String email) throws Throwable {
        WebElement emailElement= driver.findElement(By.id("spree_user_email"));
        emailElement.sendKeys(email);
    }

    @When("^User enter password as \"([^\"]*)\"$")
    public void user_enter_password_as(String password) throws Throwable {
        WebElement passwordElement= driver.findElement(By.id("spree_user_password"));
        passwordElement.sendKeys(password);

    }

    @When("^User click login button$")
    public void user_click_login_button() throws Throwable {
        WebElement loginElement= driver.findElement(By.xpath("//input[@name='commit']"));
    loginElement.click();
    }

    @Then("^Home page should display$")
    public void home_page_should_display() throws Throwable {
        String pageTitle=driver.getTitle();
        Assert.assertEquals("Spree Demo Site",pageTitle);
    }

    @Then("^Login success message display$")
    public void login_success_message_display() throws Throwable {
        WebElement loginSuccessLabel = driver.findElement(By.xpath("//div[@id='content']/div[contains(@class,'alert-success')]"));
        String successText = loginSuccessLabel.getText();
        Assert.assertEquals("Logged in successfully",successText);}

}