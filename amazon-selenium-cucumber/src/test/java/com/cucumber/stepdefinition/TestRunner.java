package com.cucumber.stepdefinition;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"com.cucumber.stepdefinition"}
		)


public class TestRunner {
	

}
