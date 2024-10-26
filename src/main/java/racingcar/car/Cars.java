package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

//    public Cars(List<Car> cars) {
//        this.cars = cars;
//    }

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = findMaxDistance();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
        return maxDistance;
    }
}
