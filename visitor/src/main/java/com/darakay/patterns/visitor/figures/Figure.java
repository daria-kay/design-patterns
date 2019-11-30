package com.darakay.patterns.visitor.figures;

import com.darakay.patterns.visitor.Visitor;

public interface Figure {
    double getArea();
    double getPerimeter();
    void accept(Visitor visitor);
}
