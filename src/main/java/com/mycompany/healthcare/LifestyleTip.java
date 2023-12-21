package com.mycompany.healthcare;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LifestyleTip implements HealthTips {

    private final List<String> lifestyleTips = Arrays.asList(
            "Ensure you get 7-9 hours of quality sleep each night.",
            "Practice mindfulness or meditation for stress relief.",
            "Take short breaks to stretch and move during the day.",
            "Maintain social connections for emotional well-being.",
            "Limit screen time, especially before bedtime.",
            "Develop a consistent sleep schedule.",
            "Find hobbies or activities that bring you joy.",
            "Unplug and spend time in nature.",
            "Set boundaries to manage work-life balance.",
            "Express gratitude for positive aspects of your life."
    );

    @Override
    public String getDailyTip() {
        return getRandomTip(lifestyleTips);
    }

    private String getRandomTip(List<String> tips) {
        Random random = new Random();
        int index = random.nextInt(tips.size());
        return tips.get(index);
    }
}
