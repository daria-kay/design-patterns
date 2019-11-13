package com.darakay.designpatterns.builder;

import java.util.Objects;

public class Theme {
    private final String name;

    public Theme(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return name.equals(theme.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static Theme sample() {
        return new Theme("sample");
    }
}
