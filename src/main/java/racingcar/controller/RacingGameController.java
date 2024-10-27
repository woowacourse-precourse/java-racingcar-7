package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.service.RegisterService;
import racingcar.service.RoundService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;

public class RacingGameController {
    private final RegisterService registerService;
    private final RoundService roundService;
    private final WinnerService winnerService;


    public RacingGameController(RegisterService registerService, RoundService roundService,
                                WinnerService winnerService) {
        this.registerService = registerService;
        this.roundService = roundService;
        this.winnerService = winnerService;
    }

    public void start() {
        String carNames = InputView.carNames();
        Cars cars = registerService.registerCars(carNames);

        Round round = setupRound();
        playRounds(round, cars);

        List<Car> winners = winnerService.getWinners(cars);
    }

    private Round setupRound() {
        String attemptCountInput = InputView.attemptCount();
        return new Round(attemptCountInput);
    }

    private void playRounds(Round round, Cars cars) {
        for (int i = 0; i < round.getAttemptCount(); i++) {
            roundService.playRound(cars);
        }
    }

}
