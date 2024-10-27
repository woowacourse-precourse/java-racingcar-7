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
        Car farthestCar = findFarthestCar();

        List<Car> farthestCarList = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.isSamePosition(farthestCar)) {
                farthestCarList.add(car);
            }
        }
        return new Cars(farthestCarList);
    }

    public Car findFarthestCar() {
        Car farthestCar = this.cars.getFirst();
        for (Car car : this.cars) {
            if (car.isMoreFar(farthestCar)) {
                farthestCar = car;
            }
        }
        return farthestCar;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.cars) {
            stringBuilder.append(car);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void printCarNames() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.cars) {
            stringBuilder.append(car.getName());
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        System.out.println(stringBuilder);
    }
}
