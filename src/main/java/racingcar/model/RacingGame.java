package racingcar.model;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> cars;
    private final int loopCount;

    public RacingGame(List<RacingCar> cars, int loopCount) {
        this.cars = cars;
        this.loopCount = loopCount;
    }

    public void playRound() {
        cars.forEach(RacingCar::move);
    }

    public List<RacingCar> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .getAsInt();
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getLoopCount() {
        return loopCount;
    }
}
