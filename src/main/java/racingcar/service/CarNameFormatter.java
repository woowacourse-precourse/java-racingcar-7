package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.validation.CarValidation.carValid;

public class CarNameFormatter {

    public static Cars formatCarNames(String carNamesInput) {
        String[] carNames = Arrays.stream(carNamesInput.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carValid(carList, carName);
            add(carList, carName);
        }

        return new Cars(carList);
    }

    private static void add(List<Car> carList, String carName) {
        carList.add(new Car(carName));
    }
}
