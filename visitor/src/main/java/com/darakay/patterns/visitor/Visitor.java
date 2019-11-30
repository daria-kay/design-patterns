package com.darakay.patterns.visitor;

import com.darakay.patterns.visitor.figures.Circle;
import com.darakay.patterns.visitor.figures.Point;
import com.darakay.patterns.visitor.figures.RegularPolygon;

public interface Visitor {
    void visit(Circle circle);
    void visit(RegularPolygon regularPolygon);
    void visit(Point point);
}
