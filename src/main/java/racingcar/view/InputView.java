package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;


public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    public List<Car> readCarNames() {
        String inputCarNames = Console.readLine();
        InputValidator.validateEmptyInput(inputCarNames);
        String[] carsArray = inputCarNames.split(CAR_NAME_DELIMITER);

        validateAllCarNames(carsArray);

        List<Car> carList = convertToCarList(carsArray);

        InputValidator.validateCarCounts(carList);

        return carList;
    }

    public int inputAttemptCount() {
        String inputAttemptCount = Console.readLine();
        InputValidator.validateAttemptCountIsNumber(inputAttemptCount);

        return Integer.parseInt(inputAttemptCount);
    }

    private void validateAllCarNames(String[] carsArray) {
        for (String car : carsArray) {
            InputValidator.validateCarNameLength(car);
        }
    }

    private List<Car> convertToCarList(String[] cars) {
        List<Car> carList = new ArrayList<>();

        for (String carName : cars) {
            Car targetCar = new Car(carName);
            InputValidator.validateDuplicateCarName(carList, targetCar);
            carList.add(targetCar);
        }

        return carList;
    }
}