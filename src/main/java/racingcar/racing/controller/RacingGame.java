package racingcar.racing.controller;

import java.util.List;
import racingcar.racing.model.Car;
import racingcar.racing.model.Game;
import racingcar.racing.model.RacingGameConcreteFactory;
import racingcar.racing.model.Winner;
import racingcar.racing.utils.InputParser;
import racingcar.racing.view.InputView;
import racingcar.racing.view.OutputView;

public class RacingGame {
    private final RacingGameConcreteFactory racingGameFactory;
    private Game game;
    private List<Car> cars;
    private Winner winner;

    public RacingGame(RacingGameConcreteFactory racingGameFactory) {
        this.racingGameFactory = racingGameFactory;
    }

    public void start() {
        List<String> carNames = inputCarNames();
        int attemptNumber = inputAttemptNumber();

        this.game = racingGameFactory.createGame(attemptNumber);
    }

    private int inputAttemptNumber() {
        OutputView.print("시도할 횟수는 몇 회인가요?");
        String inputAttemptNumber = InputView.inputConsole(true);
        int attemptNumber = Integer.parseInt(inputAttemptNumber);
        if (InputValidator.validateAttemptNumber(attemptNumber)) {
            throw new IllegalArgumentException("");
        }
        return attemptNumber;
    }


    private List<String> inputCarNames() {
        OutputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = InputView.inputConsole(false);
        List<String> carNames = InputParser.parseCarNames(inputCar);
        if (InputValidator.validateCarNameLength(carNames)) {
            throw new IllegalArgumentException("");
        }
        return carNames;
    }


}
