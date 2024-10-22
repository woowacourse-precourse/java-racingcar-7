package racingcar.controller;

import racingcar.view.InputView;

/**
 * 전체적인 진행을 맡는 클래스
 * View와 메시지를 주고 받는다.
 */
public class CarController {

    private final InputView inputView;

    public CarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carNames = inputView.getCarNames();
        int chanceToMove = inputView.getChanceToMove();
    }
}
