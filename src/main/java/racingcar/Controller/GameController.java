package racingcar.Controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.result.ResultCalculator;
import racingcar.service.RacingGameService;
import racingcar.util.Validator;

public class GameController {
    private List<Car> cars;
    private final RacingGameService racingGameService = new RacingGameService();
    private final ResultCalculator resultCalculator = new ResultCalculator();

    public void startGame() {
        setupCars();
        int roundCount = getRoundCount();
        runRounds(roundCount);
        endGame();
    }

    private void setupCars() {
        String carNamesInput = InputView.InputCarNames();
        List<String> carNames = parseCarNames(carNamesInput);
        cars = createCarList(carNames);
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        Validator.checkCarNameLength(carNames);
        Validator.checkCarNamesUnique(carNames);
    }

    private List<Car> createCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private int getRoundCount() {
        int roundCount = InputView.InputRoundNumber();
        validateRoundCount(roundCount);
        return roundCount;
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void runRounds(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            racingGameService.runRound(cars);
            OutputView.printRoundResults(cars);
        }
    }

    public void endGame() {
        List<String> winners = resultCalculator.determineWinners(cars);
        OutputView.printWinners(winners);
    }
}
