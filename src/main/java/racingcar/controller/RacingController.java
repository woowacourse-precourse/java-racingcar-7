package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarNameParser;
import racingcar.domain.Cars;
import racingcar.domain.RacingChance;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private static final int START_NUMBER = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingController(InputView inputView, OutputView outputView, RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        Cars cars = makeCars();
        RacingChance racingChance = getChance();
        outputView.raceGuide();
        raceRoundsByChance(cars, racingChance);
        findWinner(cars);
    }

    private void findWinner(Cars cars) {
        outputView.findWinner(cars.getWinner());
    }

    private void raceRoundsByChance(Cars cars, RacingChance racingChance) {
        for (int i = START_NUMBER; i < racingChance.getRacingChance(); i++) {
            raceOneRound(cars);
        }
    }

    private void raceOneRound(Cars cars) {
        for (Car car : cars.getCars()) {
            car.moveCar(randomNumberGenerator.generateRandomNumber());
            outputView.raceResult(car.getCarName().getCarName(), car.getPosition());
        }

        outputView.separateLine();
    }

    private Cars makeCars() {
        return new Cars(getCarNames());
    }

    private List<CarName> getCarNames() {
        outputView.getCarNames();
        return CarNameParser.parseCarNames(inputView.getCarName());
    }

    private RacingChance getChance() {
        outputView.getRacingChance();
        return new RacingChance(inputView.getRacingChance());
    }
}
