package com.assignment.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger() {
    }

    private static final Consumer<String> PASS = (message) -> ExtentManager.getExtentTest().pass(message);
    private static final Consumer<String> FAIL = (message) -> ExtentManager.getExtentTest().fail(message);
    private static final Consumer<String> INFO = (message) -> ExtentManager.getExtentTest().info(message);
    private static final Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL);
        MAP.put(LogType.INFO, INFO);
    }

    public static void log(LogType status, String message) {
       MAP.getOrDefault(status,PASS).accept(message);
    }




}
