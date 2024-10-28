package racingcar.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    private final String CAR_DELIMITER = ",";

    public List<Car> createCar(String raceCar) {
        List<Car> cars = new ArrayList<>();
        List<String> raceCars = Arrays.asList(raceCar.split(CAR_DELIMITER));

        for (String car : raceCars) {
            cars.add(new Car(car));
        }

        return cars;
    }

    public void validateName(String car) {
    }

    public boolean isUsableName(/*자동차 이름*/) {
        // 이름 5자 이하면 true 반환
        return false;
    }


    public void countTotalMove() {
        // 움직인 자동차 개수 세기
    }
}
