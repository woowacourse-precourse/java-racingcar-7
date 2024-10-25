package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    public void startGame() {
        List<String> carNames = InputView.getCarNames();
        InputValidator.validateCarNames(carNames);

        int rounds = InputView.getRounds();
        InputValidator.validateRounds(rounds);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        RacingGame game = new RacingGame(cars, rounds);

        OutputView.printExecutionResultMessage();
        for (int i = 0; i < rounds; i++) {
            game.playRound();
            OutputView.printRoundResult(game.getCars());
        }

        // 최종 우승자 출력
        List<Car> winners = game.getWinners();
        OutputView.printWinners(winners);
    }
}
