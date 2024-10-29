package racingcar.server.helper;

import racingcar.app.server.model.car.Car;
import racingcar.app.server.model.car.MyProgress;
import racingcar.app.server.model.location.Distance;
import racingcar.app.server.model.race.Lap;

public class CarHelper {

    private CarHelper() {
    }

    public static Car mock(final String name, final long remainingLap, final long initialDistance) {
        Lap remaining = Lap.from(remainingLap);
        Distance distance = Distance.from(initialDistance);
        MyProgress myProgress = MyProgress.from(remaining, distance);
        return Car.of(name, myProgress);
    }
}
