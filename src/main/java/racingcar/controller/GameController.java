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
        // 파싱과정에서 조건에 맞게 validate하기! -> 유효한 이름, 5글자 이하
        List<String> carNameList = parseCarNames(carNamesInput);

        // 입력값 정수인지 validate하기
        int totalRound = Integer.parseInt(gameView.getTotalRoundInput());
    }

    private List<String> parseCarNames(String carNamesInput) {
        List<String> carNameList;

        carNameList = Arrays.asList(carNamesInput.split(","));

        return carNameList;
    }
}
