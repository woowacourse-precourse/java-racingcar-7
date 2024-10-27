package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Cars findFarthestCars() {
        List<Car> farthestCarList = new ArrayList<>();
        Car farthestCar = this.cars.getFirst();
        for (Car car : this.cars) {
            if (car.isMoreFar(farthestCar)) {
                farthestCar = car;
            }
        }
        for (Car car : this.cars) {
            if (car.isSamePosition(farthestCar)) {
                farthestCarList.add(car);
            }
        }
        return new Cars(farthestCarList);
    }

    public void printCar() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.cars) {
            stringBuilder.append(car);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

}
