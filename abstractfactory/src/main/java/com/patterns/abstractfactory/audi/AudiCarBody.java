package com.patterns.abstractfactory.audi;

import com.patterns.abstractfactory.CarBody;

public class AudiCarBody implements CarBody {
    @Override
    public int getLength() {
        return 3000;
    }

    @Override
    public int getWidth() {
        return 2100;
    }
}
