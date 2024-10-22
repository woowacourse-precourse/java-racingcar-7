package racingcar;

import racingcar.utils.IOUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarInputService {
    CarInputValidator carInputValidator;

    public CarInputService(CarInputValidator carInputValidator) {
        this.carInputValidator = carInputValidator;
    }

    public List<Car> getCars() {
        String carInput = getCarsFromUser();
        String[] splitUserInput = splitCarsByComma(carInput);
        return returnValidatedCars(splitUserInput);
    }

    private String getCarsFromUser() {
        String carInput = IOUtils.input();
        carInputValidator.checkIsCarInputEmpty(carInput);
        return carInput;
    }

    private String[] splitCarsByComma(String userInput) {
        return userInput.split(",");
    }

    private List<Car> returnValidatedCars(String[] splitUserInput) {
        List<Car> cars = new ArrayList<>();
        HashSet<String> carsToCheckDuplicate = new HashSet<>();

        for (String input : splitUserInput) {
            String carName = input.trim();
            carInputValidator.checkIsCarNameValid(carName, carsToCheckDuplicate);
            cars.add(new Car(carName));
            carsToCheckDuplicate.add(carName);
        }

        return cars;
    }
}
