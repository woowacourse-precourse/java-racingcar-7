package racingcar.domain;

import java.util.List;

public class Racing {

    private final RacingCars racingCars;
    private final RacingTryCount tryCount;

    public Racing(RacingCars racingCars, RacingTryCount tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public static Racing of(String racingCars, String tryCount) {
        return new Racing(RacingCars.from(racingCars), RacingTryCount.from(tryCount));
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public RacingTryCount getTryCount() {
        return tryCount;
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
