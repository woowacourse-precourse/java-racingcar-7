package racingcar.model.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        validateUniqueName(names);

        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateUniqueName(String[] names) {
        Set<String> uniqueNames = new HashSet<>(List.of(names));

        if (names.length != uniqueNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public boolean hasFewerNumberOfCarsThan(int minimumNumberOfCars) {
        return cars.size() < minimumNumberOfCars;
    }

    public List<CarStatus> getStatus() {
        return cars.stream().map(car -> new CarStatus(car.getName(), car.getPosition())).toList();
    }

    public int getSize() {
        return cars.size();
    }

    public void move(int index) {
        cars.get(index).move();
    }

    public List<Car> getMaxPositionCars() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("등록된 차량이 없습니다."));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
