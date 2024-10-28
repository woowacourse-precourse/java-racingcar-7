package racingcar.model;

import java.util.*;

public class CarService {
    private List<String> carNames;
    private List<CarDto> cars = new ArrayList<>();
    private Map<String, Integer> repeatName = new HashMap<>();


    public CarService(List<String> carNames) {
        this.carNames = carNames;
    }


    private Boolean isOneName() {
        return carNames.size() == 1;
    }

    public Boolean isSameName() {
        for (String name : carNames) {
            if (Collections.frequency(carNames, name.trim()) > 1) return true;
        }

        return false;
    }

    public List<CarDto> createCar() {
        if (isOneName()) carNames.add("car");

        if (isSameName()) {
            carNames.forEach(this::changeCarId);
            return cars;
        }

        carNames.forEach(name -> cars.add(new CarDto(name.trim())));

        return cars;
    }

    private void changeCarId(String name) {
        int count = repeatName.getOrDefault(name, 0) + 1;
        repeatName.put(name, count);

        cars.add(new CarDto(name.trim(), count));
    }

    public static CarDto forwardMovement(CarDto car, int forward) {
        return new CarDto(car.getName(), car.getId(), forward);
    }
}
