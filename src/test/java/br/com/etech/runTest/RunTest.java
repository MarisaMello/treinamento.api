package br.com.etech.runTest;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = SnippetType.CAMELCASE, plugin = {"pretty","io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
        features = {"./src/test/resources/"},
        glue = {"br.com.etech.api.steps"},
        tags = "@citiesInCircle")


public class RunTest {
}
