package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    public void run() {
        try {
            List<Car> cars = InputView.getCarNames().stream()
                    .map(Car::new)
                    .collect(Collectors.toList());

            int attempts = InputView.getAttempts();
            RacingGame game = new RacingGame(cars, attempts);

            System.out.println("실행 결과");
            for (int i = 0; i < game.getAttempts(); i++) {
                game.playRound();
                OutputView.printRoundStatus(game.getCars());
            }

            String winners = game.findWinners();
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
