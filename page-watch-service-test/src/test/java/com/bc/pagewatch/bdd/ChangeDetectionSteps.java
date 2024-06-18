package com.bc.pagewatch.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;

@ScenarioScope
public class ChangeDetectionSteps {

    @Given("a web page has been saved in object storage")
    public void saveWebPageToObjectStorage() {

    }

    @Given("the same web page is updated")
    public void updateWebPage() {

    }

    @When("the same web page is downloaded again")
    public void downloadWebPage() {

    }

    @Then("the new version of the web page is saved")
    public void newWebPageSaved() {

    }


    @Then("the new version of the web page is compared against older verisions")
    public void compareWebPages() {

    }

    @Then("differences are saved in new marked image file")
    public void imageWithDifferencesIsSavedToDb() {

    }

}
