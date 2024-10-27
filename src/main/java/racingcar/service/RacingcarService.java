package racingcar.service;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.dto.CarDto;

public class RacingcarService {

    private final Cars cars = new Cars();
    private final TryCount tryCount = new TryCount();

    public void createCars(List<String> carNames) {
        cars.addAllByName(carNames);
    }

    public void setTryCount(int tryCount) {
        this.tryCount.set(tryCount);
    }

    public boolean isPlaying() {
        return tryCount.remain();
    }

    public List<CarDto> playRound() {
        cars.playRound();
        tryCount.playRound();
        return cars.getDto();
    }

    public List<CarDto> getResult() {
        return cars.getWinners();
    }
}
