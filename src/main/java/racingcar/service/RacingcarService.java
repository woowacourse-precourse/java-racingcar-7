package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class RacingcarService {

    private final Cars cars = new Cars();
    private final TryCount tryCount = new TryCount();

    public RacingcarService() {
    }

    public void createCars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public void setTryCount(int tryCount) {
        this.tryCount.set(tryCount);
    }

    public List<Car> playRound() {
        cars.playRound();
        return cars.getCars();
    }

    public Cars getResult() {
        return cars;
    }
}
