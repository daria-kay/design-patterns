package com.patterns.abstractfactory;

public class Program {
    public static void main(String[] args) {
        String carName = "BMW";
        CarFactory carFactory = CarFactory.getCarFactoryFor(carName);

        CarEngine engine = carFactory.createCarEngine();
        CarBody body = carFactory.createCarBody();

        System.out.println(carName + ": horsePower - " + engine.getHorsepower() + ", width - " + body.getWidth());
    }
}
