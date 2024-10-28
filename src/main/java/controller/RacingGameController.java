package controller;

import model.Cars;
import service.RacingGameService;
import util.splitter.CarNameSplitter;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameSplitter carNameSplitter;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, CarNameSplitter carNameSplitter, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameSplitter = carNameSplitter;
        this.racingGameService = racingGameService;
    }

    public void run() {
        String inputNames = inputView.getCarName();
        List<String> carNames = carNameSplitter.splitCarNames(inputNames);

        Cars cars = new Cars(carNames);

        int rounds = inputView.getRaceCount();

        racingGameService.startRace(cars, rounds);

        List<String> winners = racingGameService.getWinners(cars);
        outputView.printWinners(winners);
    }
}
