package racingcar.server.helper;

import racingcar.app.server.model.car.Car;
import racingcar.app.server.model.car.MyProgress;
import racingcar.app.server.model.position.Position;
import racingcar.app.server.model.race.Lap;

public class CarHelper {

    private CarHelper() {
    }

    public static Car mock(final String name, final long remainingLap, final String currentPosition) {
        Lap remaining = Lap.from(remainingLap);
        Position position = Position.from(currentPosition);
        MyProgress myProgress = MyProgress.from(remaining, position);
        return Car.from(name, myProgress);
    }
}
