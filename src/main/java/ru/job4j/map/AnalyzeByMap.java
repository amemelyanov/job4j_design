package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int countSubjects = 0;
        double sumScores = 0;
        for (Pupil pupil : pupils) {
            countSubjects += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sumScores += subject.score();
            }
        }
        return countSubjects != 0 ? sumScores / countSubjects : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double averageScore = 0;
            int countSubject = 0;
            for (Subject subject : pupil.subjects()) {
                averageScore += subject.score();
                countSubject++;
            }
            result.add(new Label(pupil.name(),
                    countSubject != 0 ? averageScore / countSubject : 0));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(),
                        (oldValue, newValue) -> oldValue + newValue);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        if (pupils.size() == 0) {
            throw new  IllegalArgumentException("Список учеников не должен быть пуст");
        }
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scores = 0;
            for (Subject subject : pupil.subjects()) {
                scores += subject.score();
            }
            result.add(new Label(pupil.name(), scores));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        if (pupils.size() == 0) {
            throw new  IllegalArgumentException();
        }
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(),
                        (oldValue, newValue) -> oldValue + newValue);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue()));
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }
}
