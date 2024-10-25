package racingcar.domain;

import racingcar.utils.CarNameParser;
import racingcar.utils.RoundResultGenerator;
import racingcar.utils.WinnerDeterminer;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int tryCount;
    private int currentCount;

    public Race(String carNames, int tryCount) {
        this.cars = convertToCars(carNames);
        this.tryCount = tryCount;
        this.currentCount = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.forEach(Car::move);
        currentCount++;
    }

    public boolean isRaceOver() {
        return currentCount >= tryCount;
    }

    public List<String> getRoundResults() {
        return RoundResultGenerator.generate(cars);
    }

    public List<String> getWinners() {
        return WinnerDeterminer.determineWinners(cars);
    }

    private static List<Car> convertToCars(String carNames) {
        List<String> carNameList = CarNameParser.parse(carNames);

        return CarFactory.createCars(carNameList);
    }
}
