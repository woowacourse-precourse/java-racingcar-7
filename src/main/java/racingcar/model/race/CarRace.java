package racingcar.model.race;

import java.util.List;
import racingcar.dto.RoundRaceRecord;
import racingcar.model.car.Cars;
import racingcar.model.car.Car;
import racingcar.model.race.strategy.MoveStrategy;

public class CarRace {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final CarRaceRecorder raceRecorder;

    public CarRace(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
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
        return raceRecorder.getWinnerCarNames(cars.getCars());
    }
}
