package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.TryCount;
import racingcar.model.Winner;
import racingcar.util.RaceResultStringGenerator;
import racingcar.util.RandomMoveNumberGenerator;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        Race race = setUpRace();
        raceCars(race);
        printWinner(race);
    }

    private Race setUpRace(){
        List<Car> cars = setUpCars();
        TryCount tryCount = setUpTryCount();
        Winner winner = new Winner();
        return new Race(cars, tryCount, winner, new RaceResultStringGenerator());
    }

    private List<Car> setUpCars(){
        outputView.printScanCarsMessage();
        List<Car> cars = new ArrayList<>();
        for (String carName : inputView.scanCarNames()) {
            cars.add(new Car(carName, new CarNameValidator()));
        }
        return cars;
    }

    private TryCount setUpTryCount(){
        outputView.printTryOutCountMessage();
        return new TryCount(inputView.scanTryCount(), new TryCountValidator());
    }

    private void raceCars(Race race) {
        outputView.printStartRaceMessage();
        String raceResult = race.startRace(new RandomMoveNumberGenerator());
        outputView.printRaceResult(raceResult);
    }

    private void printWinner(Race race) {
        outputView.printWinner(race.findWinner());
    }
}