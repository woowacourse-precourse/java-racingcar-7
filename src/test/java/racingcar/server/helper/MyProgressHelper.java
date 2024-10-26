package racingcar.server.helper;

import racingcar.server.model.car.MyProgress;
import racingcar.server.model.position.Position;
import racingcar.server.model.race.Lap;

public class MyProgressHelper {
    private MyProgressHelper() {
    }

    public static MyProgress mock(long remainingLap, String currentPosition) {
        Lap lap = Lap.from(remainingLap);
        Position position = Position.from(currentPosition);
        return MyProgress.from(lap, position);
    }
}
