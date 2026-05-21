package ru.job4j.hashmap;

/**
 * Класс Subject описывает школьный предмет и аттестационный балл ученика.
 *
 * @param name  название предмета
 * @param score аттестационный балл
 */
public record Subject(String name, int score) {
}
