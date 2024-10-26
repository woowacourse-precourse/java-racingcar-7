package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.strategy.MoveStrategy;


public class RaceManager {
    private static final String CAR_DOES_NOT_EXISTS = "경주차가 존재하지 않습니다.";
    private final RaceStorage raceStorage = new RaceStorage();
    private final MoveStrategy moveStrategy;

    public RaceManager(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public String race(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceOneTime(cars);
        }

        return raceStorage.getResults();
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxLocation = getMaxLocation(cars);
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();
    }

    private void raceOneTime(List<Car> cars) {
        cars.forEach(car -> {
            if (moveStrategy.isCanMove()) {
                car.move();
            }
            raceStorage.addResult(car.toString());
        });

        raceStorage.addBlankLine();
    }

    private int getMaxLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(CAR_DOES_NOT_EXISTS));
    }


}
