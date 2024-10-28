package racingcar.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    private final String CAR_DELIMITER = ",";

    public List<Car> createCar(String raceCar) {
        List<Car> cars = new ArrayList<>();
        List<String> raceCars = Arrays.asList(raceCar.split(CAR_DELIMITER));

        for (String carName : raceCars) {
            validateName(carName);
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void validateName(String carName) {
        if (!isUsableName(carName)) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
        }
    }

    public boolean isUsableName(String carName) {
        return carName.length() <= 5;
    }


    public void countTotalMove() {
        // 움직인 자동차 개수 세기
    }
}
