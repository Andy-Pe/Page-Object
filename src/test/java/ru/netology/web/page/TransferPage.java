package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement paymentPage = $(byText("Пополнение карты"));
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement errorTransfer = $("[data-test-id='error-notification']");


    public void paymentVisible() {
        paymentPage.shouldBe(Condition.appear);
    }

    public void setAmount(String sum) {
        amountField.setValue(sum);
    }

    public void setFromCardField(String numberCard) {
        fromField.setValue(numberCard);
    }

    public DashboardPage getTransfer() {
        transferButton.click();
        return new DashboardPage();
    }

    public void invalidTransfer() {
        transferButton.click();
        errorTransfer.shouldBe(Condition.appear);
    }
}
