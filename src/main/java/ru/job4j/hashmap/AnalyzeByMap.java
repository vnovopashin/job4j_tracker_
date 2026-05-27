package ru.job4j.hashmap;

import java.util.*;

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
        if (pupils == null || pupils.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            count += subjects.size();
            for (Subject subject : subjects) {
                sum += subject.score();
            }
        }
        return count == 0 ? 0.0 : sum / count;
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
        if (pupils == null) {
            return result;
        }
        for (Pupil pupil : pupils) {
            String name = pupil.name();
            List<Subject> subjects = pupil.subjects();
            if (subjects.isEmpty()) {
                result.add(new Label(name, 0.0));
                continue;
            }
            double sum = 0;
            for (Subject subject : subjects) {
                sum += subject.score();
            }
            double avg = sum / subjects.size();
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
        if (pupils == null || pupils.isEmpty()) {
            return new ArrayList<>();
        }
        Map<String, Integer> sumBySubject = new HashMap<>();
        Map<String, Integer> countBySubject = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = subject.score();
                sumBySubject.put(name, sumBySubject.getOrDefault(name, 0) + score);
                countBySubject.put(name, countBySubject.getOrDefault(name, 0) + 1);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sumBySubject.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            int count = countBySubject.get(subjectName);
            double avg = (double) totalScore / count;
            result.add(new Label(subjectName, avg));
        }
        return result;
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
        if (pupils == null || pupils.isEmpty()) {
            return null;
        }
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
        if (pupils == null || pupils.isEmpty()) {
            return null;
        }

        Map<String, Integer> totalBySubject = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = subject.score();
                totalBySubject.put(name, totalBySubject.getOrDefault(name, 0) + score);
            }
        }
        String bestSubjectName = null;
        int maxTotal = -1;

        for (Map.Entry<String, Integer> entry : totalBySubject.entrySet()) {
            if (entry.getValue() > maxTotal) {
                maxTotal = entry.getValue();
                bestSubjectName = entry.getKey();
            }
        }

        return new Label(bestSubjectName, maxTotal);
    }
}
