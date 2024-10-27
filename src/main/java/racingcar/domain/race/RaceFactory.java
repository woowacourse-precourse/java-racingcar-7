package racingcar.domain.race;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.lap.Lap;
import racingcar.domain.moveProvider.MoveProvider;
import racingcar.domain.referee.Referee;

public class RaceFactory {

    public Race create(List<Car> cars, MoveProvider moveProvider) {
        Lap lap = new Lap(cars, moveProvider);
        return new Race(lap, new Referee());
    }
}
