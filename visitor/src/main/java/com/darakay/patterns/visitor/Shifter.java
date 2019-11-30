package com.darakay.patterns.visitor;

import com.darakay.patterns.visitor.figures.Circle;
import com.darakay.patterns.visitor.figures.Figure;
import com.darakay.patterns.visitor.figures.Point;
import com.darakay.patterns.visitor.figures.RegularPolygon;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Shifter implements Visitor {
    private int xOffset;
    private int yOffset;

    public Shifter(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    @Getter
    private List<Figure> offsetFigures = new ArrayList<>();

    @Override
    public void visit(Circle circle) {
        offsetFigures.add(new Circle(newCenter(circle.getCenter()), circle.getRadius()));
    }

    @Override
    public void visit(RegularPolygon regularPolygon) {
        offsetFigures.add(new RegularPolygon(newCenter(regularPolygon.getCenter()), regularPolygon.getRadius(),
                regularPolygon.getAngleNumber(), regularPolygon.getSideLength()));
    }

    @Override
    public void visit(Point point) {
        offsetFigures.add(newCenter(point));
    }

    private Point newCenter(Point oldCenter){
        return new Point(oldCenter.getX() + xOffset, oldCenter.getY() + yOffset);
    }
}
