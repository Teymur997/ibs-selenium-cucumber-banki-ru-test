package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends BasePage {
    @FindBy(xpath = "//div[@class=\"sc-hBEYos czEoCN\"]")
    private WebElement cashBackWindow;
    @FindBy(xpath = "//div[@class=\"SearchModal__StyledBody-sc-wuz0ak-1 eQdrBU\"]//input")
    private List<WebElement> depositInputFields;

    @FindBy(xpath = "//label[@class=\"sc-bBXqnf kzFhYx\"]//span")
    private List<WebElement> depositCheckbox;

    @FindBy(xpath = "//div[@data-placement]//li")
    private List<WebElement> dropDownList;

    @FindBy(xpath = "//ul[@class=\"sc-jUEnpm gXySZn\"]//li")
    private List<WebElement> checkedBanks;

    @FindBy(xpath = "//button[@class=\"sc-eCssSg xVSDo\"]")
    private WebElement settingsButton;

    @FindBy(xpath = "//button[@class=\"sc-eCssSg blUkiR\"]")
    private WebElement showButton;

    @FindBy(xpath = "//div[@class=\"sc-kIeTtH hNSQWJ\"]")
    private WebElement suitableDepositCount;

    @FindBy(xpath = "//div[@class=\"sc-gsTCUz LVeSn\"]")
    private List<WebElement> depositResults;


    public DepositPage closeCashBackWindow() {
        try {
            waitUntilElementIsVisible(cashBackWindow);
            actions.moveByOffset(200, 200).click().perform();
        } catch (NoSuchElementException | TimeoutException ignore) {
        }
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage clickDepositSettingsButton() {
        settingsButton.click();
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage depositValueInput(String value) {
        depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Сумма"))
                .findAny()
                .get().sendKeys(value);
        waitForStability(2000, 250);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkValueField(String expected) {
        String actual = depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Сумма"))
                .findAny()
                .get().getAttribute("value");
        Assertions.assertEquals(expected, actual, "Значение в поле \"Сумма\" не равно введенному значению " + expected);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage depositPeriodChoosing(String period) {
        WebElement periodDropDownField = depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Срок"))
                .map(element -> element.findElement(By.xpath(".//following-sibling::div[@data-test=\"dropdown\"]")))
                .findAny()
                .get();
        periodDropDownField.click();
        dropDownList.stream()
                .filter(element -> element.findElement(By.xpath("./div")).getText()
                        .contains(period))
                .findAny()
                .get()
                .click();
        waitForStability(2000, 250);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkPeriodField(String expected) {
        String actual = depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Срок"))
                .map(element -> element.findElement(By.xpath(".//following-sibling::div[@data-test=\"dropdown\"]")))
                .findAny()
                .get().getText();
        Assertions.assertEquals(expected, actual, "Значение в поле \"Срок\" не равно выбранному значению \"" + expected + "\"");
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage depositTypeChoosing(String type) {
        WebElement depositTypeDropDownField = depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Тип вклада"))
                .map(element -> element.findElement(By.xpath(".//following-sibling::div[@data-test=\"dropdown\"]")))
                .findAny()
                .get();
        depositTypeDropDownField.click();
        dropDownList.stream()
                .filter(element -> element.findElement(By.xpath("./div")).getText().contains(type))
                .findAny()
                .get()
                .click();
        waitForStability(2000, 250);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkTypeField(String expected) {
        String actual = depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Тип вклада"))
                .map(element -> element.findElement(By.xpath(".//following-sibling::div[@data-test=\"dropdown\"]")))
                .findAny()
                .get().getText();
        Assertions.assertEquals(expected, actual, "Значение в поле \"Тип вклада\" не равно выбранному значению \"" + expected + "\"");
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage bankChoosing(List<String> banks) {
        WebElement banksDropDownField = depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Банки"))
                .map(element -> element.findElement(By.xpath(".//..")))
                .findAny()
                .get();
        banksDropDownField.click();
        for (String bankName : banks) {
            WebElement bank = dropDownList.stream()
                    .filter(element -> element.getText().contains(bankName))
                    .findAny()
                    .get();
            bank.click();
        }
        banksDropDownField.click();
        waitForStability(2000, 250);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkSelectedBanks(List<String> expectedBanks) {
        WebElement banksDropDownField = depositInputFields.stream()
                .filter(element -> element.findElement(By.xpath(".//following-sibling::label"))
                        .getText().contains("Банки"))
                .map(element -> element.findElement(By.xpath(".//..")))
                .findAny()
                .get();
        banksDropDownField.click();
        for (String bankName : expectedBanks) {
            boolean isBankChoosed = checkedBanks.stream()
                    .anyMatch(element -> element.getText().contains(bankName));
            Assertions.assertTrue(isBankChoosed, "Банк \"" + bankName + "\"не выбран");
        }
        banksDropDownField.click();
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage additionalsChoosing(List<String> additionals) {
        for (String additional : additionals) {
            WebElement checkBox = depositCheckbox.stream()
                    .filter(element -> element.getText().contains(additional))
                    .findAny()
                    .get();
            checkBox.click();
        }
        waitForStability(2000, 250);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkSelectedAdditionals(List<String> additionals) {
        for (String additional : additionals) {
            WebElement checkBox = depositCheckbox.stream()
                    .filter(element -> element.getText().contains(additional))
                    .findAny()
                    .get();
            boolean isAdditionalChecked = checkBox.findElement(By.xpath(".//preceding-sibling::input"))
                    .getAttribute("checked")
                    .contains("true");
            Assertions.assertTrue(isAdditionalChecked, "Дополнительная опция \"" + additional + "\" не выбрана");
        }
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage clickShowButton() {
        showButton.click();
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkSuitableDepositsAmount(String amount) {
        Assertions.assertEquals(amount,
                valueTextHandler(suitableDepositCount.getText()),
                "Количество подходящих вкладов не соответствует " + amount);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkDepositeRateValue(String bankName, String value) {
        Assertions.assertEquals(value,
                getValue(bankName, "Cтавка"),
                "Актуальное значение процентной ставки вклада не равно " + value);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkDepositPeriodValue(String bankName, String value) {
        Assertions.assertEquals(value,
                getValue(bankName, "Срок"),
                "Актуальное значение срока вклада не равно " + value);
        return pageManager.getPage(DepositPage.class);
    }

    public DepositPage checkDepositProfitValue(String bankName, String value) {
        Assertions.assertEquals(value,
                getValue(bankName, "Доход"),
                "Актуальное значение дохода вклада не равно " + value);
        return pageManager.getPage(DepositPage.class);
    }

    private String getValue(String bankName, String indicator) {
        WebElement currentBank = depositResults.stream()
                .filter(element -> element.findElement(By.xpath(".//div[@data-test=\"text\"]"))
                        .getText().contains(bankName))
                .findAny()
                .get();
        return currentBank.findElements(By.xpath(".//div[@data-test=\"text\"]")).stream()
                .filter(element -> element.getText().contains(indicator))
                .map(element -> element.findElement(By.xpath(".//following-sibling::div[@data-test=\"text\"]")).getText())
                .findAny()
                .get();
    }

    private void waitForStability(int maxWaitMillis, int pollDelimiter) {
        double start = System.currentTimeMillis();
        while (System.currentTimeMillis() < start + maxWaitMillis) {
            String prevState = driverManager.getDriver().getPageSource();
            try {
                Thread.sleep(pollDelimiter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (prevState.equals(driverManager.getDriver().getPageSource())) {
                return;
            }
        }
    }
}
