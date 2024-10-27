package controller;

import model.Car;
import model.Cars;
import service.RacingGameService;
import util.splitter.CarNameSplitter;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameSplitter carNameSplitter;
    private final RacingGameService raceService;

    public RacingGameController(InputView inputView, OutputView outputView, CarNameSplitter carNameSplitter, RacingGameService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameSplitter = carNameSplitter;
        this.raceService = raceService;
    }

    public void run() {
        String inputNames = inputView.getCarName();
        List<String> carNames = carNameSplitter.splitCarNames(inputNames);

        Cars cars = new Cars(carNames.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList()));

        int rounds = inputView.getRaceCount();

        raceService.startRace(cars, rounds);

        List<String> winners = raceService.getWinners(cars);
        outputView.printWinners(winners);
    }
}
