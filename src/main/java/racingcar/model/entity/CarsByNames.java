package racingcar.model.entity;

import racingcar.model.dto.CarNames;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 자동차들을 콜렉션으로 저장한 클래스
 */
public final class CarsByNames {

    private final Map<String, Car> carsByNames;

    public CarsByNames(Map<String, Car> carsByNames) {
        this.carsByNames = carsByNames;
    }

    public static CarsByNames getInstance(CarNames names) {
        Map<String, Car> elements = new HashMap<>();
        for (String name : names) {
            elements.put(name, new Car(name));
        }
        return new CarsByNames(elements);
    }

    public Car get(String name) {
        return carsByNames.get(name);
    }

    public List<String> getMaxProgressCarsName() {
        int maxProgress = carsByNames.values()
                .stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);

        return carsByNames.values()
                .stream()
                .filter(car -> car.getProgress() == maxProgress)
                .map(Car::getName)
                .toList();
    }

}
