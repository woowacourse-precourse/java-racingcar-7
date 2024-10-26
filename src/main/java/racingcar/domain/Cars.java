package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Cars {
    private final Set<Car> cars;

    public Cars(Set<Car> cars) {
        validateNumberOfCars(cars);
        this.cars = cars;
    }

    public Set<Car> getCars() {
        return cars;
    }

    //todo 더 좋은 방법 없을까?
    public List<Car> getWinningCar() {
        List<Car> winningCars = new ArrayList<>();
        int winningDistanceScore = getHighestDistance();

        for (Car car : cars) {
            if (car.getDistance() == winningDistanceScore) {
                winningCars.add(car);
            }
        }
        return winningCars;
    }

    private int getHighestDistance() {
        List<Integer> distances = new ArrayList<>();
        for (Car car : cars) {
            distances.add(car.getDistance());
        }
        return Collections.max(distances);
    }

    private void validateNumberOfCars(Set<Car> cars) {
        if (cars.size() > 50) {
            throw new IllegalArgumentException("자동차는 최대 50대까지만 입력 가능합니다.");
        }
    }


}
