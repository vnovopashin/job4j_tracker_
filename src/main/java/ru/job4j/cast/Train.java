package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Train is moving");
    }

    @Override
    public void refuel() {
        System.out.println("Train is refueling");
    }
}
