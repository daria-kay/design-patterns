package com.patterns.abstractfactory.bmw;

import com.patterns.abstractfactory.CarBody;
import com.patterns.abstractfactory.CarEngine;
import com.patterns.abstractfactory.CarFactory;

public class BMWCarFactory extends CarFactory {

    @Override
    public CarEngine createCarEngine() {
        return new BMVEngine();
    }

    @Override
    public CarBody createCarBody() {
        return new BMVBody();
    }
}
