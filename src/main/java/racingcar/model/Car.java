package racingcar.model;

public class Car {

    private String carName;
    private int gameTotalScore;
    private int playGameScore;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getGameTotalScore() {
        return gameTotalScore;
    }

    public void setGameTotalScore(int gameTotalScore) {
        this.gameTotalScore = gameTotalScore;
    }

    public int getPlayGameScore() {
        return playGameScore;
    }

    public void setPlayGameScore(int playGameScore) {
        this.playGameScore = playGameScore;
    }
}
