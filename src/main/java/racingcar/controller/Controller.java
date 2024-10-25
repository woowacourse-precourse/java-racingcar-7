package racingcar.controller;

import racingcar.view.InputView;

public class Controller {
    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void startGame() {
        int repeatNumber = stringToInt();
    }

    private int stringToInt() {
        int gameCountInt = -1;
        String gameCountString = inputView.inputRoundNumber();
        if (isPositiveOrZeroInteger(gameCountString)) {
            gameCountInt = Integer.parseInt(gameCountString);
        }

        return gameCountInt;
    }

    private boolean isPositiveOrZeroInteger(String gameCountString) {
        if (!gameCountString.matches("\\d+")) {
            throw new IllegalArgumentException("0 이상의 정수를 입력해주세요.");
        }

        return true;
    }

}
