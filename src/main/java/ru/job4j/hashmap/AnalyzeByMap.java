package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс AnalyzeByMap получает статистику по аттестатам.
 */
public class AnalyzeByMap {

    /**
     * Метод вычисляет общий средний балл.
     *
     * @param pupils ученики
     * @return средний балл
     */
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            count += subjects.size();
            for (Subject subject : subjects) {
                sum += subject.score();
            }
        }
        return sum / count;
    }

    /**
     * Метод вычисляет средний балл по каждому ученику.
     * То есть берем одного ученика и считаем все его баллы за все предметы и делим на количество предметов.
     * Возвращает список из объекта Label (имя ученика и средний балл).
     *
     * @param pupils ученики
     * @return средний балл по каждому ученику
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            String name = pupil.name();
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            double avg = sum / pupils.size();
            result.add(new Label(name, avg));
        }
        return result;
    }

    /**
     * Метод вычисляет средний балл по каждому предмету.
     * Например, собираем все баллы учеников по предмету география и делим на количество учеников.
     * Возвращает список из объектов Label (название предмета и средний балл).
     *
     * @param pupils ученики
     * @return средний балл по каждому предмету
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return List.of();
    }

    /**
     * Метод возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим суммарным баллом по всем предметам.
     * Возвращает объект Label (имя ученика и суммарный балл).
     *
     * @param pupils ученики
     * @return лучший ученик
     */
    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            String name = pupil.name();
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            result.add(new Label(name, sum));
        }
        result.sort(Comparator.reverseOrder());
        return result.get(0);
    }

    /**
     * Метод возвращает предмет с наибольшим баллом для всех студентов.
     * Возвращает объект Label (имя предмета, сумма баллов каждого ученика по этому предмету).
     *
     * @param pupils ученики
     * @return предмет с наибольшим баллом
     */
    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
