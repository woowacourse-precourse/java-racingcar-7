package racingcar.model;

public class Car {

    private String carName;
    private int gameTotalScore;
    private int playGameScore;

    public Car(String carName) {
        this.carName = carName;
        this.gameTotalScore = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setPlayGameScore(int playGameScore) {
        this.playGameScore = playGameScore;
    }

    public int getPlayGameScore() {
        return playGameScore;
    }

    public void incrementGameTotalScore() {
        this.gameTotalScore++;
    }

    public int getGameTotalScore() {
        return gameTotalScore;
    }

    public String getProgressDisplay() {
        return "-".repeat(getGameTotalScore());
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", gameTotalScore=" + gameTotalScore +
                '}';
    }
}
