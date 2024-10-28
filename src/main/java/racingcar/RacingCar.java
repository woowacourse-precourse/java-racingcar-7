package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarGenerator;
import racingcar.domain.car.Cars;
import racingcar.domain.car.RandomEngine;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

public class RacingCar {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        List<String> carNames = inputView.readCarNames();
        IntSupplier engine = RandomEngine.getEngine();
        Cars cars = CarGenerator.generateCars(carNames, engine);

        int round = inputView.readRound();
        RaceService raceService = new RaceService(cars, round);

        List<Map<Car, Integer>> raceLogs = raceService.createRaceLogs();
        outputView.printRaceResult(raceLogs);

        List<Car> winners = raceService.getWinners();
        outputView.printNames(winners);
    }
}
