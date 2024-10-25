package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final Map<String, Car> carMap = new HashMap<>();

    public Cars(List<String> carNames) {
        for (String name : carNames) {
            carMap.put(name, new Car(name));
        }
    }

    public void updateCarPosition(String carName) {
        Car car = carMap.get(carName);
        if (carName != null) {
            car.moveForward();
        }
    }

    public Map<String, Integer> getCarPositions() {
        Map<String, Integer> positions = new HashMap<>();
        for (Car car : carMap.values()) {
            positions.put(car.getName(), car.getPosition());
        }
        return positions;
    }

}
