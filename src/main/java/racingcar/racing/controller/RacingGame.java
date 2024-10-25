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
        // todo: inputAttemptNumber이 digit이 아닐 때 처리
        int attemptNumber = Integer.parseInt(inputAttemptNumber);
        if (validateAttemptNumber(attemptNumber)) {
            // todo: 예외처리
        }
        return attemptNumber;
    }

    private boolean validateAttemptNumber(int attemptNumber) {
        if (attemptNumber <= 0) {
            return true;
        }
        return false;
    }

    private List<String> inputCarNames() {
        OutputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = InputView.inputConsole(false);

        List<String> carNames = InputParser.parseCarNames(inputCar);
        if (validateCarNameLength(carNames)) {
            // todo: 예외처리
        }
        return carNames;
    }

    private boolean validateCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
