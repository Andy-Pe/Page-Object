package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static com.codeborne.selenide.Selenide.*;


class MoneyTransferTest {

    @BeforeEach
    public void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1FirstCard() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new TransferPage().transferCard(DataHelper.Cards.getFirstCard().getCard(), "5000");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1SecondCard() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new TransferPage().transferCard(DataHelper.Cards.getSecondCard().getCard(), "5000");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV2()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV3() {
        var loginPage = open("http://localhost:9999", LoginPageV3.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldBeVisibleFirstCardBalance() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV2()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage()
                .getCardBalance(0);
    }

    @Test
    void shouldBeVisibleSecondCardBalance() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV2()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage()
                .getCardBalance(1);
    }
}

