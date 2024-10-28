package racingcar.controller;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.Race;
import racingcar.model.car.CarGenerator;
import racingcar.model.dto.RacingUnitResultList;
import racingcar.view.InputView;

public class RacingController {

    InputView inputView = new InputView();
    CarGenerator carGenerator = new CarGenerator();

    public void runRace() {
        String carInput = getCarInput();
        int countInput = getCountInput();

        Race race = generateRace(carInput, countInput);
        RacingUnitResultList racingUnitResultList = race.proceedRace();
    }

    private int getCountInput() {
        inputView.printCountInput();
        return inputView.getIntegerInput();
    }

    private String getCarInput() {
        inputView.printCarInput();
        return inputView.getStringInput();
    }

    private Cars generateCars(String carInput) {
        List<String> carNames = carGenerator.extractCarNames(carInput);
        return carGenerator.generateCars(carNames);
    }

    private Race generateRace(String carInput, int countInput) {
        Cars cars = generateCars(carInput);
        return new Race(countInput, cars);
    }
}
