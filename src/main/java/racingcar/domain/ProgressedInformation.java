package racingcar.domain;

import java.util.Objects;

public class ProgressedInformation {

    private final Car car;
    private final int score;

    ProgressedInformation(final Car car, final int score) {
        this.car = car;
        this.score = score;
    }

    public String getCarName() {
        return this.car.getCarName().getName();
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final ProgressedInformation targetInformation = (ProgressedInformation) object;
        return score == targetInformation.score && Objects.equals(car, targetInformation.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, score);
    }
}
