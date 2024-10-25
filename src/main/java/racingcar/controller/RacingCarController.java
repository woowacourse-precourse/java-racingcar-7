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

        OutputView.printExecutionResultMessage(); // 실행 결과 메시지 출력
        for (int i = 0; i < rounds; i++) {
            game.playRound();
            OutputView.printRoundResult(game.getCars()); // 각 라운드 결과 출력
        }
    }
}
