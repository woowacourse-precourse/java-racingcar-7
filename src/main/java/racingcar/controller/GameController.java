package racingcar.controller;

import racingcar.domain.Car;
import racingcar.validation.BlankNameValidator;
import racingcar.validation.NameLengthValidator;
import racingcar.validation.TrialTimesValidator;
import racingcar.view.InputView;

import java.util.ArrayList;

public class GameController {

    public static void run() {
        ArrayList<String> carNames = InputView.getCarNames();
        String trialTimes = InputView.getTrialTimes();
        validateNameInput(carNames);
        validateTrialTimesInput(trialTimes);

        ArrayList<Car> carList = registerCars(carNames);
    }

    private static void validateNameInput(ArrayList<String> carNames) {
        BlankNameValidator.validate(carNames);
        NameLengthValidator.validate(carNames);
    }

    private static void validateTrialTimesInput(String trialTimes) {
        TrialTimesValidator.validate(trialTimes);
    }

    private static ArrayList<Car> registerCars(ArrayList<String> carNames) {
        ArrayList<Car> carList = new ArrayList<>();
        fillCarList(carNames, carList);

        return carList;
    }

    private static void fillCarList(ArrayList<String> carNames, ArrayList<Car> carList)  {
        for(String carName : carNames) {
            carList.add(Car.registerCarNameFrom(carName));
        }
    }
}
