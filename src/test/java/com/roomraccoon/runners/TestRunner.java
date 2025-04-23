package com.roomraccoon.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
            features = "src/test/java/resources",
            glue = {"com.roomraccoon.stepDefinitions"}//src/test/java/com/roomraccoon/stepDefinitions
            //for reports we will be using cucumber.io reports access on src/test/java/resources/cucumber.properties
)

public class TestRunner  extends AbstractTestNGCucumberTests{

    
}
