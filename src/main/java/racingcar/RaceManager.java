package racingcar;

import racingcar.io.InputReceiver;
import racingcar.model.CarName;

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
    }
}
