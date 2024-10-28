package racingcar.model;

import racingcar.view.CarView;

public class Car {
    private final CarView carView = new CarView();
    private final String name;
    private int score; // 기본값 0으로 초기화됨
    private int randomValue;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int randomValue) {
        this(name, randomValue, 0);
    }

    public Car(String name, int randomValue, int score) {
        this.name = name;
        this.randomValue = randomValue;
        this.score = score;
    }

    public void evaluateScoreBasedOnRandomValue(int randomValue) {
        this.randomValue = randomValue;
        if (this.randomValue >= 4) {
            score++;
        }
        carView.updateScoreIfNeeded(name, score);
    }

    public boolean determineWinners(int maxScore) {
        return maxScore == score;
    }

    public int compareScore(int currentMaxScore) {
        return Math.max(score, currentMaxScore);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
