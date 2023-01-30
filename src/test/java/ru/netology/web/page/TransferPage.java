package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public DashboardPage transferCard(String cardNumber, String sum) {
        amountField.setValue(sum);
        fromField.setValue(cardNumber);
        transferButton.click();
        return new DashboardPage();
    }

    public String getErrorMsg() {
        return $("[data-test-id=error-notification]").getText();
    }
}
