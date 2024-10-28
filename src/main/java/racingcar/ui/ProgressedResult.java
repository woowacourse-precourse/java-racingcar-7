package racingcar.ui;

class ProgressedResult {

    private final String carName;
    private final int score;

    ProgressedResult(final String carName, final int score) {
        this.carName = carName;
        this.score = score;
    }

    String getResult() {
        return carName + " : " + "-".repeat(score);
    }
}
