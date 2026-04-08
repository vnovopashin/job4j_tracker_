package ru.job4j.cast;

public class VehicleApp {
    public static void main(String[] args) {
        Vehicle airbus = new Aircraft();
        Vehicle boing = new Aircraft();
        Vehicle redArrow = new Train();
        Vehicle express = new Train();
        Vehicle schoolBus = new Bus();
        Vehicle paz = new Bus();
        Vehicle[] vehicles = {airbus, boing, redArrow, express, schoolBus, paz};
        for (Vehicle vehicle : vehicles) {
            vehicle.refuel();
            vehicle.move();
        }
    }
}
