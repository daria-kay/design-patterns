package com.darakay.patterns.visitor.figures;

import com.darakay.patterns.visitor.Visitor;
import com.darakay.patterns.visitor.figures.Figure;
import com.darakay.patterns.visitor.figures.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class RegularPolygon implements Figure {
    private Point center;
    private int radius;
    private int angleNumber;
    private int sideLength;

    @Override
    public double getArea() {
        return 0.5 * sideLength * angleNumber * radius;
    }

    @Override
    public double getPerimeter() {
        return sideLength*angleNumber;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
