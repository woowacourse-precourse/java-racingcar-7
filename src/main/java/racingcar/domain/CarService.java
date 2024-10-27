package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarService {
    private static final int CAR_MOVE_CONDITION = 4;

    public void moveCarsIfConditionMet(List<Car> cars) {
        for (Car car : cars) {
            if (RandomNumber.getRandomNumber() >= CAR_MOVE_CONDITION) {
                car.move();
            }
        }
    }

    public List<Car> makeCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getWinners(List<Car> cars) {
        Optional<Integer> maxDistanceOptional = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo);

        int maxDistance = maxDistanceOptional.get();

        return cars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .toList();
    }

}
