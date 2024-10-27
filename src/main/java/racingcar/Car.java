package racingcar;

public class Car {

    public String name;

    public int score=0;

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
