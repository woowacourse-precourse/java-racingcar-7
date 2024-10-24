package racingcar.domain;

import java.util.List;

public record Racing(RacingCars racingCars, RacingTryCount tryCount) {

    public static Racing of(String racingCars, String tryCount) {
        return new Racing(RacingCars.from(racingCars), RacingTryCount.from(tryCount));
    }

    public List<RacingCar> getWinners() {
        int maxPosition = racingCars.getMaxPosition();

        return racingCars.getCars().stream()
                .filter(car -> isSameMaxPosition(car, maxPosition))
                .toList();
    }

    private boolean isSameMaxPosition(RacingCar car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }
}
