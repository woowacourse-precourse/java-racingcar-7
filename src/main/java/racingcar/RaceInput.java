package racingcar;

public class RaceInput {
    private String carNames;
    private int totalAttempts;

    public RaceInput(String carNames, int totalAttempts) {
        this.carNames = carNames;
        this.totalAttempts = totalAttempts;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }
}
