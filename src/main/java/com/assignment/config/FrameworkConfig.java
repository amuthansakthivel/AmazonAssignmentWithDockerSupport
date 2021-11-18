package com.assignment.config;

import com.assignment.config.converter.StringToDriverTypeConverter;
import com.assignment.driver.enums.DriverType;
import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/test/resources/config.properties")
public interface FrameworkConfig extends Config {

    @ConverterClass(value = StringToDriverTypeConverter.class)
    @DefaultValue("CHROME")
    DriverType browser();

    String url();

}
