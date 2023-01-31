package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.TestPropertiesManager;
import ru.ibs.framework.utils.PropsConst;

public class Hooks {
    @Before
    public void before() {
        InitManager.initFramework();
        DriverManager.getInstance().getDriver().get(TestPropertiesManager.getInstance().getProperty(PropsConst.MAIN_PAGE_URL));
    }

    @After
    public void after() {
        InitManager.quitFramework();
    }
}
