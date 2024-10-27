package racingcar.domain;

public class Participant {

    private final Car car;
    private int score;

    public Participant(final Car car, final int score) {
        this.car = car;
        this.score = score;
    }

    public ProgressedInformation getInfo() {
        return new ProgressedInformation(car, score);
    }
}
