package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return x / y;
    }

    public int sumAllOperation(int y) {
        Calculator calc = new Calculator();
        return sum(y) + minus(y) + calc.multiply(y) + calc.divide(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = Calculator.sum(10);
        System.out.println(result);
        System.out.println(Calculator.minus(10));
        System.out.println(calc.multiply(10));
        System.out.println(calc.divide(10));
        System.out.println(calc.sumAllOperation(10));
    }
}
