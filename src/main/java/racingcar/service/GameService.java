package racingcar.service;

import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    public List<Car> createCarsList(String carNamesString) {
        String[] carNamesArray = splitCarNames(carNamesString);
        List<Car> cars = new ArrayList<>();

        for (String carName : carNamesArray) {
            carName = carName.trim();
            if (carNameValidator.validate(carName)) {
                Car car = createCar(carName);
                cars.add(car);
            }
        }

        return cars;
    }

    private String[] splitCarNames(String carNamesString) {
        return carNamesString.split(","); // 자동차 이름을 콤마로 분리
    }

    private Car createCar(String carName) {
        return new Car(carName); // 자동차 객체 생성
    }
}
