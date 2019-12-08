package com.patterns.abstractfactory.audi;

import com.patterns.abstractfactory.CarBody;
import com.patterns.abstractfactory.CarEngine;
import com.patterns.abstractfactory.CarFactory;

public class AudiCarFactory extends CarFactory {
    @Override
    public CarEngine createCarEngine() {
        return new AudiBody();
    }

    @Override
    public CarBody createCarBody() {
        return new AudiCarBody();
    }
}
