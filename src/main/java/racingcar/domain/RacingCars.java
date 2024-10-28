package racingcar.domain;

import static racingcar.util.Utility.checkMoveOrNot;

import java.util.List;
import java.util.Map;

public class RacingCars {

    private final Map<String, Integer> racingCars;

    public RacingCars(Map<String, Integer> racingCars) {
        this.racingCars = racingCars;
    }

    public Map<String, Integer> initializeCars(List<String> splitCarNames) {

        splitCarNames.forEach(carName -> racingCars.put(carName, 0));

        return racingCars;
    }

    public void attemptMoveCarsInOneRound() {

        racingCars.entrySet().forEach(carEntry -> {
            if (checkMoveOrNot()) {
                carEntry.setValue(carEntry.getValue() + 1);
            }
        });
    }

}
