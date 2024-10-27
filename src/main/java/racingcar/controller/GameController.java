package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.GameView;

public final class GameController {
    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        String carNamesInput = gameView.getCarNamesInput();
        List<String> carNameList = parseCarNames(carNamesInput);
    }

    private List<String> parseCarNames(String carNamesInput) {
        List<String> carNameList;

        carNameList = Arrays.asList(carNamesInput.split(","));

        return carNameList;
    }
}
