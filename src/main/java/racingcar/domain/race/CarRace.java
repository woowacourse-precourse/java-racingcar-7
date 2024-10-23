package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.move.MoveAttempt;
import racingcar.domain.move.MoveDecider;

import java.util.List;

public class CarRace {
    private final MoveDecider moveDecider;

    public CarRace(MoveDecider moveDecider) {
        this.moveDecider = moveDecider;
    }

    public RacePosition repeatExecution(RacePosition racePosition, MoveAttempt moveAttempt) {
        RacePosition afterRepeat = racePosition;
        for (int i = 0; i < moveAttempt.getCount(); i++) {
           afterRepeat = execute(racePosition);
        }
        return afterRepeat;
    }

    public RacePosition execute(RacePosition racePosition) {
        List<Car> cars = racePosition.getCarList()
                .stream()
                .map(this::moveIfAllowed)
                .toList();
        return new RacePosition(cars);
    }

    private Car moveIfAllowed(Car car) {
        if (moveDecider.canMove()) {
            return car.moveForward();
        }
        return car;
    }
}
