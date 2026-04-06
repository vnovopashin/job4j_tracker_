package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Bus is moving");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Bus has " + count + " passengers");
    }

    @Override
    public void refuel(int fuel) {
        System.out.println("Bus refueled with " + fuel + " liters");
    }
}
