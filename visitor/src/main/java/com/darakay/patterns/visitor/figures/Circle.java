package com.darakay.patterns.visitor.figures;

import com.darakay.patterns.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Circle implements Figure {
    private Point center;
    private int radius;

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
