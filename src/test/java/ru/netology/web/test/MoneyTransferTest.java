package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class MoneyTransferTest {

    @BeforeEach
    public void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsFirstCard() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage().amountCards(0);
        new TransferPage().transferCard(DataHelper.getFirstCard().getCard(), "5000");

        var expected = 10000;
        var actual = new DashboardPage().getCardBalance(0);
        assertEquals(expected, actual);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsSecondCard() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage().amountCards(1);
        new TransferPage().transferCard(DataHelper.getSecondCard().getCard(), "5000");

        var expected = 10000;
        var actual = new DashboardPage().getCardBalance(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeVisibleFirstCardBalance() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage()
                .getCardBalance(0);
    }

    @Test
    void shouldBeVisibleSecondCardBalance() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage()
                .getCardBalance(1);
    }
}

