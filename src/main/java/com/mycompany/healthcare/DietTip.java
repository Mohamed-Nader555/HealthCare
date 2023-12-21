package com.mycompany.healthcare;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DietTip implements HealthTips {

    private final List<String> dietTips = Arrays.asList(
            "Eat a variety of colorful fruits and vegetables.",
            "Choose whole grains over refined grains.",
            "Limit processed and sugary foods.",
            "Stay hydrated by drinking plenty of water.",
            "Include lean proteins in your meals.",
            "Control portion sizes to avoid overeating.",
            "Plan and prepare your meals in advance.",
            "Read food labels to make informed choices.",
            "Enjoy occasional treats in moderation.",
            "Listen to your body's hunger and fullness cues."
    );

    @Override
    public String getDailyTip() {
        return getRandomTip(dietTips);
    }

    private String getRandomTip(List<String> tips) {
        Random random = new Random();
        int index = random.nextInt(tips.size());
        return tips.get(index);
    }
}
