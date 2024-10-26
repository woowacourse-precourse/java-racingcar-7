package racingcar;

import java.util.List;

public class RacingCarGame {
    InputNames inputNames;
    InputTry inputTry;
    RacingCarService racingCarService;

    List<String> carNames;
    int tryCount;

    public RacingCarGame() {
        inputNames = new InputNames();
        inputTry = new InputTry();
        racingCarService = new RacingCarService();
    }

    public void start() {
        carNames = inputNames.input();
        tryCount = inputTry.input();
    }
}