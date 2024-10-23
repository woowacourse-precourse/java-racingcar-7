package racingcar;

import racingcar.io.InputReceiver;
import racingcar.model.CarName;
import racingcar.model.MoveAttempt;

import java.util.Arrays;
import java.util.List;

public class RaceManager {
    private InputReceiver inputReceiver;

    public RaceManager(InputReceiver inputReceiver) {
        this.inputReceiver = inputReceiver;
    }

    public void run() {
        String carNamesString = inputReceiver.readInput();
        List<CarName> carNames = Arrays.stream(carNamesString.split(","))
                .map(CarName::of)
                .toList();
        String attemptCountString = inputReceiver.readInput();
        MoveAttempt moveAttempt = MoveAttempt.of(attemptCountString);
    }
}
