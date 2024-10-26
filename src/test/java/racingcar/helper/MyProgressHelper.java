package racingcar.helper;

import racingcar.model.car.MyProgress;
import racingcar.model.position.Position;
import racingcar.model.race.Lap;

public class MyProgressHelper {
    private MyProgressHelper() {
    }

    public static MyProgress mock(long remainingLap, String currentPosition) {
        Lap lap = Lap.from(remainingLap);
        Position position = Position.from(currentPosition);
        return MyProgress.from(lap, position);
    }
}
