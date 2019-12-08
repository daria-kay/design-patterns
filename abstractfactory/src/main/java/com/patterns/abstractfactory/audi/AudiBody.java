package com.patterns.abstractfactory.audi;

import com.patterns.abstractfactory.CarEngine;

public class AudiBody implements CarEngine {
    @Override
    public int getHorsepower() {
        return 470;
    }
}
