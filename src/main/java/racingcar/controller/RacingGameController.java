package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.RandomMovementStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    public void run() {
        List<Car> cars = createCars();
        int totalRounds = InputView.promptForTotalRounds();
        RacingGame game = new RacingGame(cars, totalRounds, new RandomMovementStrategy());

        System.out.println("실행 결과");
        playRounds(game);
        declareWinners(game);
    }

    private List<Car> createCars() {
        return InputView.promptForCarNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void playRounds(RacingGame game) {
        for (int i = 0; i < game.getTotalRounds(); i++) {
            game.executeRound();
            OutputView.displayRoundResults(game.getCars());
        }
    }

    private void declareWinners(RacingGame game) {
        String winners = game.determineWinners();
        OutputView.displayWinners(winners);
    }
}
