package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.view.Request;


public class Racing {

    final String CAR_NAME_DELIMITER = ",";
    final int MAX_CAR_NAME = 5;

    private List<Car> carList;

    private int tryCount;

    public void start() {
        List<String> carNameList = inputCars();
        validateCars(carNameList);
        createCars(carNameList);
        inputTryCount();
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

    public void createCars(List<String> carNameList) {
        carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void inputTryCount() {
        String tryCountString = Request.inputTryCount();
        tryCount = Integer.parseInt(tryCountString);
    }

}
