package racingcar.controller;

import java.util.List;
import racingcar.dto.CarNamesInput;
import racingcar.utils.CarNameSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printCarNamesRequest();
        CarNamesInput carNamesInput = inputView.readCarNames();
        List<String> carNames = CarNameSplitter.separateCarNames(carNamesInput.carNames());

    }
}
