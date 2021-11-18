package com.assignment.constants;

import lombok.Getter;

public final class FrameworkConstants {

    private @Getter static final String reportPath = System.getProperty("user.dir")+"/ExtentReports/index.html";
    private @Getter static final int timeout = 10;
}
