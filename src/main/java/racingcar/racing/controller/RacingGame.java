package racingcar.racing.controller;

import java.util.List;
import racingcar.racing.model.Car;
import racingcar.racing.model.Game;
import racingcar.racing.model.RacingGameConcreteFactory;
import racingcar.racing.utils.InputParser;
import racingcar.racing.view.InputView;
import racingcar.racing.view.OutputView;

public class RacingGame {
    private final RacingGameConcreteFactory racingGameFactory;
    private Game game;

    public RacingGame(RacingGameConcreteFactory racingGameFactory) {
        this.racingGameFactory = racingGameFactory;
    }

    public void start() {
        List<String> carNames = inputCarNames();
        int attemptNumber = inputAttemptNumber();
        createRacingGame(carNames, attemptNumber);
        OutputView.printMessage("\n실행 결과");
        game.allRoundStart();
        List<Car> winners = game.selectWinners();
        OutputView.printWinner(winners);
    }

    private void createRacingGame(List<String> carNames, int attemptNumber) {
        List<Car> cars = racingGameFactory.createCars(carNames);
        this.game = racingGameFactory.createGame(attemptNumber, cars);
    }

    private int inputAttemptNumber() {
        OutputView.printMessage("시도할 횟수는 몇 회인가요?");

        String inputAttemptNumber = InputView.inputConsole(true);
        // todo: inputAttemptNumber가 숫자가 아닐 경우 예외처리
        try {
            int attemptNumber = Integer.parseInt(inputAttemptNumber);
            if (!InputValidator.validateAttemptNumber(attemptNumber)) {
                throw new IllegalArgumentException("시도할 횟수는 양의 정수로 입력해주세요.");
            }
            return attemptNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수로 입력해주세요.");
        }
    }

    private List<String> inputCarNames() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputCar = InputView.inputConsole(false);
        List<String> carNames = InputParser.parseCarNames(inputCar);
        if (!InputValidator.validateCarNameLength(carNames)) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
        }
        // todo: carNames가 비었을 때 예외처리
        return carNames;
    }

}
