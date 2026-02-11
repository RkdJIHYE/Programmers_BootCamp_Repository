package com.back;

import com.back.global.AppConfig;
import com.back.global.AppContext;

public class Main
{
    public static void main(String[] args) {
        AppContext.init();
        AppConfig.setDevMode();
        new App().run();

    }

}