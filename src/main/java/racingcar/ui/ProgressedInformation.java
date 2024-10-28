package racingcar.ui;

public class ProgressedInformation {

    private final String carName;
    private final int score;

    public ProgressedInformation(final String carName, final int score) {
        this.carName = carName;
        this.score = score;
    }

    String getResult() {
        return carName + " : " + "-".repeat(score);
    }
}
