package racingcar.controller;


import racingcar.model.Car;
import racingcar.model.CarRacing;
import racingcar.utils.Engine;
import racingcar.utils.RandomEngine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        // run 쪼개기
        outputView.printReadCarNameMessage();
        String readCarString = inputView.readInput();
        inputView.parserInputString(readCarString);

        List<Car> cars = createCars(inputView.getParserInputString());

        outputView.printReadTotalTryMessage();
        String totalRacingCounter = inputView.readInput();

        startCarRacing(cars, totalRacingCounter);
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

    private void startCarRacing(List<Car> cars, String totalRacingCounter) {
        CarRacing carRacing = new CarRacing(cars, totalRacingCounter);
        carRacing.startRacing();
    }

}
