package racingcar.car;

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
        IOUtils.outputStringWithEnter("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = IOUtils.input();
        carInputValidator.checkIsAllInputEmpty(carInput);
        return carInput;
    }

    private String[] splitCarsByComma(String userInput) {
        return userInput.split(",");
    }

    protected List<Car> returnValidatedCars(String[] splitUserInput) {
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
