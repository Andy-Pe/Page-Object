package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getInvalidAuthInfo() {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    public static VerificationCode getInvalidVerificationCode() {
        return new VerificationCode("12359");
    }

    public static String getFirstCard() {
        return new String("5559 0000 0000 0001");
    }

    public static String getSecondCard() {
        return new String("5559 0000 0000 0002");
    }

    public static String getInvalidCard() {
        return new String("5559 0000 0000 0015");
    }
}
