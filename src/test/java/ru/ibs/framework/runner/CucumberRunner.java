package ru.ibs.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\features"},
        glue = {"ru.ibs.framework.steps"},
        tags = "@Parameterized",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
//        plugin = {"src.main.java.ru.ibs.framework.utils.AllureListener"}
)
public class CucumberRunner {
}
