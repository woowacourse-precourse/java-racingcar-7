package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int getSize() {
        return cars.size();
    }

    public Cars getWinners() {
        List<Car> winnerList = new ArrayList<>();

        int maxPos = Collections.max(cars).getPos();
        for (Car car : cars) {
            if (car.getPos() == maxPos) {
                winnerList.add(car);
            }
        }

        return new Cars(winnerList);
    }
}
