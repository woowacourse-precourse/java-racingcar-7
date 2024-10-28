package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRacing;
import racingcar.utils.CarRacingValidator;
import racingcar.utils.Engine;
import racingcar.utils.RandomEngine;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {

    private final InputView inputView;
    private final OutputView outputView;
    Validator validator = new CarRacingValidator();

    public CarRacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Car> cars = initializeCars();
        int totalRacingCounter = getTotalRacingCounter();

        CarRacing carRacing = new CarRacing(cars);
        outputView.printRunResult();
        executeRaces(carRacing, totalRacingCounter);

        List<String> winners = carRacing.getWinner();
        outputView.printWinners(winners);
    }

    private List<Car> initializeCars() {
        outputView.printReadCarNameMessage();

        String readCarString = inputView.readInput();
        inputView.parserInputString(readCarString);

        return createCars(inputView.getParserInputString());
    }

    private int getTotalRacingCounter() {
        outputView.printReadTotalTryMessage();

        String readTotalTryString = inputView.readInput();
        validator.validation(readTotalTryString);

        return Integer.parseInt(readTotalTryString);
    }

    private void executeRaces(CarRacing carRacing, int totalRacingCounter) {
        for (int i = 0; i < totalRacingCounter; i++) {
            carRacing.startRacing();
        }
    }

    private List<Car> createCars(ArrayList<String> carNameList) {
        Engine randomEngine = new RandomEngine();
        List<Car> cars = new ArrayList<>();

        for (String carName : carNameList) {
            Car car = new Car(carName, randomEngine);
            cars.add(car);
        }

        return cars;
    }
}
