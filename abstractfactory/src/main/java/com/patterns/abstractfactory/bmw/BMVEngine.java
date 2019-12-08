package com.patterns.abstractfactory.bmw;

import com.patterns.abstractfactory.CarEngine;

public class BMVEngine implements CarEngine {
    @Override
    public int getHorsepower() {
        return 510;
    }
}
