package racingcar.server.helper;

import racingcar.app.server.model.car.MyProgress;
import racingcar.app.server.model.position.Position;
import racingcar.app.server.model.race.Lap;

public class MyProgressHelper {
    private MyProgressHelper() {
    }

    public static MyProgress mock(long remainingLap, String currentPosition) {
        Lap lap = Lap.from(remainingLap);
        Position position = Position.from(currentPosition);
        return MyProgress.from(lap, position);
    }
}
