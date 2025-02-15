package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRace;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomGenerator randomGenerator;

    public CarRaceController(InputView inputView, OutputView outputView, RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomGenerator = randomGenerator;
    }

    public void run(){
        List<String> carNames = inputView.inputCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        int attempts = inputView.inputCount();

        CarRace carRace = new CarRace(cars, new RandomGeneratorImpl());

        for (int i = 0; i < attempts; i++) {
            carRace.runRace();
            outputView.printRaceProgress(cars);
        }

        List<String> winners = carRace.getWinners();
        outputView.printWinners(winners);
    }
}
