package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputHandler.getCarNames();
        Validator.validateCarNames(carNames);

        int raceCount = InputHandler.getRaceCount();
        Validator.validateRaceCount(raceCount);

    }
}
