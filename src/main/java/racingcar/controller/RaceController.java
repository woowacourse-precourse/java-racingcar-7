package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarService;
import racingcar.model.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RaceController {
    private final StringParser stringParser;
    private final CarService carService;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(StringParser stringParser, CarService carService, InputView inputView,
                          OutputView outputView) {
        this.stringParser = stringParser;
        this.carService = carService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void race() {
        String userInput = inputView.readRawCarNames();
        List<String> carNames = stringParser.findCarNames(userInput);
        List<Car> cars = carService.createCars(carNames);

        Integer attempt = inputView.readAttemptCount();
        IntStream.range(0, attempt).forEach(i -> {
            cars.forEach(carService::moveForward);
            outputView.printEachTime(cars);
        });
        outputView.printWinner(carService.findWinner(cars));
    }
}
