package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private final List<Car> cars;

    public Game(List<String> carNames) {
        validateDuplicateNames(carNames);
        cars = createCars(carNames);
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }


    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름 존재");
        }
    }

}
