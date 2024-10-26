package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carGroup;
    private static String SPLIT_SIGN = ",";

    public Cars(String racingCarNames) {
        this.carGroup = createCars(racingCarNames);
    }

    private String[] splitCarNames(String racingCarNames) {
        String[] carNames = racingCarNames.split(SPLIT_SIGN);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    private List<Car> createCars(String racingCarNames) {
        String[] carNames = splitCarNames(racingCarNames);
        List<Car> carGroup = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carGroup.add(car);
        }
        return carGroup;
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }
}
