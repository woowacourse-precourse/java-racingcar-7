package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class RacingcarService {

    private final Cars cars = new Cars();
    private final TryCount tryCount = new TryCount();

    public void createCars(List<String> carNames) {
        cars.addAllByName(carNames);
    }

    public void setTryCount(int tryCount) {
        this.tryCount.set(tryCount);
    }

    public List<Car> playRound() {
        cars.playRound();
        tryCount.playRound();
        return cars.getCars();
    }

    public Cars getResult() {
        return cars;
    }

    public boolean isPlaying() {
        return tryCount.remain();
    }
}
