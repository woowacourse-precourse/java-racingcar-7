package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.validation.CarNamesValidation;

public class CarNameParser {

    public static List<String> parseCarName(String input) {
        return Arrays.stream(input.replaceAll(" ","").split(",")).toList();
    }

    public static Cars createCars(List<String> carNames){
        Cars cars = new Cars();
        for (String car: carNames){
            CarNamesValidation.validateCarName(car);
            cars.addCar(createCar(car));
        }
        return cars;
    }

    private static Car createCar(String carName){
        return new Car(carName);
    }
}
