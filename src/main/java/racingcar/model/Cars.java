package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new ArrayList<>();
        initCars(carNames);
    }

    public void requestCarMove() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private void initCars(List<String> carNames) {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        for (String carName : carNames) {
            Car car = new Car(carName, randomIntGenerator);
            cars.add(car);
        }
    }

    // TODO: 가장 멀리 간 자동차의 이동 거리를 반환한다.
}