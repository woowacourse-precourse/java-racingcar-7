package racingcar.model.entity;

import racingcar.model.dto.CarNames;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 자동차들을 콜렉션으로 저장한 클래스
 */
public final class Cars {

    private final Map<String, Car> cars;

    public Cars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public static Cars getInstance(CarNames names) {
        Map<String, Car> elements = new HashMap<>();
        for (String name : names) {
            elements.put(name, new Car(name));
        }
        return new Cars(elements);
    }

    public Car get(String name) {
        return cars.get(name);
    }

    public List<String> getMaxProgressCarsName() {
        int maxProgress = cars.values()
                .stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);

        return cars.values()
                .stream()
                .filter(car -> car.getProgress() == maxProgress)
                .map(Car::getName)
                .toList();
    }

}
