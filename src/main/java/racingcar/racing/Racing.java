package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.view.Request;


public class Racing {

    final String CAR_NAME_DELIMITER = ",";
    final int MAX_CAR_NAME = 5;

    public void start() {
        List<String> carNameList = inputCars();
        validateCars(carNameList);
        List<Car> carList = createCars(carNameList);
        int tryCount = inputTryCount();
    }

    public List<String> inputCars() {
        String carNames = Request.inputCar();
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    public void validateCars(List<String> carNameList) {
        for(String name : carNameList) {
            if(name.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException("자동차 이름이 5자를 넘습니다.");
            }
        }
    }

    public List<Car> createCars(List<String> carNameList) {

        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int inputTryCount() {
        String tryCount = Request.inputTryCount();
        return Integer.parseInt(tryCount);
    }

}
