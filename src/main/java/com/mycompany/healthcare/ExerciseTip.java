package com.mycompany.healthcare;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ExerciseTip implements HealthTips {

    private final List<String> exerciseTips = Arrays.asList(
            "Take a brisk walk for at least 30 minutes.",
            "Try cycling as a low-impact exercise.",
            "Incorporate strength training exercises 2-3 times a week.",
            "Join a fitness class or group for motivation.",
            "Use stairs instead of the elevator whenever possible.",
            "Practice yoga for flexibility and relaxation.",
            "Swimming is a great full-body workout.",
            "Dance to your favorite music for a fun workout.",
            "Set realistic fitness goals for yourself.",
            "Stay consistent with your exercise routine."
    );

    @Override
    public String getDailyTip() {
        return getRandomTip(exerciseTips);
    }

    private String getRandomTip(List<String> tips) {
        Random random = new Random();
        int index = random.nextInt(tips.size());
        return tips.get(index);
    }
}
