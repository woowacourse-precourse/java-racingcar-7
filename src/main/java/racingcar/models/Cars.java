package racingcar.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new ArrayList<>();
        addToCars(carNames);
    }

    public void incrementDistance() {
        for (Car car : this.cars) {
            car.incrementDistance();
        }
    }

    public Map<String, Integer> getInformation() {
        Map<String, Integer> carsInfo = new HashMap<>();
        for (Car car : this.cars) {
            carsInfo.put(car.getName(), car.getDistance());
        }
        return carsInfo;
    }

    private void addToCars(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName.trim()));
        }
    }
}