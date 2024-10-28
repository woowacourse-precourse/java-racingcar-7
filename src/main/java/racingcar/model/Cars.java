package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void updatePosition(final String carName) {
        for (Car car : cars) {
            if (car.getName().equals(carName)) {
                car.moveForward();
                break;
            }
        }
    }

    public Map<String, Integer> getPositions() {
        Map<String, Integer> positions = new LinkedHashMap<>();

        for (Car car : cars) {
            positions.put(car.getName(), car.getPosition());
        }

        return positions;
    }

}
