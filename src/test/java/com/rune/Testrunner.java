package com.rune;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","html:target/cucumberreoprt", "html:target/htmlreoprt"},
features= {"src\\test\\resources\\Feature Collection"},
glue={"com.stepdata"},
tags={"@SmokeTest"})
public class Testrunner {

}
