package com.patterns.abstractfactory.bmw;

import com.patterns.abstractfactory.CarBody;

public class BMVBody implements CarBody {
    @Override
    public int getLength() {
        return 3700;
    }

    @Override
    public int getWidth() {
        return 2100;
    }
}
