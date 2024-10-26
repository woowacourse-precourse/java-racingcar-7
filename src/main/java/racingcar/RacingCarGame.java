package racingcar;

import java.util.List;

public class RacingCarGame {
    InputNames inputNames;
    InputTry inputTry;
    RacingCarService racingCarService;

    public RacingCarGame() {
        inputNames = new InputNames();
        inputTry = new InputTry();
        racingCarService = new RacingCarService();
    }

    public void start() {
        List<String> names = inputNames.input();
    }
}