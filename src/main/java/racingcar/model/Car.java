package racingcar.model;

public class Car {
    private String carName;
    private int score;

    public Car(String carName, int score) {
        this.carName = carName;
        this.score = score;
    }

    public String getCarName() {
        return carName;
    }

    public int getScore() {
        return score;
    }
}
