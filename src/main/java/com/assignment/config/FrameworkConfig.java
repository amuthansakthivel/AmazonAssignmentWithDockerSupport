package com.assignment.config;

import com.assignment.config.converter.StringToDriverTypeConverter;
import com.assignment.config.converter.StringToRunTypeConverter;
import com.assignment.driver.enums.DriverType;
import com.assignment.driver.enums.RunType;
import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/test/resources/config.properties")
public interface FrameworkConfig extends Config {

    @ConverterClass(value = StringToDriverTypeConverter.class)
    @DefaultValue("CHROME")
    DriverType browser();

    String url();

    @Key(value = "gridPath")
    @DefaultValue(value = "http://localhost:4444/wd/hub")
    String gridPath();

    @Key(value="runmode")
    @DefaultValue("local")
    @ConverterClass(value = StringToRunTypeConverter.class)
    RunType runMode();
}
