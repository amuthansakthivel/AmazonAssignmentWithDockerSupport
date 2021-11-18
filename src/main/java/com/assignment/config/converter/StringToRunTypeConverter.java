package com.assignment.config.converter;

import com.assignment.driver.enums.RunType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRunTypeConverter implements Converter<RunType> {
    @Override
    public RunType convert(Method method, String string) {
        return RunType.valueOf(string.toUpperCase());
    }
}
