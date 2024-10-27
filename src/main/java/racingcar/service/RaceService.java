package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RaceService {

    private final static int VALIDATE_NEGATIVE_NUMBER = 0;

    public String[] splitCarNames(String carNames) {
        String[] splitNames = carNames.split(",");
        return splitNames;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> Cars = new ArrayList<>();
        for (String name : carNames) {
            Cars.add(new Car(name));
        }
        return Cars;
    }



    public static boolean validateTryCount(int tryCount) {
        if (tryCount < VALIDATE_NEGATIVE_NUMBER) {
            return false;
        }
        return true;
    }
}
