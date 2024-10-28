package racingcar.racing.presentation;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.racing.domain.Car;
import racingcar.racing.domain.RacingGame;
import racingcar.racing.domain.dto.CarRoundResult;
import racingcar.racing.common.InputParser;
import racingcar.racing.common.InputValidator;
import racingcar.racing.presentation.view.InputView;
import racingcar.racing.presentation.view.OutputView;

public class RacingGameManager {
    private RacingGame racingGame;

    public void run() {
        List<String> carNames = getCarNames();
        int attemptNumber = getAttemptNumber();
        createRacingGame(attemptNumber, carNames);
        List<List<CarRoundResult>> allRoundResult = racingGame.start();
        OutputView.printAllRoundResult(allRoundResult);
        List<Car> winners = racingGame.selectWinners();
        OutputView.printWinner(winners);
        Console.close();
    }

    private void createRacingGame(int attemptNumber, List<String> carNames) {
        this.racingGame = RacingGame.of(attemptNumber, carNames);
    }

    private int getAttemptNumber() {
        String inputAttemptNumber = InputView.inputConsole("시도할 횟수는 몇 회인가요?");
        InputValidator.validateInputNotEmpty(inputAttemptNumber);
        int attemptNumber = InputParser.parseAttemptNumber(inputAttemptNumber);
        InputValidator.validateAttemptNumber(attemptNumber);
        return attemptNumber;
    }

    private List<String> getCarNames() {
        String inputCar = InputView.inputConsole("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        InputValidator.validateInputNotEmpty(inputCar);
        List<String> carNames = InputParser.parseCarNames(inputCar);
        InputValidator.validateCarNameLength(carNames);
        InputValidator.validateCarArrayNotEmpty(carNames);
        return carNames;
    }
}
