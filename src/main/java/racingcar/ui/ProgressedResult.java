package racingcar.ui;

import racingcar.domain.ProgressedInformation;

public class ProgressedResult {

    private final String carName;
    private final int score;

    public ProgressedResult(final String carName, final int score) {
        this.carName = carName;
        this.score = score;
    }

    public ProgressedResult(final ProgressedInformation progressedInformation) {
        this.carName = progressedInformation.getCarName();
        this.score = progressedInformation.getScore();
    }

    String getResult() {
        return carName + " : " + "-".repeat(score);
    }
}
