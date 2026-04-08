package ru.job4j.cast;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println("Aircraft is moving");
    }

    @Override
    public void refuel() {
        System.out.println("Aircraft is refueling");
    }
}
