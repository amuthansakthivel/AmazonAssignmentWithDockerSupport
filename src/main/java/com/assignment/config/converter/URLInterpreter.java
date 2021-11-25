package com.assignment.config.converter;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Objects;

public class URLInterpreter implements Converter<String> {
    @Override
    public String convert(Method method, String remoteurl) {
        String property = System.getProperty("remoteurl");
        return Objects.isNull(property) ? remoteurl : property;
    }
}
