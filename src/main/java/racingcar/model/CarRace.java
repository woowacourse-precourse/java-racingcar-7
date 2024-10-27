package racingcar.model;

import java.util.List;
import racingcar.dto.RoundRaceRecord;
import racingcar.model.move.MoveStrategy;
import racingcar.model.move.RandomMoveStrategy;

public class CarRace {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final CarRaceRecorder raceRecorder;

    public CarRace(Cars cars) {
        this.cars = cars;
        this.moveStrategy = new RandomMoveStrategy();
        this.raceRecorder = new CarRaceRecorder();
    }

    public List<RoundRaceRecord> startRound() {
        moveCarsIfAble();
        return getRoundRaceRecord();
    }

    private void moveCarsIfAble() {
        for (Car car : cars.getCars()) {
            if (moveStrategy.canMove()) {
                car.moveForward();
            }
        }
    }

    private List<RoundRaceRecord> getRoundRaceRecord() {
        return raceRecorder.recordRound(cars.getCars());
    }

    public List<String> getWinnerCarNames() {
        List<Car> allCars = cars.getCars();

        int maxPosition = allCars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("자동차가 존재하지 않습니다."));

        return allCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
