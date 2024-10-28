package racingcar.domain;

import java.util.Objects;

public class ProgressedInformation {

    private final Car car;
    private final int score;

    ProgressedInformation(final Car car, final int score) {
        this.car = car;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProgressedInformation that = (ProgressedInformation) o;
        return score == that.score && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, score);
    }
}
