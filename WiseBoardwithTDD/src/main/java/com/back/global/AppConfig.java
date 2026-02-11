package com.back.global;

public class AppConfig {

    private static String mode;

    public static void setTestMode() {
        AppConfig.mode = "test";
    }

    public static void setDevMode() {
        AppConfig.mode = "dev";
    }
}
