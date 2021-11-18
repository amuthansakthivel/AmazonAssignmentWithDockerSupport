package com.assignment.reports;

import com.assignment.constants.FrameworkConstants;
import com.assignment.exceptions.FrameworkException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {
    }

    private static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Automation");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getReportPath()).toURI());
        } catch (IOException e) {
            throw new FrameworkException("Problem while opening report file");
        }

    }

    public static void createTest(String testcasename) {
      ExtentManager.setExtentTest(extent.createTest(testcasename));
    }




}
