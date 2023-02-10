package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.DepositPage;

import java.util.List;

public class DepositPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Нажать кнопку настройки вклада")
    public void clickDepositSettingsButton() {
        pageManager.getPage(DepositPage.class).clickDepositSettingsButton();
    }

    @И("Заполнить поле \"Сумма\" значением {string}:")
    public void depositValueInput(String value) {
        pageManager.getPage(DepositPage.class).depositValueInput(value);
    }

    @И("Проверить соответствие актуального в поле \"Сумма\" значения введённому значению {string}:")
    public void checkValueField(String expected) {
        pageManager.getPage(DepositPage.class).checkValueField(expected);
    }

    @И("Выбрать {string} в поле \"Срок\":")
    public void depositPeriodChoosing(String period) {
        pageManager.getPage(DepositPage.class).depositPeriodChoosing(period);
    }

    @И("Проверить соответствие актуального в поле \"Срок\" значения выбранному значению {string}:")
    public void checkPeriodField(String expected) {
        pageManager.getPage(DepositPage.class).checkPeriodField(expected);
    }

    @И("Выбрать {string} в выпадающем списке поля \"Тип вклада\":")
    public void depositTypeChoosing(String type) {
        pageManager.getPage(DepositPage.class).depositTypeChoosing(type);
    }

    @И("Проверить соответствие актуального в поле \"Тип вклада\" значения выбранному значению {string}:")
    public void checkTypeField(String expected) {
        pageManager.getPage(DepositPage.class).checkTypeField(expected);
    }

    @И("Выбрать банки в выпадающем списке поля \"Банки\":")
    public void bankChoosing(List<String> banks) {
        pageManager.getPage(DepositPage.class).bankChoosing(banks);
    }

    @И("Проверить состояния чекбоксов выбранных банков:")
    public void checkSelectedBanks(List<String> expectedBanks) {
        pageManager.getPage(DepositPage.class).checkSelectedBanks(expectedBanks);
    }

    @И("Проверить состояния чекбоксов выбора дополнительных опций:")
    public void checkSelectedAdditionals(List<String> additionals) {
        pageManager.getPage(DepositPage.class).checkSelectedAdditionals(additionals);
    }

    @И("Выбрать дополнительные опции:")
    public void additionalsChoosing(List<String> additionals) {
        pageManager.getPage(DepositPage.class).additionalsChoosing(additionals);
    }

    @И("Нажать кнопку \"Показать\"")
    public void clickShowButton() {
        pageManager.getPage(DepositPage.class).clickShowButton();
    }

    @И("Закрыть окно акции \"Кэшбэк за вклад\"")
    public void closeCashBackWindow() {
        pageManager.getPage(DepositPage.class).closeCashBackWindow();
    }

    @И("Проверить на равенство количество подходящих вкладов и ожидаемое значение {string}:")
    public void checkResult(String amount) {
        pageManager.getPage(DepositPage.class).checkSuitableDepositsAmount(amount);
    }

    @И("Проверить вклад банка {string} на соответствие процентной ставки значению {string}:")
    public void checkDepositRateValue(String bankName, String value) {
        pageManager.getPage(DepositPage.class).checkDepositeRateValue(bankName, value);
    }

    @И("Проверить вклад банка {string} на соответствие срока значению {string}:")
    public void checkDepositPeriodValue(String bankName, String value) {
        pageManager.getPage(DepositPage.class).checkDepositPeriodValue(bankName, value);
    }

    @И("Проверить вклад банка {string} на соответствие дохода значению {string}:")
    public void checkDepositProfitValue(String bankName, String value) {
        pageManager.getPage(DepositPage.class).checkDepositProfitValue(bankName, value);
    }
}
