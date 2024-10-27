package racingcar.dto;

import java.util.Objects;

public class RaceRequest {

    private final String carNames;
    private final int lapCount;

    private RaceRequest(String carNames, int lapCount) {
        this.carNames = carNames;
        this.lapCount = lapCount;
    }

    public static RaceRequest of(String cars, int lapCount) {
        return new RaceRequest(cars, lapCount);
    }

    public String getCarNames() {
        return carNames;
    }

    public int getLapCount() {
        return lapCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RaceRequest that)) {
            return false;
        }
        return lapCount == that.lapCount && Objects.equals(carNames, that.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames, lapCount);
    }
}