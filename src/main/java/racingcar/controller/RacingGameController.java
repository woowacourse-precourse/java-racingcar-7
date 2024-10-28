package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGameService racingGameService;

    private List<Car> cars;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
    }

    public void start() {

        String carNames = inputView.getCarNames();
        String rounds = inputView.getRounds();

        racingGameService.startGame(carNames, rounds);
        while (racingGameService.hasNextRound()) {
            racingGameService.playRound();
            List<Car> cars = racingGameService.getCurrentStatus();
            outputView.displayRoundResults(cars);
        }
        List<String> winners = racingGameService.getWinners();
        outputView.displayWinners(winners);
    }
}
