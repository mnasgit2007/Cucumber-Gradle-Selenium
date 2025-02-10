package stepDef;

import io.cucumber.java.en.Then;
import pages.HomePage;
import helper.BaseTest;

public class HomeStepDef extends BaseTest {

    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage(){
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
    }
}
