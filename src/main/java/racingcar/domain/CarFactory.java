package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private static List<String> carNames = new ArrayList<>();

    public CarFactory(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<Car> operateCarFactory() {
        int carsCount = carNames.size();
        List<Car> cars = new ArrayList<>(carsCount);

        for (int idx = 0; idx < carsCount; idx++) {
            cars.add(makeCar(carNames.get(idx)));
        }

        return cars;
    }

    private Car makeCar(String carName) {
        return new Car(carName);
    }
}
