package racingcar.car.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.car.dto.CarRequest;
import racingcar.global.constants.CarConstants;

public class CarService {

    public ArrayList<String> enterCarName() {
        CarRequest carRequest = new CarRequest();
        String car = carRequest.enterCarNameString();
        if (!carNameStringValidation(car))
            throw new IllegalArgumentException();
        return Arrays.stream(car.split(","))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean carNameStringValidation(String carName) {
        if (!Pattern.matches(CarConstants.CAR_NAME_STRING_VALIDATION, carName)) {
            throw new IllegalArgumentException(CarConstants.CAR_NAME_ENTER_ERROR_MESSAGE);
        }
        return true;
    }
}
