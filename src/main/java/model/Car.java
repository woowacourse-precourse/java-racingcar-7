package model;

import view.CarView;

public class Car {

    private final CarView carView = new CarView();

    public String name;

    public int score = 0;

    public int randomValue;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int randomValue) {
        this.name = name;
        this.randomValue = randomValue;
    }

    public Car(String name, int randomValue, int score) {
        this.name = name;
        this.randomValue = randomValue;
        this.score = score;
    }

    public void evaluateScoreBasedOnRandomValue(int randomValue) {
        this.randomValue = randomValue;
        if (this.randomValue >= 4) {
            score += 1;
        }
        carView.updateScoreIfNeeded(name, score);
    }

    public boolean determineWinners (int maxScore) {
        if(maxScore == score) {
            return true;
        };
        return false;
    }

    public int compareScore(int currentMaxScore) {
        if (score > currentMaxScore) {
            return score;
        } else {
            return currentMaxScore;
        }
    }



    public int getScore() {
        return score;
    }

    public void setScore(int Score) {
        this.score = Score;
    }

    public String getName() {
        return name;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public int getRandomValue() {
        return randomValue;
    }
}

