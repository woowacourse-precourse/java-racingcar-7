package racingcar.controller;

import java.math.BigInteger;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.factory.CarFactory;
import racingcar.view.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputName = inputView.requestCarNames();
        List<String> carNames = InputParser.parseCarNames(inputName);

        String inputRound = inputView.requestMaxRound();
        BigInteger round =  InputParser.

        CarFactory.createCars(carNames);
    }
}
