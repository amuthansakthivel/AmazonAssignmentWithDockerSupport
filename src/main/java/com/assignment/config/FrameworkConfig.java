package com.assignment.config;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/test/resources/config.properties")
public interface FrameworkConfig extends Config {

    //TODO Implement Driver Factory
    String browser();

    String url();
}
