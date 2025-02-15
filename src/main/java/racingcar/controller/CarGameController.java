package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.CarCreateService;
import racingcar.service.CarGameService;
import racingcar.view.Inputview;
import racingcar.view.OutputView;

public class CarGameController {

    private final CarGameService carGameService;
    private final CarCreateService carCreateService;
    private final Inputview inputView;
    private final OutputView outputView;

    public CarGameController(CarGameService carGameService, CarCreateService carCreateService,
        Inputview inputView, OutputView outputView) {
        this.carGameService = carGameService;
        this.carCreateService = carCreateService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carNames = getCarNames();
        Cars cars = carCreateService.fromString(carNames);
        int rounds = getRounds();

        outputView.announceResult();
        carGameService.play(cars, rounds, (updatedCars) -> {
            outputView.printCarPositions(updatedCars);
        });
        Cars winners = carGameService.findWinners(cars);

        outputView.printWinners(winners);
    }

    private String getCarNames() {
        outputView.requireCarNames();
        return inputView.inputCarNames();
    }

    private int getRounds() {
        outputView.requireRound();
        return inputView.inputRound();
    }

}
