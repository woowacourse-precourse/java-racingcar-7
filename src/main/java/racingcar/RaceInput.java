package racingcar;

public class RaceInput {
    private String carNames;
    private int numberOfAttempts;

    public RaceInput(String carNames, int numberOfAttempts) {
        this.carNames = carNames;
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
