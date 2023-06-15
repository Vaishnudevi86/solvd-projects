package com.solvd.practice;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.solvd.practice.Main.logger;

public class ReflectionClass {
    public static void main(String[] args) throws ClassNotFoundException{
        Class classR= Class.forName("buildingcompany.Apartment");
        logger.info(Stream.of(classR.getDeclaredMethods())
                .map(Method::getName).collect(Collectors.toList()));
        classR.getMethods();
    }
}
