package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.managers.TestPropertiesManager;
import ru.ibs.framework.utils.PropsConst;

public class Hooks {
    DriverManager driverManager = DriverManager.getInstance();
    TestPropertiesManager testPropertiesManager = TestPropertiesManager.getInstance();
    PageManager pageManager = PageManager.getInstance();
    @Before
    public void before() {
        InitManager.initFramework();
        driverManager.getDriver().get(testPropertiesManager.getProperty(PropsConst.MAIN_PAGE_URL));
    }

    @After
    public void after() {
        InitManager.quitFramework();
        pageManager.clearPages();
    }
}
