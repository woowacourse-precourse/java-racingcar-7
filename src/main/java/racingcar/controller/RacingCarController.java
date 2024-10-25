package racingcar.controller;

import racingcar.validator.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {
    public void startGame() {
        List<String> carNames = InputView.getCarNames();
        InputValidator.validateCarNames(carNames);

        int rounds = InputView.getRounds();
        InputValidator.validateRounds(rounds);

        // 이후 게임 로직 실행
    }
}
