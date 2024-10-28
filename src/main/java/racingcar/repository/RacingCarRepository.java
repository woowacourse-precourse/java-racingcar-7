package racingcar.repository;

import racingcar.model.Car;
import racingcar.model.TryCount;

import java.math.BigInteger;
import java.util.ArrayList;

public class RacingCarRepository {
    ArrayList<Car> cars;
    TryCount tryCount;

    public RacingCarRepository() {
        this.cars = new ArrayList<>();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(String carName) {
        this.cars.add(new Car(carName, BigInteger.ZERO));
    }

    public void plusValue(int idx) {
        Car car = this.cars.get(idx);
        car.setMove(car.getMove().add(BigInteger.ONE));
        this.cars.set(idx, car);
    }

    public void setTryCount(Long tryCount) {
        this.tryCount = new TryCount(tryCount);
    }

    public Long getTryCount() {
        return tryCount.getTryCount();
    }
}
