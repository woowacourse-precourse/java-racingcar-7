package racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import racingcar.validation.NameValidator;

public class Cars implements Iterable<Car> {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void createCars(List<String> nameList) {
        NameValidator.validateNames(nameList);
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
