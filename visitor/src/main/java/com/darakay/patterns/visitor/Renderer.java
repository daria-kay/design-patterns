package com.darakay.patterns.visitor;

import com.darakay.patterns.visitor.figures.Circle;
import com.darakay.patterns.visitor.figures.Point;
import com.darakay.patterns.visitor.figures.RegularPolygon;

public class Renderer implements Visitor {

    @Override
    public void visit(Circle circle) {
        System.out.println("This is circle! Center in " + circle.getCenter()
                + " and radius " + circle.getRadius());
    }

    @Override
    public void visit(RegularPolygon regularPolygon) {
        System.out.println("This is polygon! " + regularPolygon.toString());
    }

    @Override
    public void visit(Point point) {
        System.out.println("This is point! " + point.toString());
    }
}
