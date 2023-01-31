package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.blocks.MenuBlockPage;

public class MenuBlockPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("Проверить корректность открытия страницы")
    public void checkIfPageIsOpened() {
        pageManager.getPage(MenuBlockPage.class).checkIfPageIsOpened();
    }

    @И("Закрыть окно выбора региона")
    public void closeRegionSelectButton() {
        pageManager.getPage(MenuBlockPage.class).closeRegionSelectButton();
    }

    @И("Выбрать меню {string}")
    public void chooseMenu(String menuName) {
        pageManager.getPage(MenuBlockPage.class).chooseMenu(menuName);
    }
}
