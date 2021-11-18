package com.assignment.driver.factory;

import com.assignment.driver.remoteimpl.DockerManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){}

    @SneakyThrows
    public static WebDriver getDriver(){
       return new DockerManager().getDriver();
    }

}
