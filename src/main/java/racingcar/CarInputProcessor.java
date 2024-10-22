package racingcar;

import racingcar.utils.IOUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarInputProcessor {
    CarNameValidator carNameValidator;

    public CarInputProcessor(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public List<Car> getCars() {
        String userInput = getCarsFromUser();
        String[] splitUserInput = splitCarsByComma(userInput);
        return returnValidatedCars(splitUserInput);
    }

    private String getCarsFromUser() {
        return IOUtils.input();
    }

    private String[] splitCarsByComma(String userInput) {
        return userInput.split(",");
    }

    private List<Car> returnValidatedCars(String[] splitUserInput) {
        List<Car> cars = new ArrayList<>();
        HashSet<String> carsToCheckDuplicate = new HashSet<>();

        for (String input : splitUserInput) {
            String carName = input.trim();
            carNameValidator.checkIsCarNameValid(carName, carsToCheckDuplicate);
            cars.add(new Car(carName));
        }

        return cars;
    }
}
