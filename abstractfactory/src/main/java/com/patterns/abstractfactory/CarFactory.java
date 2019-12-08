package com.patterns.abstractfactory;

import com.patterns.abstractfactory.audi.AudiCarFactory;
import com.patterns.abstractfactory.bmw.BMWCarFactory;

public abstract class CarFactory {
    public abstract CarEngine createCarEngine();
    public abstract CarBody createCarBody();

    public static CarFactory getCarFactoryFor(String carName){
        switch (carName){
            case "BMW":
                return new BMWCarFactory();
            case "AUDI":
                return new AudiCarFactory();
        }
        throw new IllegalArgumentException("Unknown car name");
    }
}
