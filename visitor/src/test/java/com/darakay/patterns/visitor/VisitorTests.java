package com.darakay.patterns.visitor;

import com.darakay.patterns.visitor.figures.Circle;
import com.darakay.patterns.visitor.figures.Figure;
import com.darakay.patterns.visitor.figures.Point;
import com.darakay.patterns.visitor.figures.RegularPolygon;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitorTests {

    private Visitor renderer = new Renderer();
    private Shifter shifter = new Shifter(10, 10);

    @Test
    public void renderFigures(){
        List<Figure> figures = ImmutableList.of(new Circle(new Point(0, 0), 2), new Point(1, 1));

        figures.forEach(figure -> figure.accept(renderer));
    }

    @Test
    public void offsetFigures(){
        List<Figure> figures = ImmutableList.of(
                new Circle(new Point(0, 0), 2),
                new RegularPolygon(new Point(1, 3), 10, 3, 6),
                new Point(1, 1));

        figures.forEach(figure -> figure.accept(shifter));

        assertThat(shifter.getOffsetFigures()).containsExactly(
                new Circle(new Point(10, 10), 2),
                new RegularPolygon(new Point(11, 13), 10, 3, 6),
                new Point(11, 11)
        );
    }
}