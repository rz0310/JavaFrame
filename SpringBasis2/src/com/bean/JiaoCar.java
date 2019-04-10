package com.bean;

import java.util.Properties;

public class JiaoCar {
    Car car;
    Properties properties;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "JiaoCar{" +
                "car=" + car +
                ", properties=" + properties +
                '}';
    }
}
