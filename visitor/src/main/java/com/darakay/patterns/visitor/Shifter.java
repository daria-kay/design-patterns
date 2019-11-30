package com.darakay.patterns.visitor;

import com.darakay.patterns.visitor.figures.Circle;
import com.darakay.patterns.visitor.figures.Figure;
import com.darakay.patterns.visitor.figures.Point;
import com.darakay.patterns.visitor.figures.RegularPolygon;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Shifter implements Visitor {
    private int xOffset;
    private int yOffset;

    @Getter
    private Figure offsetFigure;

    @Override
    public void visit(Circle circle) {
        offsetFigure = new Circle(newCenter(circle.getCenter()), circle.getRadius());
    }

    @Override
    public void visit(RegularPolygon regularPolygon) {
        offsetFigure = new RegularPolygon(newCenter(regularPolygon.getCenter()), regularPolygon.getRadius(),
                regularPolygon.getAngleNumber(), regularPolygon.getSideLength());
    }

    @Override
    public void visit(Point point) {
        offsetFigure = newCenter(point);
    }

    private Point newCenter(Point oldCenter){
        return new Point(oldCenter.getX() + xOffset, oldCenter.getY() + yOffset);
    }
}
