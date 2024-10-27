package controller;

import model.Car;
import service.RacingGameService;
import view.InputView;
import view.PlayView;
import view.ResultView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final PlayView playView = new PlayView();
    private final ResultView resultView = new ResultView();
    private final RacingGameService racingGameService = new RacingGameService();

    public void play(){
        String names = inputView.carNameInput();
        List<Car> cars = racingGameService.splitCarsName(names);
        int attempts = racingGameService.validationRange(inputView.numberOfAttemptsInput());

        for (int i = 0; i < attempts; i++) {
            racingGameService.racing(cars);
            playView.playResult(cars);
        }

        List<String> winners = racingGameService.findWinners(cars);
        resultView.getWinners(winners);
    }
}
