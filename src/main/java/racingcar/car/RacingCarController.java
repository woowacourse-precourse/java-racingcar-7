package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.Request;

public class RacingCarController {
    private static final String CAR_NAME_DELIMITER = ",";

    public List<Car> registerRacingCars() {
        List<String> carNameList = inputCarsName();
        validateCarsName(carNameList);
        return createCars(carNameList);
    }

    private List<String> inputCarsName() {
        String carNames = Request.inputCar();
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    private void validateCarsName(List<String> carNameList) {
        for (String name : carNameList) {
            CarValidator.carNameEmpty(name);
            CarValidator.carNameLength(name);
        }
    }

    private List<Car> createCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
