package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.Race;
import racingcar.model.car.CarGenerator;
import racingcar.model.dto.RacingUnitResult;
import racingcar.model.dto.RacingUnitResultList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CarGenerator carGenerator = new CarGenerator();

    public void runRace() {
        String carInput = getCarInput();
        int countInput = getCountInput();

        Race race = generateRace(carInput, countInput);
        RacingUnitResultList racingUnitResultList = race.proceedRace();

        generateUnitResults(racingUnitResultList);
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

    private void generateUnitResults(RacingUnitResultList racingUnitResultList) {
        outputView.printResultTitleView();

        for (RacingUnitResult unitResult : racingUnitResultList.getRacingUnitResultList()) {
            Map<Car, Integer> resultInfo = unitResult.getResult();
            outputView.printUnitResult(resultInfo);
        }
    }

}
