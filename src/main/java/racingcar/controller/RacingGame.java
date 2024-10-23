package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

public class RacingGame {

    public void race() {
        String cars = initializeCars();
        int tryCount = initializeTryCount();
    }

    private String initializeCars() {
        InputView.promptForInputCars();
        return Console.readLine();
    }

    private int initializeTryCount() {
        InputView.promptForInputTryCount();
        String textTryCount = Console.readLine();
        validateNumber(textTryCount);
        return toInt(textTryCount);
    }

    private void validateNumber(String textTryCount) {
        try {
            Integer.parseInt(textTryCount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("아라비아 숫자를 입력해야 합니다");
        }
    }

    private int toInt(String textTryCount) {
        return Integer.parseInt(textTryCount);
    }
}
