package racingcar.server.helper;

import racingcar.app.server.model.car.MyProgress;
import racingcar.app.server.model.location.Distance;
import racingcar.app.server.model.race.Lap;

public class MyProgressHelper {
    private MyProgressHelper() {
    }

    public static MyProgress mock(long remainingLap, long currentDistance) {
        Lap lap = Lap.from(remainingLap);
        Distance distance = Distance.from(currentDistance);
        return MyProgress.from(lap, distance);
    }
}
