package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

    LoginPage login;

    @BeforeMethod
    public void setup() throws InterruptedException, IOException {
        initialization();
        login = new LoginPage(driver);
    }

    @Test
    public void loginBtresAccTest() throws InterruptedException, IOException {
        login.loginToApplication();
        System.out.println("Login test executed successfully");
    }

}