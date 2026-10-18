package com.example.patterns.singleton;

/**
 * The settings of the application. There must be only ONE AppSettings in the
 * whole program, so every part of the program sees the same settings.
 *
 * STUDENT TASK 1 - make this class a Singleton.
 */
public class AppSettings {

    // TODO 1: create the one and only object, here, in a private static final field:
    //
    private static final AppSettings INSTANCE = new AppSettings();

    private String appName = "My App";

    // TODO 2: make this constructor private, so nobody outside can write "new AppSettings()".
    private AppSettings() {
    }

    // TODO 3: return the one and only object (INSTANCE). Do not create a new one here.
    public static AppSettings getInstance() {
        return INSTANCE;
    }

    // ------------------------------------------------------------------
    // PROVIDED - do not change
    // ------------------------------------------------------------------
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
