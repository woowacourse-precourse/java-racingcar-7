package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class CarService {
    private static final int BASE_DISTANCE = 0;

    private final Set<Car> uniqueCars = new LinkedHashSet<>();

    public void addCar(String carName){
        Car car = new Car(carName, BASE_DISTANCE);
        if(!uniqueCars.add(car)){
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름을 추가할 수 없습니다.");
        }
    }

    public void addCar(String carName, int distance) {
        Car car = new Car(carName, distance);
        if (!uniqueCars.add(car)) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름을 추가할 수 없습니다.");
        }
    }

    public List<Car> moveAllCars() {
        uniqueCars.forEach(Car::move);
        return uniqueCars.stream().toList();
    }

    public List<String> getCarsWithMaxDistance() {
        int maxDistance = calculateMaxDistance();
        return uniqueCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int calculateMaxDistance() {
        return uniqueCars.stream().mapToInt(Car::getDistance).max().orElse(BASE_DISTANCE);
    }

}